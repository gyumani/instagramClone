<%--
  Created by IntelliJ IDEA.
  User: ${USER}
  Date: ${DATE}
  Time: ${TIME}
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/header.jsp"%>
<main id="feed">

            <div class="photo" >
                <header class="photo__header">
                    <img  style="width:40px; height:40px; margin-right:10px;" src="/images/ProfilePicture/${feed.username}/${principal.userEntity.picture}" />
                    <div class="photo__user-info">
                        <span class="photo__author">${feed.username}</span>
                    </div>
                </header>
                <img style="width:300px; height:300px; margin-left:150px;" src="/images/PostPicture/${feed.username}/${feed.picture}"/>
                <p>${feed.content}</p>
                    <div class="photo__info">
                        <div class="photo__actions">
                            <span class="photo__action">
                                <i class="fa fa-heart-o fa-lg"></i>
                            </span>
                            <span class="photo__action">
                                <i class="fa fa-comment-o fa-lg"></i>
                            </span>
                    </div>
                    <span class="photo__likes">45 likes</span>
                    <ul class="photo__comments">
                        <li class="photo__comment">
                            <span class="photo__comment-author">serranoarevalo</span> love this!
                        </li>
                        <li class="photo__comment">
                            <span class="photo__comment-author">serranoarevalo</span> love this!
                        </li>
                        <li class="photo__comment">
                            <span class="photo__comment-author">serranoarevalo</span> love this!
                        </li>
                        <li class="photo__comment">
                            <span class="photo__comment-author">serranoarevalo</span> love this!
                        </li>
                    </ul>
                    <span class="photo__time-ago">2 hours ago</span>
                    <div class="photo__add-comment-container">
                        <input type="hidden" id="post_id" value="1">
                        <input type="hidden" id="username" value="idUser">
                        <textarea id="comment" placeholder="Add a comment..."></textarea>
                        <button id="btn-comment"><i class="fa fa-ellipsis-h"></i></button>

                    </div>
                </div>
            </div>
</main>
<%@ include file="../layout/footer.jsp"%>
