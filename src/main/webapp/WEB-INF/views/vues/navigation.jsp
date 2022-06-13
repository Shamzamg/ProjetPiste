<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="container text-white">
    <nav class="navbar navbar-inverse" style="background-color: #292C50;">
        <div style="display: flex; justify-content: space-between; padding-right: 15px;">
            <div class="navbar-header">
                <a class="navbar-brand" style="color: white;" href="#">Permis piste</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="index.htm"> <span class="glyphicon glyphicon-home"></span> Accueil</a></li>
                <c:if test="${sessionScope.id == null }">
                <li class="dropdown">
                    <a class="nav navbar-nav navbar-right"  href="login.htm">
                        <span class="glyphicon glyphicon-user"></span>
                        Se Connecter
                        <span class="caret"></span>
                    </a>
                    </c:if>
                    <c:if test="${sessionScope.id > 0  }">
                <li><a href="missions.htm"> <span class="glyphicon glyphicon-home"></span> Missions</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        Apprenants
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu">
                        <li><a href="ajouterApprenant.htm"> <span class="glyphicon glyphicon-plus"></span> Ajout Apprenant</a></li>
                        <li><a href="listerApprenant.htm"><span class="glyphicon glyphicon-th-list"></span> Lister les apprenant</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        Jeux
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu">
                        <li><a href=""> <span class="glyphicon glyphicon-plus"></span> ???? </a></li>
                        <li><a href=""><span class="glyphicon glyphicon-th-list"></span> ???? </a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        Actions
                        <span class="caret"></span>
                    </a>

                    <ul class="dropdown-menu">
                        <li><a href=""> <span class="glyphicon glyphicon-plus"></span> ???? </a></li>
                        <li><a href=""><span class="glyphicon glyphicon-th-list"></span> ???? </a></li>
                    </ul>
                </li>
                <li><a href="javascript:fermer()"><span class="glyphicon glyphicon-log-out"></span> Quitter</a></li>
                </c:if>

            </ul>
        </div>
    </nav>
</div>