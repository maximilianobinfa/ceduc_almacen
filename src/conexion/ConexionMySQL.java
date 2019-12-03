
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    
    private static String driver = "com.mysql.jdbc.Driver";
    private static String database = "Ceduc_almacen";
    private static String hostname = "localhost";
    private static String port = "3306";
    private static String username = "root";
    private static String password = "12345678";
    private static String ConnectionURL;
    public static Connection conn;
    
    public ConexionMySQL(){
        this.ConnectionURL = "jdbc:mysql://";
        this.ConnectionURL += hostname + ":" + port + "/" + database;
        this.ConnectionURL += "?autoReconnect=true&useSSL=false";
        System.out.println(this.ConnectionURL);
        this.getConnection();
    }
    
    
    public static Connection getConnection(){
        try {
            Class.forName(driver);
            try {
                ConexionMySQL.conn = DriverManager.getConnection(ConnectionURL, username, password);
            } catch(SQLException e){
                System.out.println("No se puede conectar: "+e.getMessage());
            }
        } catch(ClassNotFoundException ex){
            System.out.println("La clase  "+driver +" no exite en el sistema");
        }
        return conn;
}
}