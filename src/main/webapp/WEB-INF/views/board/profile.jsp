<%@ page import="com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity" %><%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>

<%@ include file="../layout/header.jsp"%>


    <main id="profile">
        <header class="profile__header">
            <div class="profile__column">
                <img style="width:120px; height:120px;" src="/images/ProfilePicture/${info.username}/${info.picture}" />
            </div>
            <div class="profile__column">
                <div class="profile__title">
                    <h3 class="profile__username">${info.username}</h3>
                    <c:if test="${info.username==principal.userEntity.username}">
                        <a href="/feed/editProfile">Edit profile</a>
                        <a href="/updateUserForm">Edit user</a>
                    </c:if>
                </div>
                <ul class="profile__stats">
                    <li class="profile__stat">
                        <span class="stat__number">333</span> posts
                    </li>
                    <li class="profile__stat">
                        <span class="stat__number">1234</span> followers
                    </li>
                    <li class="profile__stat">
                        <span class="stat__number">36</span> following
                    </li>
                </ul>
                <p class="profile__bio">
                    <span class="profile__full-name">
                        ${info.firstName}&nbsp;${info.lastName}&nbsp;&nbsp;&nbsp;&nbsp;
                    </span>
                    <br/> <br/>${info.bio}<br/><br/>
                    <a href="${info.website}">${info.website}</a>
                </p>
            </div>

        </header>
        <style>
            .post__upload{
                width:15%; height: 30px;
                margin-bottom: 30px;
                text-align: center; line-height: 30px;
                font-size:20px; font-weight:bold; color:#fff;
                text-decoration: none; background:#3897f0;
            }
        </style>
        <c:if test="${info.username==principal.userEntity.username}">
            <a href="/feed/insertForm" class="post__upload">포스트 업로드</a>
        </c:if>
        <div class="post_wrap">
            <c:forEach items="${getpp}" var="getpp" varStatus="status" step="1" begin="0">
                <section class="profile__photos">
                    <div class="profile__photo">
                        <img src="/images/PostPicture/${getpp.postUsername}/${getpp.postPicture}" />
                        <div class="profile__photo-overlay">
                                <span class="overlay__item">
                                    <i class="fa fa-heart"></i>
                                    486
                                </span>
                            <span class="overlay__item">
                                    <i class="fa fa-comment"></i>
                                    344
                                </span>
                        </div>
                    </div>
                </section>
            </c:forEach>
        </div>

</main>

<%@ include file="../layout/footer.jsp"%>