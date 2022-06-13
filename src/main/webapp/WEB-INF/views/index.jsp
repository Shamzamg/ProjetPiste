<%--
  Created by IntelliJ IDEA.
  User: christian
  Date: 06/04/2018
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="vues/header.jsp" %>
<body>
<%@include file="vues/navigation.jsp"%>
<div class="container">
    <h1>Accueil</h1>
    <div class="jumbotron">
        <h2>Bienvenue dans l'application Permis Piste !</h2>
        <div class="ml-5">
            <jsp:useBean id="now" class="java.util.Date" scope="page" />
            <span class="mb-2">Nous sommes le <fmt:formatDate value="${now}" pattern="MM.dd.yyyy" /></span><br/>
            Cette application vous permettra de suivre pas à pas votre apprentissage<br/>
            En vous souhaitant une agréable visite !<br/> <br/>

            <h3>Pour commencer, vous pouvez:</h3>
            <ul>
                <li>
                    1) <span style="color: #0c87bb;">Enregistrer en tant qu'apprenant</span>
                </li>
                <li>
                    2) <span style="color: #0c87bb;">Inscrire à un jeu depuis la liste</span>
                </li>
                <li>
                    3) <span style="color: #0c87bb;">Accéder à la liste des missions pour valider des actions</span>
                </li>
            </ul><br/>
            <h4 style="color: #0c87bb;">D'autres informations comme la liste des apprenants ou des actions sont disponibles en haut à droite.</h4>
        </div>
    </div>
</div>

<%@include file="vues/footer.jsp"%>
</body>
</html>
