<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="container">
	<div style="background-color: #eee;padding-left: 15px;padding-top: 1px;padding-bottom: 10px;border-radius: 5px;margin-bottom:  15px;">
		<h3>Liste des apprenants: (${mesApprenants.size()})</h3>
	</div>

	<div class="alert alert-warning alert-dismissible" style="background-color: #ECC35C">
		Sélectionnez l'apprenant dont vous souhaitez connaître les missions en cliquant sur le bouton <strong>Missions</strong>
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>

	<div class="container" style="padding: 0;">
		<h2>Tableau des apprenants</h2><br/>
		<div class="container" style="padding: 0;">
			<table class="table table-hover">
				<tr>
					<th class="col-md-1 text-center">Numero</th>
					<th class="col-md-2 text-center">Nom de l'apprenant</th>
					<th class="col-md-2 text-center">Prénom de l'apprenant</th>
					<th class="col-md-4 text-center">Actions apprenant</th>
				</tr>

				<c:forEach items="${mesApprenants}" var="item">
				<tr>
					<td style="color: #292C50;"><strong>${item.idApprenant}</strong></td>
					<td>${item.nomApprenant}</td>
					<td>${item.prenomApprenant}</td>
					<td style="display: flex; justify-content: space-between;">
						<a class="btn" href="" role="button" style="background-color: #292C50; color: white;"><span
								class="glyphicon glyphicon-envelope"></span> Missions</a>
						<a class="btn btn-info" href="modifierApprenant.htm?id=${item.idApprenant}" role="button"><span
							class="glyphicon glyphicon-pencil"></span> Modifier</a>
						<a class="btn btn-danger" href="supprimerApprenant.htm?id=${item.idApprenant}" role="button"><span
								class="glyphicon glyphicon-remove-circle"></span> Supprimer</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>

</html>