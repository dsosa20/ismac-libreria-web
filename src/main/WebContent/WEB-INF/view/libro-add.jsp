<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri= %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>Libros</h1>
		<from  action="add" method="POST" enctype="multipart/from-data">
	 idLibro
	 <input type="hidden" id="idLibro" name="idLibro" value="${libro.idLibro}">
	 <br/><br/>
	 titulo
	 <input type="text" id="titulo" name="titulo" value="${libro.titulo}">
	 <br/><br/>
	 editorial
	 <input type="text" id="editorial" name="editorial" value="${libro.editorial}">
	 <br/><br/>
	 numPaginas
	 <input type="number" id="numPaginas" name="numPaginas" value="${libro.numPaginas}">
	 <br/><br/>
	 edicion
	 <input type="text" id="edicion" name="edicion" value="${libro.edicion}">
	 <br/><br/>
	 idioma
	 <input type="text" id="idioma" name="idioma" value="${libro.idioma}">
	 <br/><br/>
	 fechaPublicacion
	 <input type="date" id="fechaPublicacion" name="fechaPublicacion" value="${libro.fechaPublicacion}">
	 <br/><br/>
	 descripcion
	 <input type="text" id="descripcion" name="descripcion" value="${libro.descripcion}">
	 <br/><br/>
	 tipoPasta
	 <input type="text" id="tipoPasta" name="tipoPasta" value="${libro.tipoPasta}">
	 <br/><br/>
	 ISBN
	 <input type="text" id="ISBN" name="ISBN" value="${libro.ISBN}">
	 <br/><br/>
	 numEjemplares
	 <input type="number" id="numEjemplares" name="numEjemplares" value="${libro.numEjemplares}">
	 <br/><br/>
	 portada
	 <input type="text" id="portada" name="portada" value="${libro.portada}">
	 <br/><br/>
	 presentacion
	 <input type="text" id="presentacion" name="presentacion" value="${libro.presentacion}">
	 <br/><br/>
	 precio
	 <input type="number" step="any" id="precio" name="precio" value="${libro.precio}">
	 <br/><br/>

	 idAutor
	 <select id="idAutor" name="idAutor">
	 <c:forEach var="item" items="${autores }">
	    <option value="${item.idAutor}">${item.nombre} ${item.apellido}</option>
	    </c:forEach>
	 </select>	
	 <br/><br/>
	 Categoria
	 <select id="idCategoria" name="idCategoria">
	 <c:forEach var="item" items="${categorias }">
	    <option value="${item.idCategoria}">${item.categoria}</option>
	    </c:forEach>
	 </select>
	 <br/><br/>
		<button><a href="${pageContext.request.contextPath}/libros/findOne?idLibro=${item.idLibro}&opcion=1">Actualizar</a></button>
        <button><a href="${pageContext.request.contextPath}/Libros/findOne?idlibro=${item.idLibro}&opcion=2">Eliminar</button>
	</from>
</body>
</html>