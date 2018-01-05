/**
 * Created by zephyr on 2016-12-26.
 */
function register() {
	alert("test");
	var register = new Object();
    register.tel = $("#phoneNumber_input").val();
    register.userName = $("#userName_input").val();
    register.userSex = $('input:radio[name="Sex"]:checked').val();
    register.password = $('#password_input').val();
    
    //转成JSON字符串
    var registerjson = JSON.stringify(users);
    alert(registerjson);
}