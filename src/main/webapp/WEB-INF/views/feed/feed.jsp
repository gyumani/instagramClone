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

        <c:forEach items="${main}" var="main">
            <div class="photo" >
                <header style="position:relative;" class="photo__header">
                    <img  style="width:40px; height:40px; margin-right:10px;" src="/images/ProfilePicture/${main.postUsername}/${main.profilePicture}" />
                    <div class="photo__user-info">
                        <a style="color:#333; text-decoration: none;" href="/user/profile/${main.postUsername}"><span class="photo__author" >${main.postUsername}</span></a>
                    </div>
                    <c:if test="${main.postUsername==principal.userEntity.username}">
                        <div style="position:absolute; right:50px;">
                            <a  style="text-decoration: none; color:#333;" href="/feed/updateForm/${main.id}"><i class="fa fa-ellipsis-h"></i></a>
                        </div>
                    </c:if>
                </header>
                <img style="width:300px; height:100%; margin-left:150px;" src="/images/PostPicture/${main.postUsername}/${main.postPicture}"/>
                <div style="text-align: center; margin:10px 20px;">
                    <p>${main.postContent}</p>
                </div>
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
                        <c:forEach items="${main.commentEntityList}" var="comment">
                            <li style="display:flex;" class="photo__comment">
                                <div>
                                    <input type="hidden" class="commentId" value="${comment.id}" readonly>
                                    <span style="margin-right:10px;" class="photo__comment-author">${comment.username}</span>${comment.content}
                                </div>
                                <c:if test="${comment.username==principal.userEntity.username}">
                                    <button style="margin-left:50px; outline:0; border:0; background:none; color: #f00;cursor:pointer" onclick="onCommentDelete(this)">X</button>
                                </c:if>
                            </li>
                        </c:forEach>
                    </ul>
                    <span class="photo__time-ago">2 hours ago</span>
                    <div class="photo__add-comment-container">
                        <div>
                            <input type="hidden" class="post_id" value="${main.id}">
                            <input type="hidden" id="username" value="${principal.userEntity.username}">
                            <input type="text" class="content" placeholder="Add a comment..."/>
                        </div>
                        <button id="btn-insert" onclick="onCommentInsert(this)"><i class="fa fa-ellipsis-h"></i></button>
                    </div>
                </div>
            </div>
        </c:forEach>
    <script type="text/javascript" src="/js/feed.js"></script>
</main>
<%@ include file="../layout/footer.jsp"%>
