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

    <script type="text/javascript">
        function onCommentInsert (obj){
            const data=$(obj).prev();

            let comment={
                post_id: data.find('.post_id').val(),
                username: $("#username").val(),
                content: data.find('.content').val()

            };
            console.log(comment);
            $.ajax({
                type:"POST",
                url:"/comments/insert",
                data:JSON.stringify(comment),
                contentType:"application/json; charset=utf-8",
                dataType:"json"
            }).done(function(resp){
                if(resp.status===500){
                    alert("댓글 실패");
                    history.go(-1);

                }else{
                    alert("댓글 성공");
                    history.go(-1);
                }
            }).fail(function(error){
                alert(JSON.stringify(error));
            });
        }
    </script>
        <c:forEach items="${main}" var="main">
            <div class="photo" >
                <header class="photo__header">
                    <img  style="width:40px; height:40px; margin-right:10px;" src="/images/ProfilePicture/${main.postUsername}/${main.profilePicture}" />
                    <div class="photo__user-info">
                        <a style="color:#333; text-decoration: none;" href="/feed/profile/${main.postUsername}"><span class="photo__author" >${main.postUsername}</span></a>
                    </div>
                    <a class="btn-insert" href="/feed/updateForm/${main.id}"><i class="fa fa-ellipsis-h"></i></a>
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
                        <c:forEach items="${comment}" var="comment">
                            <c:if test="${main.id==comment.post_id}">
                                <li class="photo__comment">
                                    <span class="photo__comment-author">${comment.username}</span>${comment.content}
                                </li>
                            </c:if>
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
</main>
<%@ include file="../layout/footer.jsp"%>
