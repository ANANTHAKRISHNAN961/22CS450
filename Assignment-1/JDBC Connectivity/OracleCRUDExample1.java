import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class OracleCRUDExample1
{
static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
static final String USER = "anand";
static final String PASSWORD = "krish";
public static void main(String[] args) {
Connection connection = null;
Statement statement = null;
try {
Class.forName("oracle.jdbc.driver.OracleDriver");
connection =DriverManager.getConnection(URL, USER, PASSWORD); 
statement =connection.createStatement();

// CREATE Inserting data into the database 
String insertQuery = "INSERT INTO login VALUES ('Anand961', 'anand961@gmail.com')"; 
statement.executeUpdate(insertQuery); 
System.out.println("Data inserted successfully.");

// READ Retrieving data from the database 
String selectQuery = "SELECT * FROM LOGIN"; 
ResultSet resultset= statement.executeQuery(selectQuery); 
while (resultset.next())
 { String username= resultset.getString("userid");
 String userid = resultset.getString("mailid");
System.out.println("Name:" + username + ", ID: " + userid);
}
// UPDATE Modifying data in the database

String updatequery ="UPDATE login set mailid='krish@gmail.com' where userid = 'krish' "; 
statement.executeUpdate(updatequery);

System.out.println("Data updated successfully.");

// DELETE Deleting data from the database 
String deleteQuery = "DELETE FROM login WHERE userid='krish'";
statement.executeUpdate(deleteQuery); 
System.out.println("Data deleted successfully.");

} catch (SQLException e) {

e.printStackTrace();

}catch ( ClassNotFoundException e) {

e.printStackTrace();

} finally {

// closing resources

try {

if (statement != null) statement.close(); 
if (connection != null) connection.close();

} catch (SQLException e) { e.printStackTrace();}}}}