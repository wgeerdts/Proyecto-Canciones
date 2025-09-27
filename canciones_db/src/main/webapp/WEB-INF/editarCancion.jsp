<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
      <title>Editar Canción</title>
   </head>  
   <body>
      <h1>Editar Canción</h1>
      <form:form action="/canciones/procesa/editar/${idCancion}" method="POST" modelAttribute="cancion">
      <input type="hidden" name="_method" value="PUT" />
         <div>
            <form:label path="titulo">Título: </form:label>
            <form:input path="titulo" />
            <form:errors path="titulo" />
         </div>
         <div>
            <label>Artista:</label>
            <select name="idArtista">
                  <c:forEach var="artista" items="${listaArtistas}">
                     <option value="${artista.id}"
                           <c:if test="${artista.id == cancion.artista.id}">selected</c:if>>
                           ${artista.nombre} ${artista.apellido}
                     </option>
                  </c:forEach>
               </select>
         </div>
         <div>
            <form:label path="album">Álbum: </form:label>
            <form:input path="album" />
            <form:errors path="album" />
         </div>
         <div>
            <form:label path="genero">Género: </form:label>
            <form:input path="genero" />
            <form:errors path="genero" />
         </div>
         <div>
            <form:label path="idioma">Idioma: </form:label>
            <form:input path="idioma" />
            <form:errors path="idioma" />
         </div>
         <br>
         <button>Editar</button>
      </form:form>
      <br>
      <a href="<c:url value='/canciones'/>">Volver a la lista de canciones</a>
   </body>
</html>