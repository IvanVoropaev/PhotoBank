<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
	<sec:authorize access="isAuthenticated()">
		<small>Your name is: <sec:authentication property="principal.username" />
		<a href="<c:url value="/logout" />">Logout</a></small>
	</sec:authorize>
</div>