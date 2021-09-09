<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
			<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

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
									<th>Durée</th>
									<th>Album</th>
									<th>Artiste</th>
									<th></th>
									<sec:authorize access="hasRole('ADMIN')">
									<th>Modifier / Supprimer</th>
								</sec:authorize>
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
												<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token }" />
												<select name="playlistId">
													<c:forEach items="${playlists }" var="playlist">
														<option value="${playlist.id }">${playlist.nom }</option>
													</c:forEach>
												</select> <input type="hidden" name="chansonId" value="${chanson.id }">
												<input type="submit" class="btn  mt"
													style="width: 200px; background-color: #02a675" value="Ajouter chanson">
											</form>
										</td>
										<sec:authorize access="hasRole('ADMIN')">
										<td>
											<a href="royalty-modifier-chanson?id=${ chanson.id }"
												class="btn btn-warning">Modifier</a>
											<a href="royalty-supprimer-chanson?id=${ chanson.id }"
												class="btn btn-danger">Supprimer</a>
												<a href="royalty-detail-chanson?id=${ chanson.id }"
													class="btn btn-info mb-1" style="width: 150px">Détails</a>
										</td>
									</sec:authorize>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</t:layout>
				</body>

				</html>