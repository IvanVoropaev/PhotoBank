<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	<s:url var="showAlbums" value="/showalbums" />
	<s:url var="addAlbum" value="/addalbum" />
	<p>Hello, <security:authentication property="principal.username" />!</p>
	<security:authorize access="hasRole('ADMIN')">
		<p>You're so cute!</p>
	</security:authorize>
	<security:authorize access="hasRole('USER')">
		<p>You're a peace of shit!</p>
		<p><a href="${showAlbums}">Albums</a></p>
		<p><a href="${addAlbum}">New album</a></p>
	</security:authorize>
</div>