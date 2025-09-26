<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
      <title>Detalles de la Cancion</title>
   </head>  
   <body>
      <h1>Detalles de la Canción</h1>
      <p><strong>Título:</strong> ${cancion.titulo}</p>
      <p><strong>Artista:</strong> ${cancion.artista}</p>
      <p><strong>Álbum:</strong> ${cancion.album}</p>
      <p><strong>Género:</strong> ${cancion.genero}</p>
      <p><strong>Idioma:</strong> ${cancion.idioma}</p>
      <br>
      <a href="<c:url value='/canciones'/>">Volver a la lista de canciones</a>
   </body>
</html>