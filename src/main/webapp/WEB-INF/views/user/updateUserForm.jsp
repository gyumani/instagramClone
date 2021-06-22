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
        <h4 class="edit-profile__username">serranoarevalo</h4>
    </header>
    <form class="edit-profile__form">
        <input type="hidden" id="id" value="${principal.user.id}"/>
        <div class="form__row">
            <label for="full-name" class="form__label">Name:</label>
            <input id="username" type="text" class="form__input" />
        </div>
        <div class="form__row">
            <label for="user-name" class="form__label">Username:</label>
            <input id="user-name" type="text" class="form__input" />
        </div>
        <div class="form__row">
            <label for="website" class="form__label">Website:</label>
            <input id="website" type="url" class="form__input" />
        </div>
        <div class="form__row">
            <label for="bio" class="form__label">Bio:</label>
            <textarea id="bio"></textarea>
        </div>
        <div class="form__row">
            <label for="email" class="form__label">Email:</label>
            <input id="email" type="email" class="form__input" />
        </div>
        <div class="form__row">
            <label for="phone" class="form__label">Phone Number:</label>
            <input id="phone" type="tel" class="form__input" />
        </div>
        <div class="form__row">
            <label for="gender" class="form__label">Gender:</label>
            <select id="gender">
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="cant">Can't remember</option>
            </select>
        </div>
        <input type="submit" value="Submit">
    </form>
</div>
</main>

<%@ include file="../layout/footer.jsp"%>
