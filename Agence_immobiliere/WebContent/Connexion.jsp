<%@page import="com.Model.Commercial"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   Commercial commercial =(Commercial)request.getSession().getAttribute("commercial");
   String rep=(String)request.getSession().getAttribute("rep");
   if(commercial==null){
	   commercial=new Commercial();
       
   } 
   if(rep==null){
       rep="" ;  
   }
   

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: -moz-linear-gradient(left,cornflowerblue,white); background-repeat: repeat-y">
    <center>
        <div style="margin-top: 10%">
        <form action="Controler/SeConnecter" method="post" >
            
            <fieldset style="width: 50px"><legend>Connexion </legend>
                <table border="0" cellpadding="5">
                    
                    <tbody>
                        <tr>
                            <td>Login :</td>
                            <td><input type="text" name="login" value="<%=commercial.getLogin()%>" size="30" /></td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="pass" value="" size="30" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="checkbox" name="con" value="" />Résté connecté</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a href="recuper.jsp">Mot de passe Oublié</a></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input type="submit" value="Connexion" /><input type="submit" value="Effacer" /></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><span style="color: red"><%=rep%></span></td>
                        </tr>
                    </tbody>
                </table>

            
            
            
            
            
        </fieldset>
        
        </form>
        </div>
        </center>
        
        
    </body>
</html>
