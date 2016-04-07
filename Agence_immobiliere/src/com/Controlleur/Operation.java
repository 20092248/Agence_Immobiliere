package com.Controlleur;


import com.Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class Operation {
    
	Connection con = Connexion.getCon();
    
    private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) 
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/*Verifie si un Commercial existe dans la base de donnée*/
	public boolean  isExiste(Commercial commercial) throws SQLException
    {   
		ResultSet rs=con.createStatement().executeQuery("select *from utilisateur1 where login='"+commercial.getLogin()+"' and password='"+commercial.getPassword()+"'");      
        return rs.next();
    }
     
	/*Verifie si un Login existe*/
     public boolean loginExiste(String login ) throws SQLException
     {
        ResultSet rs =con.createStatement().executeQuery("select *from utilisateur1 where login='"+login+"'");
        return rs.next();
     }
     
     /*Verifie si un email existe*/
     public boolean emailExiste(String email ) throws SQLException
     {
        ResultSet rs =con.createStatement().executeQuery("select *from utilisateur1 where email='"+email+"'");
        return rs.next();
     }
    
     
             
     /*Recupère la question secrete*/
     public String getQuestion(String login , String email) throws SQLException
     { 
    	 String q="";
    	 ResultSet rs=con.createStatement().executeQuery("select QUESTIONSECRET from utilisateur1 where login='"+login+"' and email='"+email+"'" );
      
    	 if(rs.next())
    	 {
    		 q+=rs.getString(1);
    	 }
       
    	 return q;
       
     }
   
     /*Verifie la réponse*/
     public String verifierep(Commercial us) throws SQLException 
     {
          String pass="";
          String req="select password from utilisateur1 where login ='"+us.getLogin()+"' and email='"+us.getEmail()+"' and REPONSESECRET='"+us.getRepSecret()+"'";
          ResultSet rs=con.createStatement().executeQuery(req);
          
          if(rs.next())
          {
              pass+=rs.getString(1);
          }
          
          return pass;
          
      }
     
     /*----------------------------METHODE D'AJOUT-------------------------------------*/
     
     /*Ajoute un BienImmobilier dans la base de données*/
     public void addBienImmobilier(BienImmobilier bien) throws SQLException
     {
    	 PreparedStatement psm = con.prepareStatement("insert into BienImmobilier(IDBienImmobilier,nomBienImmobilier) values(?,?)");
    	 //psm.setString(1, bien.getNomBienImmobilier());
    	 //psm.setString(2, id);
    	 psm.setString(1, bien.getIDBienImmobilier());
    	 psm.setString(2, "Maison");

    	 psm.executeUpdate();
     }
     
     /*Ajoute un commercial à la Base de données*/
     public void addCommercial(Commercial commercial) throws SQLException
     {
         PreparedStatement psm=con.prepareStatement("insert into utilisateur1(IDUtilisateur,Login,Password,Email,QuestionSecret,ReponseSecret) values (?,?,?,?,?,?) ");
         psm.setInt(1, commercial.getIDCommercial());
         psm.setString(2, commercial.getLogin());
         psm.setString(3, commercial.getPassword());
         psm.setString(4, commercial.getEmail());
         psm.setString(5, commercial.getQuesSecret());
         psm.setString(6, commercial.getRepSecret());         
         
         psm.executeUpdate();
         
        /* String SQL = "insert into utilisateur1 (seq_ut.nextval,?,?,?,?,?) ";

 		jdbcTemplateObject.update(SQL, name, age);
 		System.out.println("Created Record Name = " + name + " Age = " + age);
 		return;*/
         
     }
    
}