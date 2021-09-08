<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>



<t:layout title="ROYALTY.Accueil">
	<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
		<h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>
		<h3>Liste des artistes</h3>
		<div>
			<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">Nom</th>
							<th scope="col">Voir Albums</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${artistes }" var="artiste">
							<tr>
								<td>${artiste.nom }</td>

								<td>
									<a href="voirAlbums?id=${artiste.id }" class="btn" style="width: 200px; background-color: #02a675">Voir ses albums</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
	</div>
</t:layout>