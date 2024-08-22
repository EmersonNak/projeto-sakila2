/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Senai
 */
public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/sakila";
    private static final String user = "root";       
    private static final String password = "";      
            
            
    public static Connection conectar() {
    Connection conexao = null;
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    conexao = DriverManager.getConnection(url, user, password);
    } catch(Exception e ){
    e.printStackTrace();
    }
     return conexao;
    }
}
