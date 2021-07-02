$(document).ready(()=>{
    $('.modal_close').on("click",()=>{
        console.log('remove active');
        $('.modal').removeClass('active');
    });
});
function onPostid (obj){
    const post=$(obj).next();
    let id=post.find('.id').val();
    let username=post.find('.username').val();
    console.log(id);
    console.log(username);

    $.ajax({
        type:"GET",
        url:"/p/"+id,
        dataType:"text"
    }).done(function(resp){
        if(resp.status===500){
            alert("모달 띄우기 실패");
        }else{
            alert("모달 띄우기 성공");
        }
    }).fail(function(error){
        alert(JSON.stringify(error));
    });

    $('.modal').addClass('active');
}

function onFollow(){

    let follow={
        userId: $('#userId').val(),
        followId: $('#followId').val()
    };
    console.log(follow);

    $.ajax({
        type:"POST",
        url:"/follow/follow",
        data:JSON.stringify(follow),
        contentType: "application/json; charset=utf-8",
        dataType: "text"
    }).done(function(resp){
        if(resp.status===500){
            alert('팔로우 실패');
            document.location.reload();
        }else{
            alert('팔로우 성공');
            document.location.reload();

        }
    }).fail(function(error){
        alert(JSON.stringify(error));
    });

}