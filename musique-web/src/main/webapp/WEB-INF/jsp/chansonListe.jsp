<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<t:layout title="ROYALTY.Accueil">
	<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
		<h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>
		<h3>Liste des chansons</h3>
	</div>
	<div>
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th>Titre</th>
					<th>Dur?e</th>
					<th>Album</th>
					<th>Artiste</th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${ chansons }" var="chanson">
					<tr>
						<td>${ chanson.titre }</td>
						<td>${ chanson.duree }</td>
						<td><a href="#?id=${ chanson.id }" class="btn"
							style="width: 200px; background-color: #02a675">Voir les
								albums</a></td>
						<td><a href="#?id=${ chanson.id }" class="btn"
							style="width: 200px; background-color: #02a675">Voir les
								artistes</a></td>

						<td>
							<form method="POST">
								<select name="playlistId">
									<c:forEach items="${playlists }" var="playlist">
										<option value="${playlist.id }">${playlist.nom }</option>
									</c:forEach>
								</select> <input type="hidden" name="chansonId" value="${chanson.id }">
								<input type="submit" class="btn  mt-3"
									style="width: 200px; background-color: #02a675" value="Ajouter">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</t:layout>
</body>
</html>











