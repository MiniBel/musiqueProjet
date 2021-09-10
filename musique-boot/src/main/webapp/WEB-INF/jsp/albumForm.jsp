<%@ page contentType="text/html; charset=UTF-8" %>
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>



				<t:layout title="ROYALTY.Accueil">
					<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
						<h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>
						

						<div>
							<c:if test="${album == null }">
								<h3>Ajouter un album</h3>
							</c:if>
							<c:if test="${album != null }">
								<h3>Modifier l'album</h3>
							</c:if>
							<form method="POST" class="row" style="margin: 0 auto">
								<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token }" />
								<div class="row mb-3">
									<label>Nom</label> <input type="text" name="nom"
										value="${ album.nom}">
								</div>
								<div class="row mb-2">
									<label>Date de parution</label>
								</div>
								<div class="col-md-4">
									<label for="inputJour" class="form-label">Jour</label> <input
										type="text" class="form-control" id="inputJour" name="jour">
								</div>
								<div class="col-md-4">
									<label for="inputMois" class="form-label">Mois</label> <select
										id="inputMois" class="form-select" name="mois">
										<option selected>Choisir...</option>
										<option>01</option>
										<option>02</option>
										<option>03</option>
										<option>04</option>
										<option>05</option>
										<option>06</option>
										<option>07</option>
										<option>08</option>
										<option>09</option>
										<option>10</option>
										<option>11</option>
										<option>12</option>
									</select>
								</div>
								<div class="col-md-4">
									<label for="inputAnnee" class="form-label">Année</label> <input
										type="text" class="form-control" id="inputAnnee" name="annee">
								</div>
								<div class="row mb-3">
									<c:if test="${ album == null}">
										<input type="submit" class="btn btn-success mt-3"
											value="Ajouter">
									</c:if>
									<c:if test="${ album != null}">
										<input type="submit" class="btn btn-warning mt-3"
											value="Modifier">
									</c:if>
		
								</div>
							</form>
						</div>

					</div>
				</t:layout>