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
        <div class="profile__column">
            <img src="/images/avatar.jpg" />
        </div>
        <div class="profile__column">
            <div class="profile__title">
                <h3 class="profile__username">serranoarevalo</h3>
                <c:if test="${profile.userEntity.id==principal.userEntity.id}">
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
                        Nicolás Serrano Arévalo
                    </span> Doing whatever and eating Pho Lorem ipsum dolor sit amet consectetur, adipisicing
                elit. Ducimus suscipit praesentium eveniet quibusdam ipsam omnis fugit. Tempore voluptates ratione recusandae
                natus illo perspiciatis suscipit, odio consequuntur quasi obcaecati minus! Omnis.
                <a href="#">serranoarevalo.com</a>
            </p>
        </div>
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
