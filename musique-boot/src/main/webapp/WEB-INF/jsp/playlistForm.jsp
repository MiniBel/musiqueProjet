<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t"%>



<t:layout title="ROYALTY.Album">
	<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
		<h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>
	</div>
	<div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">

		<h3>Modifier la playlist</h3>

		<form method="POST">
			<div>
				<label>Nom de la playlist</label> <input type="text" name="nom"
					value="${playlist.nom }">
			</div>
			<div>
				<input type="submit" class="btn btn-danger value=" Modifier"/>
			</div>
		</form>

	</div>

</t:layout>









