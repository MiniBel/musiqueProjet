<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Royalty.Inscription</title>
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
</head>

<body>
	<div class="container-fluid">
		<div class="row ">
			<div class="col-12">
				<div class="text-center">
					<h1 style="font-size: 104px; color: #02a675;">ROYALTY</h1>
				</div>
				<div class="text-center mt-1">
					<h3>Inscrivez-vous gratuitement !</h3>
				</div>
			</div>
		</div>
		<div class="row">
			<form class="row g-3" style="width: 500px; margin: 0 auto;" method="POST">
				<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token }" />
				<div class="col-12">
					<label for="inputEmail4" class="form-label">Email</label> <input
						type="email" class="form-control" id="inputEmail4" name="email">
						<p> ${ erreur }</p>
				</div>
				<div class="col-12">
					<label for="inputPassword4" class="form-label">Mot de passe</label>
					<input type="password" class="form-control" id="inputPassword4" name="password">
				</div>
				<div class="col-12">
					<label for="inputPassword4" class="form-label">Confirmer
						mot de passe</label> <input type="password" class="form-control"
						id="inputPassword4" name="passwordConfirm">
						<p> ${ erreur2 }</p>
				</div>
				<div class="col-12">
					<label for="inputNom" class="form-label">Nom</label> <input
						type="text" class="form-control" id="inputNom" name="nom">
				</div>
				<div class="col-12">
					<label for="inputPrenom" class="form-label">Pr�nom</label> <input
						type="text" class="form-control" id="inputPrenom" name="prenom">
				</div>
				<div class="col-12">
					<label for="DateDeNaissance">Date De Naissance</label>

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
					<label for="inputAnnee" class="form-label">Ann�e</label> <input
						type="text" class="form-control" id="inputAnnee" name="annee">
				</div>

				<div class="col-12">
					<div class="form-check">
						<input class="form-check-input" type="checkbox" id="gridCheck">
						<label class="form-check-label" for="gridCheck"> Se
							souvenir de moi </label>
					</div>
				</div>
				<div class="col-12 text-center">
					<button type="submit" class="btn btn-dark" style="color: #02a675;">S'inscrire</button>
				</div>
			</form>
		</div>
		<div class="row text-center mt-3">
			<label for="Connexion">Vous avez d�j� un Compte ?</label> <a
				href="accueil-connection" style="color: #02a675;">Cliquez ici</a>
		</div>
	</div>





</body>

</html>