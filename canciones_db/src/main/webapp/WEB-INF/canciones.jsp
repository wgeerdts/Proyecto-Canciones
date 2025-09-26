<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
      <title>Lista de Canciones</title>
   </head>  
   <body>
      <h1>Lista de Canciones</h1>
      <ul>
         <c:forEach var="cancion" items="${listaCanciones}">
            <li>
               ${cancion.titulo} - ${cancion.artista}
               <a href="<c:url value='/canciones/detalle/${cancion.id}'/>">Detalle</a>
            </li>
         </c:forEach>
      </ul>
   </body>
</html>