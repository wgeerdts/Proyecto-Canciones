<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
      <title>Lista de Artistas</title>
   </head>  
   <body>
      <h1>Lista de Artistas</h1>
      <ul>
         <c:forEach var="artista" items="${listaArtistas}">
            <li>
               <a href="<c:url value='/artistas/detalle/${artista.id}'/>">${artista.nombre} - ${artista.apellido}</a>
            </li>
         </c:forEach>
      </ul>
      <a href="<c:url value='/artistas/formulario/agregar'/>">Agregar Artista</a> <br>
      <a href="<c:url value='/canciones'/>">Ir a Canciones</a>
   </body>
</html>