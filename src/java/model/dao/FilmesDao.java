/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.Filmes;

/**
 *
 * @author Senai
 */
public class FilmesDao {
    public List<Filmes> ler(){
        List<Filmes> filmes = new ArrayList();
        
        try {
         Connection conexao = Conexao.conectar();
         PreparedStatement stmt = null;
         ResultSet rs = null;
         
         stmt = conexao.prepareStatement("select * from film ");
         rs = stmt.executeQuery();
         
         while(rs.next()){
            Filmes filme = new Filmes();
            filme.setFilm_id(rs.getInt("film_id"));
            filme.setTitle(rs.getString("title"));
            filme.setDescription(rs.getString("description"));
            filme.setRelease_year(rs.getInt("release_year"));
            
            
            filmes.add(filme);
         }
        } catch(SQLException e){
             e.printStackTrace();
        }
        return filmes;
    }     
    
    
     public void cadastrar(Filmes filme) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
            stmt = conexao.prepareStatement("INSERT INTO film (title, description, release_year) VALUES (?,?,?)");
            stmt.setString(1, filme.getTitle());
            stmt.setString(2, filme.getDescription());
            stmt.setInt(3, filme.getRelease_year());
            
            
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
     
     
     
     public Filmes selecionarFilme(int id) {
       Filmes filmeSelecionado = new Filmes();
       try{
           Connection conn = conexao.Conexao.conectar();
           PreparedStatement stmt = null;
           ResultSet rs = null;
           
           stmt = conn.prepareStatement("SELECT * FROM film WHERE film_id = ?");
           stmt.setInt(1, id);
           
           rs = stmt.executeQuery();
           if(rs.next()){
               filmeSelecionado.setTitle(rs.getString("title"));
               filmeSelecionado.setDescription(rs.getString("description"));
               filmeSelecionado.setRelease_year(rs.getInt("release_year"));
               
           }
           rs.close();
           stmt.close();
           conn.close();
           
       } catch(SQLException e) {
           e.printStackTrace();
       }
       return filmeSelecionado;
     }
     
      public void deletar(int filme) {
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
        
            stmt = conexao.prepareStatement("DELETE FROM film WHERE film_id = ?");
            
            stmt.setInt(1,filme);
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
        
        } catch(SQLException e)  {
            e.printStackTrace();
        }
    }
      
      public void editar(Filmes filme) {
          
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = null;
            
        
            stmt = conexao.prepareStatement("UPDATE film SET title = ?, description = ?, release_year = ? WHERE film_id = ?");
            stmt.setInt(1, filme.getFilm_id());
            stmt.setString(2, filme.getTitle());
            stmt.setString(3, filme.getDescription());
            stmt.setInt(4, filme.getRelease_year());
            
            stmt.executeQuery();
            
            
            stmt.close();
            conexao.close();
        
        } catch(SQLException e)  {
            e.printStackTrace();
        }
    }
}













