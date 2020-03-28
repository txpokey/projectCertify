package sci.category.certify.service.connectivity

import groovy.util.logging.Slf4j
import org.postgresql.ds.PGSimpleDataSource
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test
import sci.category.certify.repo.util.SqlWork

import javax.sql.DataSource
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

@Test
@Slf4j
@SpringBootTest
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "spring.datasource")
@Profile("default")
class PostgresViaSpringConnectionTest extends AbstractTestNGSpringContextTests{
    String username
    String password
    String url

    void sanityCheck() {
        assert username
        assert password
        assert url
    }
    final static def LIST_USERS = SqlWork.LIST_USERS

    void connectionTest() {
        try {
            def (Statement stmt, Connection conn1) = getStatementFromDataSourcedConnection()
            ResultSet rs = stmt.executeQuery(LIST_USERS as String)
            while (rs.next()) {
                reportOnListUsersQuery(rs)
            }
            conn1.close()
        } catch (Exception e) {
            log.error( e as String )
        }
    }

    protected getStatementFromDataSourcedConnection() {
        final def dsConstructorMap = [
                user    : username,
                password: password,
                url     : url,
        ]

        final DataSource ds = new PGSimpleDataSource(dsConstructorMap)
        def conn1 = ds.getConnection()
        Statement stmt = conn1.createStatement()
        [stmt, conn1]
    }

    protected reportOnListUsersQuery(ResultSet rs) {

        fieldsForReporting.each { f -> reportOnFieldReturnedFromListUsersQuery(rs, f) }
    }
    protected reportOnListPrimesQuery(ResultSet rs) {

        fieldsForReportingPrimes.each { f -> reportOnFieldReturnedFromListUsersQuery(rs, f) }
    }

    protected reportOnFieldReturnedFromListUsersQuery(ResultSet rs, String field) {
        def candidate = rs.getString(field)
        log.debug(candidate)
        candidate
    }
    final static def fieldsForReporting = [
            'user_id',
            'username',
            'password_md5',
    ]
    final static def fieldsForReportingPrimes = [
            'id',
            'prime',
            'truth',
            'species',
    ]
}
