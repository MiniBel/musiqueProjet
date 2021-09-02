<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Royalty.Accueil</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="assets/style.css">
</head>

<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-2 text-white bg-gradient"
				style="background-color: #1c1c1c;" id="menu">

				<ul class="list-unstyled ps-0"
					style="margin-top: 20px; font-size: 25px;">
					<a href="accueilConnect.html">
						<button class="btn btn-toggle align-items-center rounded"
							style="background-color: #02a675; width: 275px; height: 85px;">
							<i class="bi bi-house" style="font-size: 25px;"></i>
							<h4>Accueil</h4>
						</button>
					</a>
					<!-- <li class="mb-3"style="margin-top:50px">
                        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse"
                            data-bs-target="#home-collapse" aria-expanded="true" style="background-color: #02a675;width: 200px;height: 50px;">
                            <h4>Musique</h4>
                        </button>
                        <div class="collapse" id="home-collapse">
                            <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                                <li><a href="artiste.html" class="link-light rounded;">Artistes</a></li>
                                <li><a href="#" class="link-light rounded">Albums</a></li>
                                <li><a href="#" class="link-light rounded">Chansons</a></li>
                                <li><a href="#" class="link-light rounded">Genre</a></li>
                            </ul>
                        </div>
                    </li> -->
					<li class="mb-3" style="margin-top: 50px">
						<button
							class="btn btn-toggle align-items-center rounded collapsed"
							data-bs-toggle="collapse" data-bs-target="#dashboard-collapse"
							aria-expanded="false"
							style="background-color: #02a675; width: 200px; height: 50px;">
							<h4>Mes playlists</h4>
						</button>
						<div class="collapse" id="dashboard-collapse">
							<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
								<li><a href="#" class="link-light rounded">Favoris</a></li>
								<li><a href="#" class="link-light rounded">Aimées</a></li>

								<button
									class="btn btn-toggle align-items-center rounded collapsed"
									data-bs-toggle="collapse"
									data-bs-target="#newPlaylist-collapse" aria-expanded="false">
									<i class="bi bi-plus-circle-fill"
										style="color: #02a675; font-size: 25px;"></i>

								</button>
								<div class="collapse" id="newPlaylist-collapse">
									<input type="text" class="form-control mt-2 mb-2"
										id="nouvellePlaylist" placeholder="Ajouter playlist">
									<button type="submit" class="btn btn-light">Valider</button>
								</div>

							</ul>
						</div>
					</li>

					<li class="mb-1">
						<button
							class="btn btn-toggle align-items-center rounded collapsed"
							data-bs-toggle="collapse" data-bs-target="#account-collapse"
							aria-expanded="false"
							style="background-color: #02a675; width: 200px; height: 50px;">
							<h4>Mon compte</h4>
						</button>
						<div class="collapse" id="account-collapse">
							<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
								<li><a href="#" class="link-light rounded">Mon profil</a></li>
								<li><a href="#" class="link-light rounded">Paramètres</a></li>
								<li><a href="accueil.html" class="link-light rounded">Se
										déconnecter</a></li>
							</ul>
						</div>
					</li>
				</ul>
			</div>

			<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
				<h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>

				<input type="search">
			</div>

		</div>

	</div>
	</div>
</body>

</html>