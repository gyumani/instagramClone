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
        dataType:"text"
    }).done(function(resp){
        if(resp.status===500){
            location.href='/';

        }else{
            location.href='/';
        }
    }).fail(function(error){
        alert(JSON.stringify(error));
    });
}

function onCommentDelete (obj){
    const data=$(obj).prev();
    let commentId=data.find('.commentId').val();
    console.log(commentId);
    $.ajax({
        type:"DELETE",
        url:"/comment/delete/"+commentId,
        dataType:"text"
    }).done(function(resp){
        if(resp.status===500){
            location.href='/';
        }else{
            location.href='/';
        }
    }).fail(function(error){
        alert(JSON.stringify(error));
    });

}