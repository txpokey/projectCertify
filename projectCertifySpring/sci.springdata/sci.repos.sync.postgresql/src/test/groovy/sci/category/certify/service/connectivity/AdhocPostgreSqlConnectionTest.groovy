package sci.category.certify.service.connectivity

import groovy.util.logging.Slf4j
import org.postgresql.ds.PGSimpleDataSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests
import org.testng.annotations.Test

import javax.sql.DataSource
import java.sql.ResultSet
import java.sql.Statement

@Test
@Slf4j
//@SpringBootTest
//class AdhocPostgreSqlConnectionTest extends AbstractTestNGSpringContextTests {
class AdhocPostgreSqlConnectionTest {

//    @Autowired
//    private Environment env
//
//    void sanityCheck() {
//        def url = env.getProperty("spring.datasource.url")
//        assert url == "jdbc:postgresql://127.0.0.1:5432/postgres"
//    }
    final static def LIST_USERS = """
        select usesysid as user_id,
               usename as username,
               usesuper as is_superuser,
               passwd as password_md5,
               valuntil as password_expiration
        from pg_shadow
        order by usename;
"""
    void connectionTest() {
        try {
            def driver = Class.forName("org.postgresql.Driver")
//            String DB_URL=env.getProperty("spring.datasource.url")
            String DB_URL="jdbc:postgresql://127.0.0.1:5432/postgres"
            DataSource ds=new PGSimpleDataSource()
            ds.setUser("postgres")
            ds.setPassword("pokey0")
            ds.setURL(DB_URL)
            def conn1 = ds.getConnection()
            Statement stmt = conn1.createStatement()
            ResultSet rs = stmt.executeQuery(LIST_USERS as String)
            while (rs.next())
            {
                System.out.println(rs.getString("user_id"))
                System.out.println(rs.getString("username"))
                System.out.println(rs.getString("password_md5"))
            }
            conn1.close()
        } catch (Exception e) {
            System.err.println(e)
        }
    }
}
