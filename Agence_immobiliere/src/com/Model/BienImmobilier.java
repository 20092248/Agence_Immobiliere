package com.Model;

import java.util.*;

public class BienImmobilier 
{
	private String idBienImmobilier;
	private String nomBienImmobilier;
	private boolean isDisponible;
	private String adresse;
	private double prixAchat, loyer, charge;
	
	private List<RendezVous> liste_rendezVous = new ArrayList<RendezVous>();
	
	public BienImmobilier()
	{
		
	}
	
	public BienImmobilier(String idBienImmobilier, String nomBienImmobilier)
	{
		this.idBienImmobilier = idBienImmobilier;
		this.nomBienImmobilier=nomBienImmobilier;
	}
	
	public String getIDBienImmobilier()
	{
		return this.idBienImmobilier;
	}
	
	public String getNomBienImmobilier()
	{
		return this.nomBienImmobilier;
	}
	
	public void setNomBienImmobilier(String nom)
	{
		this.nomBienImmobilier = nom;
	}

}
