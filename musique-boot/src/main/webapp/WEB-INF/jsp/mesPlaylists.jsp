<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>



<t:layout title="ROYALTY.MesPlaylists">
	<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
		<h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>
	</div>
	<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">

		<h3>Mes playlists</h3>

		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th scope="col">Nom</th>
					<th scope="col">Dur�e total</th>
					<th scope="col">Nombre de chansons</th>
					<th scope="col">Chansons</th>
					<th scope="col">Supprimmer / Modifier</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ playlists }" var="playlist">
					<tr>
						<td>${ playlist.nom }</td>
						<td>${ playlist.dureeTotal }</td>
						<td>${ playlist.nombreChanson }</td>
						<td><a href="liste-chansons-playlist?id=${ playlist.id}" class="btn"
							style="width: 200px; background-color: #02a675">Voir les
								chansons</a></td>
						<td><a href="royalty-modifier-playlist?id=${ playlist.id}"
							class="btn btn-warning mb-1" style="width: 150px">Modifier</a> <a
							href="royalty-supprimer-playlist?id=${ playlist.id }"
							class="btn btn-danger mb-1" style="width: 150px">Supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</t:layout>









