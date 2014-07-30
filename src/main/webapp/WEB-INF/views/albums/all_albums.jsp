<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	<c:forEach var="album" items="${albumList}">
		<spring:url var="albumUrl" value="/album?albumid=${album.id}" />
    	<a href="${albumUrl}"><c:out value="${album.albumName}"/></a> <br/>
	</c:forEach>
</div>