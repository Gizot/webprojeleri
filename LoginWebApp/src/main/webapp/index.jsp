<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Sayfası</title>
</head>
<body>
<h2>Loging:</h2>
<form method="post">
<label for="kullaniciAdi">Kullanıcı Adı :</label>
<input type="text" id="kullaniciAdi"
name="kullaniciAdi"> <br> <br>
<label for="sifre">Şifre :</label>
<input type="password" id="sifre"
name="sifre"> <br> <br>


<button type="submit" name="submit">Sunucuya Gönder</button> 
<button type="reset"> Temizle :</button>

</form>
<% //bu kısma yazılan kodlar server kısmında çalışan java kodları
//browser tarafında java çalışmaz sadece js çalışır.

String userName = request.getParameter("kullaniciAdi");
System.out.println(userName);

String password =  request.getParameter("sifre");
System.out.println(password);
 %>

</body>
</html>