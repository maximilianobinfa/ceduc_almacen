
package Clases;
import conexion.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {
    private int _id_usuario;
    private String _apodo;
    private String _clave;
    private int _vigente;
    
    
    public Usuario() {
        
    }
    /**
     * valida que el usuario y la constraseña sean valido
     * @param usuario string nombree acceso
     * @param clave string clave acceso
     * @return 
     */
    public static boolean conectar(String usuario, String clave) {
        boolean valido = false;
        // generamos la instancia a la clase conexionMySQL
        ConexionMySQL sql = new ConexionMySQL();
        // Creamos el String para la consulta a la base de datos
        String query = "SELECT * FROM usuario ";
        query += "WHERE apodo = '" + usuario + "' ";
        query += "AND clave = '" + clave + "';";
        
        System.out.println(query);
        
        try {
            
            Statement s = sql.conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            
            int filas = 0;
            while(rs.next()){
                filas++;
                // filas = filas + 1;
            }
            if (filas == 1) {
                valido = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valido;
    }
}
