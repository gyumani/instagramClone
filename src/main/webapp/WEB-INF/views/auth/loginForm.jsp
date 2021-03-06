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
        <img src="/images/phoneImage.png" class="login__phone" />
    </div>
    <div class="login__column">
        <div class="login__box">
            <img src="/images/loginLogo.png" class="login__logo" />
            <form action="/auth/loginProc" method="post" class="login__form">
                <input type="text" name="username" placeholder="Username" required />
                <input type="password" name="password" placeholder="Password" required />
                <input type="submit" value="Log in" />
            </form>
            <span class="login__divider">or</span>
            <a href="#" class="login__link">
                <i class="fa fa-money"></i>
                Log in with Facebook
            </a>
            <a href="#" class="login__link login__link--small">Forgot password</a>
        </div>
        <div class="login__box">
            <span>Don't have an account?</span> <a href="/auth/joinForm">Sign up</a>
        </div>
        <div class="login__box--transparent">
            <span>Get the app.</span>
            <div class="login__appstores">
                <img src="/images/ios.png" class="login__appstore" alt="Apple appstore logo" title="Apple appstore logo" />
                <img src="/images/android.png" class="login__appstore" alt="Android appstore logo" title="Android appstore logo" />
            </div>
        </div>
    </div>
</main>

<%@ include file="../layout/footer.jsp"%>
