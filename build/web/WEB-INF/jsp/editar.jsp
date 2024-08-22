<%-- 
    Document   : Editar
    Created on : 19/08/2024, 16:31:56
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>Editar Filme</title>
    </head>
    <body>
        <h1> Editar Filme</h1>
        <form action="./editar" method="post">
            
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInputTitle" name="titulo" placeholder="Titulo" value="${title}">
                <label for="floatingInputTitle">Titulo</label>
            </div>
            
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInputDesc" name="desc" placeholder="Descrição" value="${description}">
                <label for="floatingInputDesc">Descrição</label>
            </div>
            
            <div class="form-floating mb-3">
                <input type="number" class="form-control" id="floatingInputAno" name="ano" placeholder="Ano" value="${release_year}">
                <label for="floatingInputAno">Ano</label>
            </div>
            
            <div class="form-floating mb-3">
                <button class="btn btn-secondary" type="submit">Editar</button>
            </div>
        </form>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
