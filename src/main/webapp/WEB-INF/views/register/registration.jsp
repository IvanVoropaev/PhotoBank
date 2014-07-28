<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<h2>Create a free account</h2>
	<sf:form method="POST" modelAttribute="users"> <!-- Связать форму -->
		<fieldset> <!-- с атрибутом модели -->
			<table>
				<tr>
					<th><label for="user_name">User name:</label></th>
					<td>
						<sf:input path="userName" size="15" id="user_name"/>
						<sf:errors path="userName" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th><label for="user_password">Password:</label></th>
					<td>
						<sf:password path="password" size="30" showPassword="true" id="user_password"/>
						<sf:errors path="password" cssClass="error" /> <!-- Поле пароля -->
						<c:if test="${bindingResult.hasErrors}">
							<small>6 characters or more (be tricky!)</small>
						</c:if>
					</td>
				</tr>
				<tr>
					<th><label for="user_email">Email Address:</label></th>
					<td>
						<sf:input path="userEmail" size="30" id="user_email"/>
						<sf:errors path="userEmail" cssClass="error" /> <!-- Поле электронной почты -->
						<c:if test="${bindingResult.hasErrors}">
							<small>In case you forget something</small>
						</c:if>
					</td>
				</tr>			
			</table>
		</fieldset>
		<input class="button" type="submit" value="Register">
	</sf:form>
</div>