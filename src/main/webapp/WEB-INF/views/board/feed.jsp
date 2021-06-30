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
        $(document).ready(function (){
            let comment={
                post_id: $('#post_id').val(),
                username: $("#username").val(),
                content: $('#content').val(),

            };
            $("#btn-comment").on("click",()=>{
                console.log('작동');
                $.ajax({
                    type:"POST",
                    url:"/test/insert",
                    data:JSON.stringify(data),
                    contentType:"application/json; charset=utf-8",
                    dataType:"json"
                }).done(function(resp){
                    if(resp.status===500){
                        alert("댓글 실패.");
                        location.href="/test/comment"

                    }else{
                        alert("댓글 성공.");
                        location.href="/test/comment"
                    }
                }).fail(function(error){
                    alert(JSON.stringify(error));
                });
            });
        });
    </script>
        <c:forEach items="${main}" var="main">
            <div class="photo" >
                <header class="photo__header">
                    <img  style="width:40px; height:40px; margin-right:10px;" src="/images/ProfilePicture/${main.postUsername}/${main.profilePicture}" />
                    <div class="photo__user-info">
                        <a  href="/feed/profile/${main.postUsername}"><span class="photo__author" >${main.postUsername}</span></a>
                    </div>
                </header>
                <img style="width:300px; height:300px; margin-left:150px;" src="/images/PostPicture/${main.postUsername}/${main.postPicture}"/>
                <p>${main.postContent}</p>
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
                            <span class="photo__comment-author">${main.commentUsername}</span>${main.commentContent}
                        </li>
                    </ul>
                    <span class="photo__time-ago">2 hours ago</span>
                    <div class="photo__add-comment-container">
                        <input type="hidden" id="post_id" value="${main.id}">
                        <input type="hidden" id="username" value="${principal.username}">
                        <textarea id="content" placeholder="Add a comment..."></textarea>
                        <button id="btn-comment"><i class="fa fa-ellipsis-h"></i></button>
                    </div>
                </div>
            </div>
        </c:forEach>
</main>
<%@ include file="../layout/footer.jsp"%>
