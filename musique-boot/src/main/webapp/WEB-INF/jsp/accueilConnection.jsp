<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Royalty</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>

<body>
	<div class="container-fluid"
		style="display: grid; grid-template-rows: 130px auto 220px; height: 100vh;">
		<div class="row" style="grid-row: 1">
			<div class="col-12 text-white bg-gradient"
				style="background-color: #1c1c1c">
				<div class="text-center">
					<h1 style="font-size: 104px;">ROYALTY</h1>
				</div>
			</div>
		</div>

		<div class="row" style="grid-row: 2">
			<div class="col-12 text-center bg-gradient border-top"
				style="background-color: #02a675; padding-bottom: 20px;">
				<div style="margin-top: 45px;">
					<h2>Se connecter :</h2>
				</div>
				<form method="POST" style="width: 300px; margin: 0 auto;"action="/perform_login">
					<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token }" />
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">Email</label> <input
							type="email" name="username" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp">
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">Mot
							de passe</label> <input type="password" name="password"
							class="form-control" id="exampleInputPassword1">
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">Se
							souvenir de moi</label>
					</div>
					<div>
						<button type="submit" class="btn btn-dark">Connexion</button>
					</div>
				</form>
				<div>
					<h3>${ erreur }</h3>
				</div>
				<div style="margin-top: 30px;">
					<p>Vous n'avez pas de compte !?</p>
					<a href="royalty-inscription">
						<button type="button" class="btn btn-danger">S'inscrire
							:)</button>
					</a>

				</div>

			</div>

		</div>
		<div class="row bg-gradient border-top"
			style="grid-row: 3; background-color: #1c1c1c;">


			<div class="col-md-4 text-center text-white"
				style="margin-top: 50px;">
				<h4>Retrouve toutes les chansons libres de droits sur ROYALTY.</h4>
				<i class="bi bi-music-note-list" style="font-size: 50px;"></i>
			</div>
			<div class="col-md-4 text-center text-white"
				style="margin-top: 50px;">
				<h4>Profite de l'écoute et du téléchargement de milliers de
					chansons GRATUITEMENT.</h4>
				<i class="bi bi-speaker" style="font-size: 50px;"></i> <i
					class="bi bi-save-fill" style="font-size: 50px;"></i> <i
					class="bi bi-speaker" style="font-size: 50px;"></i>
			</div>
			<div class="col-md-4 text-center text-white"
				style="margin-top: 50px;">
				<h4 style="margin-bottom: 38px;">Crée des playlists ? l'infini
					!</h4>
				<i class="bi bi-collection-play" style="font-size: 50px;"></i>
			</div>


		</div>


	</div>

</body>

</html>