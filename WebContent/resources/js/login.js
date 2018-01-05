function login() {
	//初始化用户对象
	var login = new Object();
	var tel_id = document.getElementById("phoneNumber_input");
	login.tel = tel_id.value;
	var password_id = document.getElementById("password_input");
	login.password = password_id.value;
	//转成JSON字符串
	var loginjson = JSON.stringify(login);
	$.ajax({
		type : "POST",
		url : "userLogin",
		contentType : "application/json; charset=utf-8",
		data : loginjson,
		success : function(str) {
			if (str.indexOf("COREECT") == 0) {
				alert("登录成功！");
				//登录成功再说
			} else {
				alert("登录失败！");
				//layer.msg("失败！");
			}
		}
	})
}