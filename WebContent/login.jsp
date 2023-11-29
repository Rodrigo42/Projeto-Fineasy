<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Fineasy - Login</title>
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body style="background-color: #9364B8;">
    
    <div class="container">

        <h1>FINEASY</h1>
        <h3 id="login" class="text-center text h3 mb-5 mt-5">LOGIN</h3>

        <form action="Login" method="post" class="container vstack align-items-center">
            <label for="user" class="lead">EMAIL:</label>
            <input type="email" name="email" id="user" placeholder="exemplo@outlook.com.br" class="w-50 border-1 my-2 lead">
            <label for="senha" class="lead">SENHA:</label>
            <input type="password" name="senha" id="senha" placeholder="**************" class="w-50 border-1 lead">
            <button type="submit" id="button" class=" btn w-25 my-4 text-center fs-6 lead">ACESSAR</button>
            <button class="btn w-25 my-4 text-center fs-6 lead" id="button"><a href="/Fineasy/Cadastro" class="text-decoration-none link-dark" id="button">CADASTRAR</a></button>

        </form>


    </div>






    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
  </body>
</html>