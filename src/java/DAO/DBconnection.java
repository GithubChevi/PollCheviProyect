package DAO;

import java.sql.*;

public class DBconnection {
    
    static Connection con;
    private static DBconnection instance = null;
    
    private DBconnection() throws ClassNotFoundException, SQLException{
        /*
        Tendremos un String para la base de datos y otro con la url para poder
        manejarlo mas comodamente
        */
        Class.forName("com.mysql.jdbc.Driver");
        String db = "bd_encuesta_chevi";
        String url = "jdbc:mysql://localhost/"+db;
        con = DriverManager.getConnection(url,"root","root");
    }
    
    public static DBconnection getInstance() {
        if(instance == null){
            setConnection();
        }
        return instance;
    }
    
    public static void delInstance(){
        instance = null;
        closeConnection();
    }
    
    public static Connection setConnection(){
        /*
        Conexion con la base de datos especifica y puntual
        */
        String db = "bd_encuesta_chevi";
        String url = "jdbc:mysql://localhost/"+db;
        String user = "root";
        String pass = "root";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection enabled");
            return c;
        }
        catch(ClassNotFoundException | SQLException e){
            System.out.println("Error : Cannot open the connection");
            Connection c = null;
            return c;
        }
    }
    
    public static void closeConnection(){
        /*
        para cerrar la conexion en algun punto especifico
        */
        try{
            con.close();
        }
        catch(Exception e){
            System.out.println("Error : Cannot close the connection");
        }
    }
    
    public synchronized static DBconnection getConnection() throws ClassNotFoundException, SQLException{
        if(instance == null){
            instance = new DBconnection();
        }
        return instance;
    }
    public Connection getCon(){
        return con;
    }
    
}
