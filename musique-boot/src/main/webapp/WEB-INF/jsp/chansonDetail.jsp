<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
            <%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

                <t:layout title="ROYALTY.Accueil">
                    <div class="col-12 text-center" style="color: #02a675;" id="ROYALTY">
                        <h1 class="border-bottom" style="font-size: 104px;">ROYALTY</h1>
                        <h3>Liste des albums</h3>
                    </div>

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Nom de l'album</th>

                                <th scope="col">Album associé</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${albums }" var="album">
                                <tr>
                                    <td>${album.nom }</td>

                                    <td>
										<form method="POST">
											<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token }" />
											<input type="hidden" name="chansonId" value="${chanson.id }">
											<input type="hidden" name="albumId" value="${album.id }">
											<input type="submit" class="btn  mt"
												style="width: 200px; background-color: #02a675" value="associer">
										</form>
									</td>
                                    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </t:layout>
                </body>

                </html>