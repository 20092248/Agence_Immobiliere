package com.Model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RendezVous 
{
	 private String idRendezVous ;
	 private String  titre;
	 private String  contenu ;
	 private String  dateAjout ;
	 private String  IDCommercial ;
	 //
	 private String  IDBienImmobilier ;

	 public RendezVous()
	 {}
	 
	 public RendezVous(String idRendezVous, String titre, String contenu, String dateAjout,String IDBienImmobilier ) 
	 {
	        this.idRendezVous = idRendezVous;
	        this.titre = titre;
	        this.contenu = contenu;
	        this.dateAjout = dateAjout;
	        this.IDBienImmobilier = IDBienImmobilier;
	      
	    }

	    public String getIdRendezVous() {
	        return idRendezVous;
	    }

	    public void setIdRendezVous(String idRendezVous) {
	        this.idRendezVous = idRendezVous;
	    }

	    public String getTitre() {
	        return titre;
	    }

	    public void setTitre(String titre) {
	        this.titre = titre;
	    }

	    public String getContenu() {
	        return contenu;
	    }

	    public void setContenu(String contenu) {
	        this.contenu = contenu;
	    }

	    public String getDateAjout() {
	        return dateAjout;
	    }

	    public void setDateAjout(String dateAjout) {
	        this.dateAjout = dateAjout;
	    }

	    public String getIDCommercial() {
	        return IDCommercial;
	    }

	    public void setIDCommercial(String IDCommercial) {
	        this.IDCommercial = IDCommercial;
	    }
	    
	    public String getIDBienImmobilier() {
	        return IDBienImmobilier;
	    }

	    public void setIDBienImmobilier(String IDBienImmobilier) {
	        this.IDBienImmobilier = IDBienImmobilier;
	    }
	    
	    
}
