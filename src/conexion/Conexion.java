/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
//import com.sun.istack.internal.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ERIKA
 */
public class Conexion {
    private String user;
    private String pass;
    private String driver;
    private String url;
    
    private Connection cnx;
    
    public static Conexion instance;
    
    public synchronized static Conexion conectar(){
        if (instance==null){
            return new Conexion();
        }
        return instance;
    }
    
    private Conexion(){
        cargarCredenciales();
        
        try{//LE ENVIAMOS EL DRIVER QUE USARA PARA LA CONEXION DE BASE DE DATOS
            Class.forName(this.driver);//NOS PERMITE ABRIR UN CANAL PARA PODER ESTABLECER UNA CONEXION CON LA DB
            cnx=(Connection) DriverManager.getConnection(this.url, this.user, this.pass);
            //DriverManager.getConnection() DEVUELVE UN OBJETO CONNECTION, EL CUAL REPRESENTA LA CONEXION FISICA
            //A LA BASE DE DATOS. RECIBE COMO PARAMETROS:
            //--Url: ES EL LUGAR DONDE ESTA ALOJADO NUESTRA BD, ESTA SE RECIBE DE LA SIGUIENTE FORMA:
            //JDBC:mysql://server/nombre_db, EN DONDE EL SERVER ES LA DIRECCION IP O HOSTNAME DEL SERVIDOR
            //--USER: UDUARIO DE LA BD
            //--PASS: ES LA CONTRASEÑA DEL USUARIO DE USER
        }
        catch (ClassNotFoundException | SQLException ex){
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
//CREDENCIALES DE MI SERVIDOR DE LA BASE DE DATOS
    private void cargarCredenciales(){
        user="root";
        pass="";
        driver="com.mysql.jdbc.Driver";
        url="jbdc:mysql://localhost/filtros";
    }
    public Connection getCnx(){
        return cnx;
    }
    public void cerrarConexion(){
        instance=null;
    }
    //FIN DE LA CLASE CONEXION
}
