<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>



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
										<sec:authorize access="hasRole('ADMIN')">
											<th scope="col">Modifier / Supprimer</th>
										</sec:authorize>

									</tr>
								</thead>
								<tbody>
									<c:forEach items="${artistes }" var="artiste">
										<tr>
											<td>${artiste.nom }</td>

											<td>
												<a href="voirAlbums?id=${artiste.id }" class="btn"
													style="width: 200px; background-color: #02a675">Voir ses albums</a>
											</td>
											<sec:authorize access="hasRole('ADMIN')">
												<td>
													<a href="royalty-modifier-artiste?id=${artiste.id }"
														class="btn btn-warning">Modifier </a>
													<a href="royalty-supprimer-artiste?id=${artiste.id }"
														class="btn btn-danger">Supprimer</a>
												</td>
											</sec:authorize>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</t:layout>