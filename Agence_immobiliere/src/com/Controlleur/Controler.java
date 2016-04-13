package com.Controlleur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.*;

public class Controler extends HttpServlet 
{
	 Operation op =new Operation();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
	{
        response.setContentType("text/html;charset=UTF-8");
		 //this.getServletContext().getRequestDispatcher( "/Connexion.jsp" ).forward( request, response );
    }

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	 {
	        processRequest(request, response);
	        
	        String action =request.getPathInfo();
	        String method =request.getMethod();
	        
	        if(action.equals("/chercher") && method.toLowerCase().equals("get"))
	        {
	        	chercher(request,response);
	        	System.out.println("BOUTON OK");
	        }
	        
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException 
	 {
		 	processRequest(request, response);
	        
	        String action =request.getPathInfo();
	        String method =request.getMethod();
	        
	        if(action.equals("/SeConnecter") && method.toLowerCase().equals("post"))
	        {
	            SeConnecter(request, response);
	            System.out.println("CLIQUE SUR LE BOUTON VALIDER");
	            System.out.println("Changement de vue");
	        }
	        
	        if(action.equals("/AjouterBien") && method.toLowerCase().equals("post"))
	        {
	        	ajouterBienImmobilier(request, response);
	        	System.out.println("Ajouter un bien");
	        }
	        
	        if(action.equals("/InscriptionCommercial") && method.toLowerCase().equals("post"))
	        {
	        	ajouterCommercial(request,response);
	        }
	        
	        
		 
	  }



	

	private void SeConnecter(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session =request.getSession(true);
		//HttpSession session2 = request.getSession();
        String login =request.getParameter("login");
        String pass =request.getParameter("pass");
        Commercial commercial =new Commercial();
        commercial.setLogin(login);
        commercial.setPassword(pass);
        //ArrayList<Note> list=new ArrayList<Note>();
        
        try{
            if(op.isExiste(commercial)){
               
                request.getSession().setAttribute("commercial", commercial);
                request.getSession().setAttribute("rep", null);
                //session2.setAttribute(arg0, arg1);
                //response.sendRedirect("../vuePrincipale.jsp");
                
                response.sendRedirect("../Accueil.jsp");
                //response.sendRedirect("../vueTest.jsp");
                //response.sendRedirect("../formulaireInscription.jsp");
                //request.getSession().setAttribute("list", list);
                
            }else{
                 response.sendRedirect("../Connexion.jsp");
                 request.getSession().setAttribute("commercial", commercial);
                 request.getSession().setAttribute("rep", "Utilisateur ou mot de pass incorect");
                 //request.getSession().setAttribute("list", list);
            }
            
            
        }catch(SQLException ex){
            
        }
      
		
	}
	
	public void chercher(HttpServletRequest request, HttpServletResponse response)
	{
		
	}
	
	protected void ajouterBienImmobilier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
	{
             processRequest(request, response);
             
              String titre=request.getParameter("ajouterBienImmobilier");
              //String contenu=request.getParameter("contenu");
              Commercial commercial =(Commercial) request.getSession().getAttribute("commercial");
              BienImmobilier bien =new BienImmobilier();
              ArrayList<BienImmobilier> list =(ArrayList<BienImmobilier>)request.getSession().getAttribute("list");
             // n.setNomBienImmobilier(nom);(titre);
              //n.setContenu(contenu);
              
              
            try {
              request.getSession().setAttribute("not", "<span style=\"color:green\">Succes</span>");
              op.addBienImmobilier(bien);
              //op.addBienImmobilier(bien, commercial.getIDCommercial());//??????
              //list.add(bien);
              response.sendRedirect("../vueTest.jsp");
         } catch (SQLException ex) {
             response.sendRedirect("../vuePrincipale.jsp");
            request.getSession().setAttribute("not", "<span style=\"color:red\">"+ex.getMessage()+"</span>");
            System.out.println(ex.getErrorCode()+" " + ex.getSQLState()+" " +ex.getMessage());
         }
             
      
     
    }
	
	private void ajouterCommercial(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException 
	{
		processRequest(request, response);
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String questionSecrete = request.getParameter("question");
		String reponseSecrete = request.getParameter("reponse");
		
		Commercial commercial = new Commercial(login,password,email,questionSecrete,reponseSecrete);
		/*commercial.setLogin(login);
		commercial.setPassword(password);
		commercial.setEmail(email);
		commercial.setQuesSecret(questionSecrete);
		commercial.setRepSecret(reponseSecrete);*/
		//commercial.setIDCommercial(commercial.getIDCommercial());
		
		try
		{
			op.addCommercial(commercial);
			response.sendRedirect("../formulaireInscription.jsp");
		}
		catch(Exception e)
		{
			System.out.println("ERREUUUUUUUUUUUUUUUUUUR" +e.getMessage() + e.toString());
			response.sendRedirect("../formulaireInscription.jsp");
		}
		
	}
}