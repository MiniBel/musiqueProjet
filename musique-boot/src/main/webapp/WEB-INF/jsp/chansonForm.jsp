<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
			<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

				<t:layout title="ROYALTY.Accueil">
					<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
						<h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>
					</div>
					<div class="container">
						<c:if test="${chanson == null }">
								<h3>Ajouter une chanson</h3>
							</c:if>
							<c:if test="${chanson != null }">
								<h3>Modifier la chanson</h3>
							</c:if>
						<form method="POST">
							<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token }" />
							<div class="row">
								<div class="col-2 col-form-label">
									<label class="form-label">Titre</label>
								</div>
		
								<div class="col-10">
									<input class="form-control" type="text" name="titre"
										value="${ chanson.titre }" />
								</div>
							</div>
		
							<div class="row">
								<div class="col-2 col-form-label">
									<label class="form-label">Dur�e</label>
								</div>
		
								<div class="col-10">
									<input class="form-control" type="text" name="duree"
										value="${ chanson.duree }" />
								</div>
							</div>
		
		
		
							<div class="row">
								<c:if test="${ chanson == null }">
									<input type="submit" class="btn btn-success" value="Ajouter" />
								</c:if>
		
								<c:if test="${ chanson != null }">
									<input type="submit" class="btn btn-warning" value="Modifier" />
								</c:if>
							</div>
						</form>

					</div>
				</t:layout>
				</body>

				</html>