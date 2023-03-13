<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>İlk Web Sayfam</title>
<title>Insert title here</title>
</head>
<body>
<h1 onclick="merhabaDunya()" style="color:red;backgroundcolor-color:blue" >Başlık</h1>
<p id="hello" onclick='alert("ben bir başlığım")'> WYSIWYG : what you see is what you get (Ne görüyorsan onu alacaksın) </p>
<form>
		<input id="txtName" placeholder="Adınız">
	</form>
	<% 
	//Scriptlet
	 %>
	<script> 
	function merhabaDunya(){
	let hello = document.getElementById("hello");
	hello.innerHTML = "Hello World";
	}
	</script>
</body>
</html>