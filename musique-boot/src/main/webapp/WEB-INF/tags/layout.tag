<%@ attribute name="title"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>${ title}</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="assets/style.css">
</head>
<body>
	<div class="row">
		<div class="col-2 text-white bg-gradient"
			style="background-color: #1c1c1c;" id="menu">

			<ul class="list-unstyled ps-0"
				style="margin-top: 20px; font-size: 25px;">
				<a href="accueil-connecte">
					<button class="btn btn-toggle align-items-center rounded"
						style="background-color: #02a675; width: 275px; height: 85px;">
						<i class="bi bi-house" style="font-size: 25px;"></i>
						<h4>Accueil</h4>
					</button>
				</a>
				<li class="mb-3" style="margin-top: 50px">
					<button class="btn btn-toggle align-items-center rounded collapsed"
						data-bs-toggle="collapse" data-bs-target="#home-collapse"
						aria-expanded="true"
						style="background-color: #02a675; width: 200px; height: 50px;">
						<h4>Musique</h4>
					</button>
					<div class="collapse" id="home-collapse">
						<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
							<li><a href="royalty-artistes"
								class="link-light rounded;">Artistes</a></li>
							<sec:authorize access="hasRole('ADMIN')">
								<li><a href="royalty-ajouter-artiste" class="link-light rounded;">Ajouter un artiste</a></li>
							</sec:authorize>
							<li><a href="royalty-albums" class="link-light rounded">Albums</a></li>
							<sec:authorize access="hasRole('ADMIN')">
								<li><a href="royalty-ajouter-album" class="link-light rounded;">Ajouter un album</a></li>
							</sec:authorize>
							<li><a href="royalty-chansons"
								class="link-light rounded">Chansons</a></li>
							<sec:authorize access="hasRole('ADMIN')">
								<li><a href="royalty-ajouter-chanson" class="link-light rounded;">Ajouter une chanson</a></li>
							</sec:authorize>
						</ul>
					</div>
				</li>
				<li class="mb-3" style="margin-top: 25px">
					<button class="btn btn-toggle align-items-center rounded collapsed"
						data-bs-toggle="collapse" data-bs-target="#dashboard-collapse"
						aria-expanded="false"
						style="background-color: #02a675; width: 200px; height: 50px;">
						<h4>Mes playlists</h4>
					</button>
					<div class="collapse" id="dashboard-collapse">
						<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
							
							<c:forEach items="${ playlists }" var="playlist">
								<li><a href="liste-chansons-playlist?id=${ playlist.id}" class="link-light rounded">${ playlist.nom }</a></li>


							</c:forEach>

							<button
								class="btn btn-toggle align-items-center rounded collapsed"
								data-bs-toggle="collapse" data-bs-target="#newPlaylist-collapse"
								aria-expanded="false">
								<i class="bi bi-plus-circle-fill"
									style="color: #02a675; font-size: 25px;"></i>

							</button>
							<div class="collapse" id="newPlaylist-collapse">
								<form method="POST" action="royalty-ajouter-playlist">
									<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token }" />
									<input type="text" class="form-control mt-2 mb-2"
										id="nouvellePlaylist" placeholder="Ajouter playlist"
										name="nom">
									<button type="submit" class="btn btn-light">Valider</button>
								</form>
							</div>

						</ul>
					</div>
				</li>

				<li class="mb-1" style="margin-top: 25px">
					<button class="btn btn-toggle align-items-center rounded collapsed"
						data-bs-toggle="collapse" data-bs-target="#account-collapse"
						aria-expanded="false"
						style="background-color: #02a675; width: 200px; height: 50px;">
						<h4>Mon compte</h4>
					</button>
					<div class="collapse" id="account-collapse">
						<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small mt-3">
							<li><a href="royalty-mesPlaylists" class="link-light rounded">Voir mes playlists</a></li>
							<form method="POST" action="perform_logout">
								<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token }" />
								<input type="submit" class="btn btn-danger mt-4"  value="Se d&eacute;connecter"/>
							</form> 
						</ul>
					</div>
				</li>
			</ul>
		</div>


		<div class="container-fluid">
			<!-- Permet d'inclure le contenu dynamique -->
			<jsp:doBody></jsp:doBody>
		</div>
</body>
</html>