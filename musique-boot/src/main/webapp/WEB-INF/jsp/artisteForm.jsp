<%@ page contentType="text/html; charset=UTF-8" %>
	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
			<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>



				<t:layout title="ROYALTY.Accueil">
					<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
						<h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>
						

						<div>
							<c:if test="${artiste == null }">
								<h3>Ajouter un artiste</h3>
							</c:if>
							<c:if test="${artiste != null }">
								<h3>Modifier l'artiste</h3>
							</c:if>
							<form method="POST">
								<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token }" />
								<div class="mb-2">
									<label>Nom de l'artiste</label> <input type="text" name="nom"
										value="${artiste.nom }">
								</div>

								<div>
									<c:if test="${artiste == null }">
										<input type="submit" class="btn btn-danger" value=" Ajouter" />
									</c:if>
									<c:if test="${artiste != null }">
										<input type="submit" class="btn btn-danger" value=" Modifier" />
									</c:if>

								</div>
							</form>
						</div>

					</div>
				</t:layout>