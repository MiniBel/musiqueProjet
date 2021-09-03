<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>

<t:layout title="Liste des chansons">
	<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
		<h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>

	</div>
	<div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Titre</th>
					<th>Durée</th>
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
						<td><a href="#?id=${ chanson.id }" class="btn btn-primary">Voir
								les albums</a></td>
						<td><a href="#?id=${ chanson.id }" class="btn btn-primary">Voir
								les artistes</a></td>

						<td><a href="#?id=${ chanson.id }" class="btn btn-primary">Ajouter
								à la playlist</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</t:layout>
</body>
</html>











