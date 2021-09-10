<%@ page contentType="text/html; charset=UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
								<th></th>
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
									<td><audio controls src="media/${ chanson.titre }.m4a"></audio></td>
									<td>${ chanson.titre }</td>
									<td class="duration">${ chanson.duree }</td>
									<td><a href="#?id=${ chanson.id }" class="btn"
											style="width: 200px; background-color: #02a675">Voir les
											albums</a></td>
									<td><a href="#?id=${ chanson.id }" class="btn"
											style="width: 200px; background-color: #02a675">Voir les
											artistes</a></td>

									<td>
										<form method="POST">
											<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token }" />
											<input type="hidden" name="chansonId" value="${chanson.id }">
											<input type="hidden" name="playlistId" value="${playlist.id }">
											<input type="submit" class="btn  mt"
												style="width: 200px; background-color: #02a675" value="enlever">
										</form>
									</td>



								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>

				<script>
					for (let td of document.querySelectorAll('.duration')) {
						td.textContent = new Date(parseInt(td.textContent) * 1000).toISOString().substr(11, 8);
					}
				</script>

			</t:layout>
			</body>

			</html>