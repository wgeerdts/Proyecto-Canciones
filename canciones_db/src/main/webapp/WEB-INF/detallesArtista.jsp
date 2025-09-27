<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
      <title>Detalles del Artista</title>
   </head>  
   <body>
      <h1>Detalles del Artista</h1>
      <p><strong>Nombre:</strong> ${artista.nombre} ${artista.apellido}</p>
      <p><strong>Biografía:</strong> ${artista.biografia}</p>
      <ul>
         <c:forEach var="cancion" items="${artista.canciones}">
            <li>
               ${cancion.titulo}  (${cancion.album})
            </li>
         </c:forEach>
      </ul>
      <a href="<c:url value='/artistas'/>">Volver a la lista de artistas</a>
   </body>
</html>