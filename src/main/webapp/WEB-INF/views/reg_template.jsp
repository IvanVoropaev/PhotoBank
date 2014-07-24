<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link type="text/css" rel="stylesheet" href="<spring:url value="resources/css/photobank.css"/>" />
    <title><tiles:insertAttribute name="title"/></title>
  </head>
  
  <body>
    <table class="main">
      <tr class="main">
        <td class="main">
          <tiles:insertAttribute name="top"/>
        </td>
      </tr>
      <tr>
        <td class="main">
          <tiles:insertAttribute name="register"/>
        </td>
      </tr>
      <tr class="main">
        <td class="main">
          <tiles:insertAttribute name="bottom"/>
        </td>
      </tr>
    </table>
  </body>
</html>