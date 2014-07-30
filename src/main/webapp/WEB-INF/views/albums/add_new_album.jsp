<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<h2>Create new album</h2>
	<sf:form method="POST" modelAttribute="albums">  <!-- Связать форму -->
		<fieldset> 									<!-- с атрибутом модели -->
			<table>
				<tr>
					<th><label for="album_name">Album name:</label></th>
					<td>
						<sf:input path="albumName" size="15" id="album_name"/>
						<sf:errors path="albumName" cssClass="error" />
					</td>
				</tr>			
			</table>
		</fieldset>
		<input class="button" type="submit" value="Add album">
	</sf:form>
</div>