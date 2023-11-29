<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Fineasy - cadastro</title>
</head>
<body style="background-color: #9364B8;">
	<h1>Cadastro</h1>
	
	<form action="Cadastro" method="post" class="text-center mt-5">
	  <div class="mb-3">
	    <label for="nome" class="form-label">Nome e sobrenome</label>
	    <input name="nome" type="text" class="form-control-sm" id="nome" aria-describedby="nomeHelp">
	  </div>
	  <div class="mb-3">
	    <label for="email" class="form-label">Email</label>
	    <input name="email" type="email" class="form-control-sm" id="email">
	  </div>
	  <div class="mb-3">
	    <label for="senha" class="form-label">Senha</label>
	    <input name="senha" type="password" class="form-control-sm" id="senha">
	  </div>
	  <div class="mb-3">
	    <label for="nascimento" class="form-label">Data de Nascimento</label>
	    <input name="nasc" type="date" class="form-control-sm" id="nascimento">
	  </div>
	  <div class="mb-3">
	    <label for="telefone" class="form-label">Telefone</label>
	    <input name="tel" type="text" class="form-control-sm" id="telefone">
	  </div>
	  
	  <button type="submit" class="btn w-25 my-4 text-center fs-6" id="button">Cadastrar</button>
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>