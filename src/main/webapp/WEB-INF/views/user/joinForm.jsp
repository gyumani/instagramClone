<%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>devstagram</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="description" content="Vietgram, like Instagram but with Pho" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<main id="login">
    <div class="login__column">
        <div class="login__box">
            <img src="/images/loginLogo.png" class="login__logo" />
            <form action="/auth/joinProc" method="post" class="login__form">
                <input type="text" name="username" placeholder="Username" required />
                <input type="password" name="password" placeholder="Password" required />
                <br/>
                <input type="text" name="email" placeholder="email" required />
                <br/>
                <input type="text" name="firstName" placeholder="first name" required />
                <br/>
                <input type="text" name="lastName" placeholder="last name" required />

                <input type="submit" value="Sign in" />
            </form>
            <span class="login__divider">or</span>
            <a href="#" class="login__link">
                <i class="fa fa-money"></i>
                Sign in with Facebook
            </a>
            <a href="#" class="login__link login__link--small">Forgot password</a>
        </div>
    </div>
</main>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
