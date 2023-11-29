<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.com.fineasy.model.Entrada" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="ISO-8859-1">
<title>Fineasy - Extrato</title>
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
	<h3>Extrato da conta</h3>
	<form action="ExtratoLista" method="post">
	
		<select name="extratoOpt">
			<option value="">Selecione</option>
			<option value="optEntradas">Entradas</option>
			<option value="optGastos">Gastos</option>
		</select>
		<button type="submit" class="btn p-2 px-5 my-4 text-center fs-6 lead" id="button">SELECIONAR</button>
	</form>
	<br>
	<c:set var = "opt" scope="session" value="${opt }"></c:set>
	<c:if test="${opt == true}">
	<br>
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Categoria</th>
					<th>Valor</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${resultado}" var="resultado">
					<tr>
						<td>${resultado.id}</td>
						<td>${resultado.valorDeEntrada}</td>
						<td>${resultado.catEntrada}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${opt == false}">
		<table>
			<thead>
				<tr>
					<th>#</th>
					<th>Categoria</th>
					<th>Valor</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultado}" var="resultado">
					<tr>
						<td>${resultado.id}</td>
						<td>${resultado.categoriaDeGasto}</td>
						<td>${resultado.saldoDeGasto}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>