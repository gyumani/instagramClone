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
            <img src="/images/avatar.jpg" class="edit-profile__avatar" />
        </div>
        <h4 class="edit-profile__username">${principal.userEntity.username}</h4>
    </header>
    <form action="/Profile/insert" METHOD="post" class="edit-profile__form" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${principal.userEntity.id}">
        <div class="form__row">
            <label for="website" class="form__label">Website:</label>
            <input id="website" name="website" type="url" class="form__input" />
        </div>
        <div class="form__row">
            <label for="bio" class="form__label">Bio:</label>
            <textarea id="bio" name="bio"></textarea>
        </div>
        <div class="form__row">
            <label for="file" class="form__label">Picture:</label>
            <input id="file" name="file" type="file" class="form__input" />
        </div>

        <input type="submit" value="Submit">
    </form>
</div>
</main>

<%@ include file="../layout/footer.jsp"%>
