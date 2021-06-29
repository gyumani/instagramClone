<%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>

<%@ include file="../layout/header.jsp"%>
<main id="edit-profile">
<div class="edit-profile__container">
    <header class="edit-profile__header">
        <div class="edit-profile__avatar-container">
            <img src="/images/ProfilePicture/${principal.userEntity.username}/${principal.userEntity.picture}" class="edit-profile__avatar" />
        </div>
        <h4 class="edit-profile__username">${principal.userEntity.username}</h4>
    </header>
    <form action="/updateUserProc" method="post" class="edit-profile__form">
        <input type="hidden" id="id" name="id" value="${principal.userEntity.id} "/>
        <div class="form__row">
            <label for="username" class="form__label">Username:</label>
            <input id="username" name="username" value="${principal.userEntity.username}" type="text" class="form__input" />
        </div>
        <div class="form__row">
            <label for="password" class="form__label">Password:</label>
            <input id="password" name="password" type="password" class="form__input" required/>
        </div>
        <div class="form__row">
            <label for="email" class="form__label">Email :</label>
            <input id="email" name="email" type="email" value="${principal.userEntity.email}"class="form__input" />
        </div>
        <div class="form__row">
            <label for="firstName" class="form__label">First Name:</label>
            <input id="firstName" name="firstName" type="text" value="${principal.userEntity.firstName}" class="form__input" />
        </div>
        <div class="form__row">
            <label for="lastName" class="form__label">Last Naem :</label>
            <input id="lastName" name="lastName" type="text" value="${principal.userEntity.lastName}"class="form__input" />
        </div>
        <input type="submit" value="Submit">
    </form>
    <form action="/deleteUser" method="post" class="edit-profile__form">
        <input type="hidden"  name="id" value="${principal.userEntity.id} "/>
        <input type="submit"  value="remove">
    </form>
</div>
</main>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
