<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.Model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
  	Commercial  commercial=(Commercial)request.getSession().getAttribute("commercial");
	commercial.setIDCommercial(commercial.getIDCommercial());//(commercial.getLogin())+"");
	commercial.setRendezVous(commercial.getRendezVous(commercial.getLogin()));
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
<title>Accueil</title>
</head>
		<body>
			<div style="display: inline-block;margin-left:10%;margin-top: 2%;width: 80%">
            <%=not%>
            <table border="1" style="width: 100%">
                <tr> <th>IDRendezVous</th><th>Titre</th><th>Contenu</th><th>DateAjout</th><th colspan="2">Operation ?</th><th>IDBien</th></tR>
            <%
               for(int i=0;i<commercial.getRendezVous().size();i++){
             %>
                
                
                
                <tr> <td><%=commercial.getRendezVous().get(i).getIdRendezVous()%></td>
                    <td><%=commercial.getRendezVous().get(i).getTitre()%></td>
                    <td><%=commercial.getRendezVous().get(i).getContenu()%></td>
                    <td><%=commercial.getRendezVous().get(i).getDateAjout()%></td>
                    <td>
                        <form action="modf.jsp">
                            <input type="hidden" name="n" value="<%=commercial.getRendezVous().get(i).getIdRendezVous()%>" />
                            <input type="submit" value="Modifier" />
                        </form></td>
                        <td>
                             <form action="Controler/del" >
                            <input type="hidden" name="n" value="<%=commercial.getRendezVous().get(i).getIdRendezVous()%>" />
                            <input type="submit" value="Supprimer" />
                        </form>
                       <td><%=commercial.getRendezVous().get(i).getIDBienImmobilier()%></td>     
                            
                        </td>
                 </tr>
             
            
            
            
            <%}%>
            
            
            </table>
        </div>

		</body>
</html>