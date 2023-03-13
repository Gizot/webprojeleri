<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bu bir web Login çalışmasıdır..</title>
</head>
<body>
<h2>Login : </h2>

<form method="post">
<label for="kullaniciAdi">Kullanıcı Adı : </label>
<input type="text" id="kullaniciAdi"
name="kullaniciAdi"> <br> <br>

<label for="sifre">Şifre :  </label>
<input type="password" id="sifre"
name="sifre"> <br> <br>

<button type="submit" name="submit">Sunucuya Gönder</button>
<button type="reset" name="reset">Temizle</button>

</form>

<%


String userName = request.getParameter("kullaniciAdi");
System.out.println(userName);

String password=request.getParameter("sifre");
System.out.println(password);


%>

</body>
</html>