<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      
      <title>Agregar Artista</title>
   </head>  
   <body>
      <h1>Agregar Artista</h1>
      <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="nuevoArtista">
         <div>
            <form:label path="nombre">Nombre: </form:label>
            <form:input path="nombre" />
            <form:errors path="nombre" />
         </div>
         <div>
            <form:label path="apellido">Apellido: </form:label>
            <form:input path="apellido" />
            <form:errors path="apellido" />
         </div>
         <div>
            <form:label path="biografia">Biografía: </form:label> <br>
            <form:textarea path="biografia" rows="4" cols="30"/>
            <form:errors path="biografia" />
         </div>
         <br>
         <button>Agregar</button>
      </form:form>
      <br>
      <a href="<c:url value='/artistas'/>">Volver a la lista de artistas</a>
   </body>
</html>