package sci.category.certify.service.config

import groovy.util.logging.Slf4j
import org.postgresql.ds.PGSimpleDataSource
import org.testng.annotations.Test
import sci.category.certify.repo.util.SqlWork

import javax.sql.DataSource
import java.sql.ResultSet
import java.sql.Statement

@Test
@Slf4j

class AdhocPostgreSqlConnectionTest {

    final static def LIST_USERS = SqlWork.LIST_USERS

    void connectionTest() {
        try {
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
