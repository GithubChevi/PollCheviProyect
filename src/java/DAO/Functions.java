package DAO;

import java.sql.*;
import Model.*;
import java.util.ArrayList;

public class Functions {
    
    /*
    Este método esta obsoleto pero se usaria en el caso de usar solo un boton para
    log in y sign up
    */
    public boolean booleanKnownUser(User user,Connection con){
        boolean bool=false;
        String nif = user.getNif();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE nif = ?");
            ps.setString(1, nif);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                bool = true;
                
            }
        }
        catch(Exception e){
            
        }
            return bool;
    }
    /*
    Método para añadir un usuario a la base de datos
    */
    public boolean addUser(User user,Connection con){
        String nif = user.getNif();
        String pass = user.getPass();
        Crypt crypt = new Crypt();
        
        boolean b = false;
        
        try{
            String pass_en = crypt.encrypt(crypt.getKey(), crypt.getIv(), pass);
            PreparedStatement ps = con.prepareStatement("INSERT INTO user VALUES(null,?,?,'false')");
            ps.setString(1, nif);
            ps.setString(2,pass_en);
            ps.executeUpdate();
            b = true;
        }
        catch(Exception e){
            e.getMessage();
        }
        return b;
    }
    /*
    Método para conseguir los datos de la base de datos para compararlos con los
    introducidos en el formulario
    */
    public boolean getDataUser(User user, Connection con){
        String nif = user.getNif();
        String pass = user.getPass();
        boolean b=false;
        Crypt crypt = new Crypt();
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE nif = ?");
            ps.setString(1, nif);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                String nif_u = rs.getString("nif");
                String pass_u = rs.getString("password");
                String pass_de = crypt.decrypt(crypt.getKey(), crypt.getIv(),pass_u);
                if(pass_de.equals(pass) == true){
                    b = true;
                }
            }
        }
        catch(Exception e){
            
        }
        return b;
    }
    /*
    Método para comprobar si el usuario ya ha votado o no
    */
    public boolean userVoted(User user, Connection con){
        String nif = user.getNif();
        
        boolean b=false;
        
        try{
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE nif = ?");
            ps.setString(1, nif);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String voted_u = rs.getString("vote");
                if(voted_u.equals("true") == true){
                    b=true;
                }else{
                    b=false; 
                }
            }
        }
        catch(Exception e){
            
        }
        
        return b;
    }
    /*
    Método por el cual un usuario vota a un anime en este caso
    */
    public boolean vote(User user, Anime anime,Connection con){
        boolean b = false;
        String name_a = anime.getName();
        String nif_u = user.getNif();
        
        try{
            int cont=0;
            con.setAutoCommit(false);
            PreparedStatement ps1 = con.prepareStatement("UPDATE anime SET anime.votes = anime.votes +1 WHERE name = ?");
            ps1.setString(1, name_a);
            int num1=ps1.executeUpdate();
            if(num1 > 0)
                cont++;
            PreparedStatement ps2 = con.prepareStatement("UPDATE user SET vote = 'true' WHERE nif = ?");
            ps2.setString(1, nif_u);
            int num2=ps2.executeUpdate();
            if(num2 > 0)
                cont++;
            if(cont == 2){
                con.commit();
                b = true;
            }else{
                con.rollback();
            }
        }
        catch(SQLException sqle){
            sqle.getErrorCode();
        }
        return b;
    }
    /*
    Método para eliminar un usuario, es obvio que necesita introducir su contraseña
    y que coincida con la desencriptacion de la base de datos
    */
    public boolean deleteUser(User user, Connection con){
        boolean b=false;
        String nif_u=user.getNif();
        String pass_u=user.getPass();
        Crypt crypt = new Crypt();
        try{
            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM user WHERE nif = ?");
            ps1.setString(1, nif_u);
            ResultSet rs=ps1.executeQuery();
            if(rs.next()){
                String pass_en = rs.getString("password");
                
                String pass_de = crypt.decrypt(crypt.getKey(), crypt.getIv(), pass_en);
                if(pass_u.equals(pass_de)){
                    PreparedStatement ps2 = con.prepareStatement("DELETE FROM user WHERE nif = ?");
                    ps2.setString(1, nif_u);
                    int num2=ps2.executeUpdate();
                    if (num2 > 0){
                        b = true;
                    }
                }
            }   
        }
        catch(Exception e){
            
        }
        return b;
    }
    /*
    Comprueba que el usuario existe en la base de datos
    */
    public boolean validateUser(User user,Connection con){
        boolean b=false;
        String nif_u=user.getNif();
            try{
                PreparedStatement ps1 = con.prepareStatement("SELECT * FROM user WHERE nif = ?");
                ps1.setString(1, nif_u);
                ResultSet rs=ps1.executeQuery();
                if(rs.next()){
                    b = true;
                }
                else{
                    b = false;
                }
            }
            catch(Exception e){
                
            }
        return b;
    }
    /*
    Devuelve una lista con todos los animes de la base de datos por orden descendente (cabe
    destacar que mostramos por pantalla las imagenes recogidas desde la base de datos por 
    codificacion Base64 pero esta operacion la generamos en las vistas, es decir los .jsp)
    */
    public ArrayList<Anime> getList(Connection con){
        ArrayList<Anime> list = new ArrayList();
        try{
            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM anime ORDER BY votes DESC");
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                int votes = rs.getInt("votes");
                Blob img = rs.getBlob("img");
                //JOptionPane.showMessageDialog(null, image,"hi",JOptionPane.INFORMATION_MESSAGE);
                
                byte[] bytesimg = img.getBytes(1, (int)img.length());
                Anime anime = new Anime(name,votes,bytesimg);
                //JOptionPane.showMessageDialog(null, anime,"hi",JOptionPane.INFORMATION_MESSAGE);
                list.add(anime);
            }
        }catch(Exception e){
            
        }
        return list;
    }
    /*
    Devuelve una lista con todos los usuarios y si han votado o no
    */
    public ArrayList<User> getCensus(Connection con){
        ArrayList<User> list = new ArrayList();
        try{
            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM user ORDER BY nif DESC");
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                String nif = rs.getString("nif");
                String voted = rs.getString("vote");
                boolean vote;
                if(voted.equals("true") == true){
                    vote = true;
                }
                else{
                    vote = false;
                }
                User user = new User(nif,"",vote);
                list.add(user);
            }
        }
        catch(Exception e){
            
        }
        return list;
    }
    /*
    Devuelve el numero de votos maximo de nuestra base de datos(lo uso para comparar en otras
    funciones y para por sesion mostrar en el cierre de las votaciones para determinar
    un ganador)
    */
    public int getWinner(Connection con){
        int num = 0;
        try{
            PreparedStatement ps1 = con.prepareStatement("SELECT MAX(votes) as maxvotes FROM anime");
            ResultSet rs = ps1.executeQuery();
            if(rs.next()){
                num=rs.getInt("maxvotes");
            }
        }
        catch(Exception e){
            
        }
        return num;
    }
    /*
    Devuelve una lista de animes que tengas los votos maximos recogidos en la funcion anterior
    */
    public ArrayList<Anime> getListWinner(Connection con, int number){
        ArrayList<Anime> list = new ArrayList();
        try{
            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM anime WHERE votes = ?");
            ps1.setInt(1, number);
            ResultSet rs = ps1.executeQuery();
            while(rs.next()){
                String name = rs.getString("name");
                Blob img = rs.getBlob("img");
                byte[] bytesimg = img.getBytes(1, (int)img.length());
                Anime anime = new Anime(name,0,bytesimg);
                list.add(anime);
            }
        }
        catch(Exception e){
            
        }
        return list;
    }
}
