<%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>instagram</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
<nav class="navigation">
    <div class="navigation__column">
        <a href="/">
            <!-- Master branch comment -->
            <img src="/images/logo.png" />
        </a>
    </div>
    <div class="navigation__column">
        <i class="fa fa-search"></i>
        <input type="text" placeholder="Search">
    </div>
    <div class="navigation__column">
        <ul class="navigations__links">
            <li class="navigation__list-item">
                <a href="#" class="navigation__link">
                    <i class="fa fa-heart-o fa-lg"></i>
                </a>
            </li>
            <li class="navigation__list-item">
                <a href="/user/profile/${principal.userEntity.username}" class="navigation__link">
                    <i class="fa fa-user-o fa-lg"></i>
                </a>
            </li>
            <li class="navigation__list-item">
                <a href="/logout" class="navigation__link">
                    <i class="fas fa-sign-out fa-lg"></i>
                </a>
            </li>
        </ul>
    </div>
</nav>
