<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="com.Model.Commercial"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
		<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		</head>

		<body>
			<h1>VUE PRINCIPALE</h1>
			<p>Connexion reussi</p>
			<form action="chercher" method="get">
			Mot clé : <input type="text" name="motcle">
			<input type="submit" value="ok">
			</form>
			<table border="1" width="90%">
				<tr>
					<th>Nom</th><th>Mot de passe</th>
				</tr>
			</table>
			<c:forEach items={listeCommercial} var = "m">
				<tr>
					<td>m.login</td>
					<td>m.password</td>
				</tr>
			
			</c:forEach>
			
			
			<!--  
	<div>
			<ul>
				<INPUT type="checkbox" name="nom" value="valeur attachée au bouton"> Acheter
				<INPUT type="checkbox" name="nom" value="valeur attachée au bouton"> Louer
			</ul>
		</div>
	-->
		</body>
	</html>