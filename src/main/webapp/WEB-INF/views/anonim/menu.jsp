<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
  <s:url var="authUrl" value="/security_check" />
  <form method="post" class="signin" action="${authUrl}">
    <div class="label">Username or Email</div>
    <div class="labeled">
      <input id="username_or_email" name="j_username" type="text"/>
    </div>
    <div class="label">Password</div>
    <div class="labeled">
      <input id="password" name="j_password" type="password"/>
    </div>
    <input class="button" type="submit" value="Sign in">
    
  </form> 
  <form action="register">
  	<input class="button" type="submit" value="Register">
  </form>
  
</div>
