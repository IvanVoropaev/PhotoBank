<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
	<c:forEach var="photo" items="${photoAlbum}">
    	<c:out value="${photo.path}"/> <br/>
	</c:forEach>
	<spring:url var="addPhoto" value="addphoto?album=${album.id}"></spring:url>
	<sf:form action="${addPhoto}" modelAttribute="photos" enctype="multipart/form-data">
		<label for="image">Profile image:</label><br>
		<input name="image" type="file" class="button"/><br>
  		<sf:input path="path" class="button" type="submit" value="Add photo" />
  	</sf:form>
</div>