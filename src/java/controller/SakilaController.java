/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Filmes;
import model.dao.FilmesDao;


@WebServlet(name = "SakilaController", urlPatterns = {"/SakilaController", "/sakila", "/cadastrar-filme", "/editar", "/excluir"})
public class SakilaController extends HttpServlet {

   
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
    }
   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String paginaAtual = request.getServletPath();
        
        List<Filmes> filmes = new ArrayList();
            
            FilmesDao filme = new FilmesDao();
            
        if(paginaAtual.equals("/sakila")){
                   
            filmes = filme.ler();
      
           request.setAttribute("filmes", filmes);
           
            request.getRequestDispatcher("/WEB-INF/jsp/sakila.jsp").forward(request, response);
            
        } else if(paginaAtual.equals("/cadastrar-filme")) {
            request.getRequestDispatcher("/WEB-INF/jsp/Cadastrar-filme.jsp").forward(request, response);  
            
        } else if(paginaAtual.equals("/editar")){
            int id = Integer.parseInt(request.getParameter("filme"));
            
            Filmes filmeAtual = filme.selecionarFilme(id);
            request.setAttribute("filme", id);
            request.setAttribute("titulo", filmeAtual.getTitle());
            request.setAttribute("descricao", filmeAtual.getDescription());
            request.setAttribute("ano", filmeAtual.getRelease_year());
            
            
            request.getRequestDispatcher("/WEB-INF/jsp/editar.jsp").forward(request, response); 
            
        } else if(paginaAtual.equals("/excluir")){
            int id = Integer.parseInt(request.getParameter("filme"));
            filme.deletar(id);
            response.sendRedirect("./sakila");
            }
    }

   
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String paginaAtual = request.getServletPath();
        
                if(paginaAtual.equals("/cadastrar-filme")) {
  
                Filmes filmeObj = new Filmes();
                filmeObj.setTitle(request.getParameter("titulo"));
                filmeObj.setDescription(request.getParameter("desc"));
                filmeObj.setRelease_year(Integer.parseInt(request.getParameter("ano")));
                

                FilmesDao filmeDao = new FilmesDao();
                filmeDao.cadastrar(filmeObj);
                response.sendRedirect("./sakila");
                
                } else if(paginaAtual.equals("/editar")) {
 
                    int id = Integer.parseInt(request.getParameter("filme"));
                    Filmes filmeAtual = new Filmes();
                    filmeAtual.setFilm_id(Integer.parseInt(request.getParameter("filme")));
                    filmeAtual.setTitle(request.getParameter("titulo"));
                    filmeAtual.setDescription(request.getParameter("desc"));
                    filmeAtual.setRelease_year(Integer.parseInt(request.getParameter("ano")));
                

                    
                    FilmesDao filmeDao = new FilmesDao();
                    filmeDao.editar(filmeAtual);
                
                    response.sendRedirect("./sakila");
                    }
            }

  
    
    public String getServletInfo() {
        return "Short description";
    }
    

    
     
}
