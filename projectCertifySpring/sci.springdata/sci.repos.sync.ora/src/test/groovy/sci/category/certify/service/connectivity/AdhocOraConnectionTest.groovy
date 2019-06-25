package sci.category.certify.service.connectivity

import groovy.util.logging.Slf4j
import oracle.jdbc.driver.OracleConnection
import oracle.jdbc.pool.OracleDataSource
import org.testng.annotations.Test

import java.sql.ResultSet
import java.sql.Statement

@Test
@Slf4j
class AdhocOraConnectionTest{
    void connectionTest() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver")
            String DB_URL="jdbc:oracle:thin:@localhost:1521:ORCLCDB"
            OracleDataSource ds1=new OracleDataSource()
            Properties prop1 = new Properties()
            prop1.setProperty("user","sys as sysdba")
            prop1.setProperty("password","Oradoc_db1")
//            prop1.setProperty("internal_logon","sysdba")
            ds1.setConnectionProperties(prop1)
            ds1.setURL(DB_URL)
            OracleConnection conn1 = (OracleConnection)ds1.getConnection()
            Statement stmt = conn1.createStatement()
            ResultSet rs = stmt.executeQuery("select * from dba_users")
            while (rs.next())
                System.out.println(rs.getString(1))
            conn1.close()
        } catch (Exception e) {
            System.err.println(e)
        }
    }

}
