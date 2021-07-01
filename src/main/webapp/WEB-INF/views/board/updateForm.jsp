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
    <form action="/feed/updateProc/${getURLParams(window.location.href)['id']}" METHOD="post" class="edit-profile__form" enctype="multipart/form-data">
        <div class="form__row">
            <label for="file" class="form__label">Picture:</label>
            <input id="file" name="file" type="file" class="form__input" />
        </div>
        <div class="form__row">
            <label for="content" class="form__label">Content:</label>
            <textarea id="content" name="content"></textarea>
        </div>

        <input type="submit" value="Submit">
    </form>
    <a href="/feed/delete">remove</a>
</div>
    <script>
        function getURLParams(url){
            let result={};
            url.replace(/[?&]{1}([^=$#]+)=([^&#]*)/g,function (s,k,v){result[k]=decodeURIComponent(v);});
            return result;
        }
    </script>
</main>

<%@ include file="../layout/footer.jsp"%>
