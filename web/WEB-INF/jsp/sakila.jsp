<%-- 
    Document   : sakila
    Created on : 13/08/2024, 15:15:23
    Author     : Senai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Livros</title>
        <link rel="stylesheet" href="../styles/teste.css">
        
    </head>
    <body>
        <h1>Lista de Filmes</h1>
        
       
           <table border="2"> 
               <thead>
               <th>
                   
               <td> Id</td>
               <td> titulo</td>
               <td> Descrição</td>
               <td> Ano</td>
               <td> Ações</td>
                   
               </th> 
               </thead>
               
               <tbody>
                   <c:forEach var="filme" items="${filmes}">
                   <tr>
                    <td></td>   
                    <td>${filme.film_id}</td>   
                    <td>${filme.title}</td>   
                    <td>${filme.description}</td>   
                    <td>${filme.release_year}</td>   
                    <td>
                        <a href="./editar?filme=${filme.film_id}"><button type="button" class="btn btn-info"><i class="fa-solid fa-pen"></i></button></a>
                           
                        
                        <a href="./excluir?filme=${filme.film_id}"><button type="button" class="btn btn-danger"><i class="fa-solid fa-trash"></i></button></a>
                    </td>
                   </tr>
               </c:forEach>
                   
               </tbody>
           </table>
            
        
            
            
        
        <a href="./cadastrar-filme"><button type="button" class="btn btn-primary">Cadastrar Novo Filme</button></a>
        
        <script src="https://kit.fontawesome.com/a660163d48.js" crossorigin="anonymous"></script>
       <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
