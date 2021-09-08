<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>



<t:layout title="ROYALTY.Album">
	<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
		<h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>
	</div>
	<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">

		<h3>Liste des albums</h3>

		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th scope="col">Nom</th>
					<th scope="col">Date de parution</th>
					<th scope="col">Durée total</th>
					<th scope="col">Nombre de chansons</th>
					<th scope="col">Artistes</th>
					<th scope="col">Chansons</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ albums }" var="album">
					<tr>
						<td>${ album.nom }</td>
						<td>${ album.dateParution }</td>
						<td>${ album.dureeTotal }</td>
						<td>${ album.nombreChanson }</td>
						<td><a href="#?id=${ album.id}" class="btn"
							style="width: 200px; background-color: #02a675">Voir les artistes</a></td>
						<td><a href="#?id=${ album.id}" class="btn"
							style="width: 200px; background-color: #02a675">Voir les chansons</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</t:layout>









