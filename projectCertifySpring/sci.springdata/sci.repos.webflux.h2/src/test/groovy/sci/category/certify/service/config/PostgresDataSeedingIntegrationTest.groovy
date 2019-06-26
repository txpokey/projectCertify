package sci.category.certify.service.config

import groovy.util.logging.Slf4j

import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

@Slf4j
//class PostgresDataSeedingIntegrationTest extends  PostgresViaSpringConnectionTest implements AutoCloseable {
class PostgresDataSeedingIntegrationTest {

    final static def INSERT_TEST_PRIME = """
        INSERT INTO dummytablename (id, prime, truth, species)
        VALUES (1, 1, true , 'adhoc');
"""

    final static def INSPECT_PRIMES = """ 
        select * from primes ;  
"""

    void connectionTest() {
        super.sanityCheck()
        super.connectionTest()
    }
    private bootstrapDidNotWork() {
        try {
            def (Statement stmt, Connection conn1) = getStatementFromDataSourcedConnection()
            // TODO: INSERT_TEST_PRIME did not work, but ignore this
            ResultSet rs = stmt.executeQuery(INSERT_TEST_PRIME as String)
            while (rs.next()) {
                reportOnListUsersQuery(rs)
            }
            conn1.close()
        } catch (Exception e) {
            log.error( e as String )
        }
    }
    Connection conn // TODO : threadsafe NOT
    void inspectPrimesWereBootstrappedSomehow() {
        try {
            def (Statement stmt, Connection conn1) = getStatementFromDataSourcedConnection()
            conn = conn1
            ResultSet rs = stmt.executeQuery(INSPECT_PRIMES as String)
            while (rs.next()) {
                reportOnListPrimesQuery(rs)
            }
        } catch (Exception e) {
            log.error( e as String )
        }
    }
    @Override
    void close() throws Exception {
        if (conn.isOpen()) {
            conn.close()
        }
    }
}
