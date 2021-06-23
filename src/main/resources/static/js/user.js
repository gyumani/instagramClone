let index={
    init:function (){
        let join=document.getElementById("btn-join");
        join.addEventListener("click",()=>{ this.join });
        let remove=document.getElementById("btn-delete");
        remove.addEventListener("click",()=>{this.remove});
    },
    join:function(){
        let username=document.getElementById("username").value;
        let password=document.getElementById("password").value;
        let email=document.getElementById("email").value;
        let firstName=document.getElementById("firstName").value;
        let lastName=document.getElementById("lastName").value;
        let data={
            username,
            password,
            email,
            firstName,
            lastName
        };
        $.ajax({
            type:"POST",
            url:"/test/insertUser",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            if(resp.status===500){
                alert("데이터 테스트 수행 실패");
            }else{
                alert("데이터 테스트 수행 성공");
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    },
    remove:function(){
        $.ajax({
            type:"DELETE",
            url:"/deleteUser",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
            dataType:"json"
        }).done(function(resp){
            if(resp.status===500){
                alert("데이터 테스트 수행 실패");
            }else{
                alert("데이터 테스트 수행 성공");
            }
        }).fail(function(error){
            alert(JSON.stringify(error));
        });

    }
}