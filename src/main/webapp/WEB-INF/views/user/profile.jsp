<%@ page import="com.devjaws.instagramclone.domains.user.dtos.entities.UserEntity" %><%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>

<%@ include file="../layout/header.jsp"%>

<div>
    <input type="hidden" id="followId" value="${info.id}">
    <input type="hidden" id="userId" value="${principal.userEntity.id}">
</div>

    <main id="profile">
        <header class="profile__header">
            <div class="profile__column">
                <img style="width:120px; height:120px;" src="/images/ProfilePicture/${info.username}/${info.picture}" />
            </div>
            <div class="profile__column">
                <div class="profile__title">
                    <h3 class="profile__username">${info.username}</h3>
                    <c:choose >
                        <c:when test="${info.username==principal.userEntity.username}">
                            <a href="/user/editProfile">Edit profile</a>
                            <a href="/user/updateUserForm">Edit user</a>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${info.id==followData.followId}">
                                    <button id="btn-follow" onclick="onUnFollow(this)" style="width:80px; height:30px; background:#3f99ed; border:0; outline:0; cursor:pointer; font-size:15px; color:#fff; border-radius: 4px;">unfollow</button>
                                </c:when>
                                <c:otherwise>
                                    <button id="btn-follow" onclick="onFollow(this)" style="width:80px; height:30px; background:#3f99ed; border:0; outline:0; cursor:pointer; font-size:15px; color:#fff; border-radius: 4px;">follow</button>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
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
        <section class="profile__photos">
            <div class="photo__wrapper">
                <c:forEach items="${getpp}" var="getpp" varStatus="status" step="1" begin="0">
                    <div class="profile__photo" onclick="onPostid(this)">
                        <input type="hidden" class="id" value="${getpp.id}"/>
                        <input type="hidden" class="username" value="${getpp.postUsername}"/>
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
                </c:forEach>
            </div>
        </section>

</main>

<div class="modal">
    <div class="modal_light">
        <div class="modal_image">
            <img src="/images/PostPicture/${post.postUsername}/${post.postPicture}" alt="">
        </div>
        <div class="modal_info">
            <div class="modal_info_user">
                <div class="modal_info_user_info">
                    <div class="modal_info_user_profile">
                        <img src="/images/ProfilePicture/${post.postUsername}/${post.profilePicture}" alt="">
                    </div>
                    <h3 class="modal_info_username">${post.postUsername}</h3>
                </div>
                <a class="btn-insert" href="/feed/updateForm/${main.id}"><i class="fa fa-ellipsis-h"></i></a>
            </div>
            <div class="modal_info_content">
                <p>${post.postContent}</p>
            </div>
            <div class="modal_action">
                <span class="modal__action">
                    <i class="fa fa-heart-o fa-lg"></i>
                </span>
                    <span class="modal__action">
                    <i class="fa fa-comment-o fa-lg"></i>
                </span>
            </div>
            <span class="modal_likes">45 likes</span>
            <ul class="modal_comments">
                <li class="modal_comment">
                    <span class="modal_content-author">jkm123</span>와 재밌겠네요 ㅎ
                </li>
            </ul>
            <div class="modal_comment_input">
                <div>
                    <input type="hidden" class="post_id" value="">
                    <input type="hidden" id="username" value="">
                    <input type="text" class="content" placeholder="Add a comment..."/>
                </div>
                <button id="btn-insert"><i class="fa fa-ellipsis-h"></i></button>
            </div>
        </div>
    </div>
    <button class="modal_close"><i class="fas fa-times"></i></button>

</div>

<script type="text/javascript" defer src="/js/profile.js"></script>
<%@ include file="../layout/footer.jsp"%>