<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.Model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<%
	Commercial  commercial=(Commercial)request.getSession().getAttribute("commercial");
	/*commercial.setIDCommercial(commercial.getIDCommercial(commercial.getLogin())+"");*/
	commercial.setIDCommercial(commercial.getIDCommercial());
	/*commercial.setRendezVous(commercial.getRendezVous(commercial.getLogin()));*/
	commercial.setBienImmobilier(commercial.getBienImmobiliers());
   	
	String rep=(String)request.getSession().getAttribute("rep");
   
	if(commercial==null){
       
      response.sendRedirect("Connexion.jsp");
   }
   
	String not=(String)request.getSession().getAttribute("n1");
    
   if(not==null){
       not="";
   }
  
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vue test</title>
</head>
<body>

	<h2>Ajouter un bien</h2>
	<div style="display: inline-block;margin-left:10%;margin-top: 2%;width: 80%">
            <%=not%>
            <table border="1" style="width: 100%">
                <tr> <th>IDBien</th><th>Nom du Bien</th></tr>
            <%
               for(int i=0;i<commercial.getBienImmobiliers().size();i++){
             %>
                
                
                
                <tr> 
                	<td><%=commercial.getBienImmobiliers().get(i).getIDBienImmobilier()%></td>
                    <td><%=commercial.getBienImmobiliers().get(i).getNomBienImmobilier()%></td>        
                 </tr>
                 
                     
            <%}%>
            
            </table>
            
            <form action ="Controler/AjouterBien" method="post" >
            	<input type="submit" value="Ajouter" name="ajouterBienImmobilier" />
            </form>
            <form action ="Controler/SupprimerBien" method="post" >
            	<input type="submit" value="Supprimer" name="supprimerBienImmobilier" />
            </form>

</body>
</html>