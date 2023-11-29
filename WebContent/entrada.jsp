<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
        <!-- Navbar -->
        <div class="container-fluid">
              <nav class="navbar">
                  <div class="container-fluid">
                    
                    <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <!-- <a class="navbar-brand h1" href="#" id="brand">FINEASY</a> -->
                    <h2 class="">FINEASY</h2>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">

                      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                          <a class="nav-link"  href="/Fineasy/Saldos">INICIO</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/Fineasy/Gasto">GASTOS</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/Fineasy/Entrada">GANHOS</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="/Fineasy/Login">SAIR</a>
                        </li>
                      </ul>
                      
                    </div>
                  </div>
                </nav>
        </div>
        
		<form action="Entrada" method="post">
	        <!-- Input number -->
	        <div class=" my-5 mx-auto w-50 text-center">
	            <label for="valor-rec" class="form-label lead fw-medium ">TOTAL RECEBIDO</label>
	            <div class="input-group">
	                <span class="input-group-text border-0 lead" id="span-valor-rec">R$</span>
	                <input type="number" name="valor" class="form-control border-0 lead text-success-emphasis" id="valor-rec">
	            </div>
	        </div>
	
	        <!-- Categoria -->
	        <div class=" my-5 mx-auto w-50 text-center">
	            <label for="cat" class="form-label lead fw-medium ">CATEGORIA</label>
	            <div class="input-group">
	                <span class="input-group-text border-0 lead" id="span-valor-rec">:</span>
	                <input type="text" name="cat" class="form-control border-0 lead text-success-emphasis" id="cat">
	            </div>
	
	        <div class="text-center my-5">
	            <button type="submit" class="btn p-2 px-5 my-4 text-center fs-6 lead" id="button">INSERIR</button>
	        </div>  
        </form>
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>