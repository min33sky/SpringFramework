<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
    // 삭제
    $('#btn_remove').on('click',function(){
        if($('.ck:checked').length == 1){ // 하나만 체크 가능
            var id = $('.ck:checked').val();
            $.ajax({
                url:'remove',
                type:'GET',
                data:{id:id},
                success:function(data){
                    alert(data+'님 삭제');
                    $('#btn_list').trigger('click');
                }
            });
        }else {
            alert("삭제할 아이템을 하나만 선택");
        }
    });
 
    // 추가
    $('#btn_add').on('click',function(){
        var id = $('#id').val();
        var pw = $('#pw').val();
        var name = $('#name').val();
        var age = $('#age').val();
        var gender = $('#gender').val();
 
        $.ajax({
            url:'add',
            type:'POST',
            data:{id:id,pw:pw,name:name,age:age,gender:gender},
            success:function(data){
                alert(data+'님 추가');
                $('#btn_list').trigger('click');
            }
        });
    });
    // 수정
    $('#btn_modify').on('click',function(){
        var id = $('#id').val();
        var pw = $('#pw').val();
        var name = $('#name').val();
        var age = $('#age').val();
        var gender = $('#gender').val();
 
        $.ajax({
            url:'modifyById',
            type:'POST',
            data:{id:id,pw:pw,name:name,age:age,gender:gender},
            success:function(data){
                alert(data+'님 수정');
                $('#btn_list').trigger('click');
            }
        });
    });
    // 목록
    $('#btn_list').on('click',function(){
        $.ajax({
            url:'list',
            type:'GET',
            success:function(data){
                $('#list').empty();
                $(data).each(function(index,item){
                    $('#list').append('<tr>');
                    $('#list').append('<td><input type="checkbox" class="ck" value="'+item.id+'"></td>');
                    $('#list').append('<td>'+item.id+'</td>');
                    $('#list').append('<td>'+item.pw+'</td>');
                    $('#list').append('<td>'+item.name+'</td>');
                    $('#list').append('<td>'+item.age+'</td>');
                    $('#list').append('<td>'+item.gender+'</td>');
                    $('#list').append('</tr>');
                });
            }
        });
    });
    
    // 페이지 로딩시 리스트 가져옴
    $('#btn_list').trigger('click');
});
</script>
</head>
<body>
    <table border="1">
        <thead>
            <tr>
                <th>id</th>
                <th>pw</th>
                <th>name</th>
                <th>age</th>
                <th>gender</th>
                <th>추가</th>
                <th>수정</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><input type="text" id="id"></td>
                <td><input type="password" id="pw"></td>
                <td><input type="text" id="name"></td>
                <td><input type="text" id="age"></td>
                <td>
                    <select id="gender">
                        <option value="m">남</option>
                        <option value="f">여</option>
                    </select>
                </td>
                <td><button id="btn_add">add</button></td>
                <td><button id="btn_modify">modify</button></td>
            </tr>
        </tbody>
    </table>
 
    <button id="btn_list">회원리스트</button>
    <table border="1">
        <thead>
            <tr>
                <th></th>
                <th>id</th>
                <th>pw</th>
                <th>name</th>
                <th>age</th>
                <th>gender</th>
            </tr>
        </thead>
        <tbody id="list">
        </tbody>
    </table>
    <button id="btn_remove">remove</button>
</body>
</html>