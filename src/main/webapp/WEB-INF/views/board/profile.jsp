<%--
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
        <c:forEach items="${viewProfile}" var="profile" varStatus="status" step="1" begin="0">
            <div class="profile__column">
                <img src="/images/ProfilePicture/Debjaw/증명사진.jpg" />
            </div>
            <div class="profile__column">
                <div class="profile__title">
                    <h3 class="profile__username">${profile.username}</h3>
                    <a href="/feed/editProfile">Edit profile</a>
                    <a href="/updateUserForm">Edit user</a>
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
                        ${profile.firstName}&nbsp;${profile.lastName}&nbsp;&nbsp;&nbsp;&nbsp;
                    </span>
                    <br/> <br/>${profile.bio}<br/><br/>
                    <a href="#">${profile.website}</a>
                </p>
            </div>
        </c:forEach>
    </header>
    <section class="profile__photos">
        <div class="profile__photo">
            <img src="/images/feedPhoto.jpg" />
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
        <div class="profile__photo">
            <img src="/images/feedPhoto.jpg" />
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
        <div class="profile__photo">
            <img src="/images/feedPhoto.jpg" />
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
        <div class="profile__photo">
            <img src="/images/feedPhoto.jpg" />
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
</main>
<%@ include file="../layout/footer.jsp"%>
