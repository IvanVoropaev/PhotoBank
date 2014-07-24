<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div>
	<h2>Create a free account</h2>
	<sf:form method="POST" modelAttribute="users"> <!-- Связать форму -->
		<fieldset> <!-- с атрибутом модели -->
			<table>
				<tr>
					<th><label for="user_name">User name:</label></th>
					<td><sf:input path="userName" size="15" id="user_name"/></td>
				</tr>
				<tr>
					<th><label for="user_password">Password:</label></th>
					<td>
						<sf:password path="password" size="30" showPassword="true" id="user_password"/> <!-- Поле пароля -->
						<small>6 characters or more (be tricky!)</small>
					</td>
				</tr>
				<tr>
					<th><label for="user_email">Email Address:</label></th>
					<td>
						<sf:input path="userEmail" size="30" id="user_email"/> <!-- Поле электронной почты -->
						<small>In case you forget something</small>
					</td>
				</tr><tr>
					<th><label for="user_role">User Role:</label></th>
					<td>
						<sf:input path="userRole" size="30" id="user_role"/>
					</td>
				</tr>
				
			</table>
		</fieldset>
		<input class="button" type="submit" value="Register">
	</sf:form>
</div>