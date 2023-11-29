<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="style.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	<title>Fineasy - inicio</title>
</head>
<body style="background-color: #9364B8;">
	
	<%-- comment Agora vai em nome de Jesus<br> --%>
	
	
	 
	
	
	
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

        <!-- Cards -->
        <div class="container my-5" id="cards">

          <!-- card1 -->
          <a href="/Fineasy/Entrada">
            <div class="container text-center col-md-6 my-3">
              <div class="card">
                
                <div class="card-body">
                  <h5 class="card-title">TOTAL DE GASTOS NO MÊS</h5>
                  <p class="card-text text-danger">${gasto }</p>
                  
                </div>
              </div>
            </div>
          </a>


          <!-- card 2 -->
          <a href="/Fineasy/Gasto">
            <div class="container text-center col-md-6 my-3">
              <div class="card" >
                
                <div class="card-body">
                  <h5 class="card-title">TOTAL DE GANHOS NO MÊS</h5>
                  <p class="card-text text-success">${entrada }</p>
                  
                </div>
              </div>
            </div>
          </a>


          <!-- card 3 -->
          <a href="#">
            <div class="container text-center col-md-6 my-3">
              <div class="card" >
                <div class="card-body">
                  <h5 class="card-title text-dark">CATEGORIAS COM MAIS GASTOS</h5>
                  <div class="card-text text-center list-group mx-auto" id="card-list">
                    <a href="#" class="list-group-item list-group-item-action text-dark" id="list-item">${top1 }</a>
                    <a href="#" class="list-group-item list-group-item list-group-item-action text-dark" id="list-item">${top2 }</a>
                    <a href="#" class="list-group-item list-group-item list-group-item-action text-dark" id="list-item">${top3 }</a>
                  </div>

                </div>

              </div>

            </div>

          </a>


        </div>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>