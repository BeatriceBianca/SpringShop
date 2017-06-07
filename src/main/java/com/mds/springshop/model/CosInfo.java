package com.mds.springshop.model;

public class CosInfo {
	private String userEmail;
	private int idProd;
	private String denumireProd;
	private long pretProd;
	private String descriereProd;
	private int cantitate;
	
	public CosInfo(){
		
	}
	public CosInfo(String userEmail,int idProd,String denumireProd,long pretProd,String descriereProd,int cantitate){
		this.userEmail=userEmail;
		this.idProd=idProd;
		this.denumireProd=denumireProd;
		this.pretProd=pretProd;
		this.descriereProd=descriereProd;
		this.cantitate=cantitate;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	public String getDenumireProd() {
		return denumireProd;
	}
	public void setDenumireProd(String denumireProd) {
		this.denumireProd = denumireProd;
	}
	public long getPretProd() {
		return pretProd;
	}
	public void setPretProd(long pretProd) {
		this.pretProd = pretProd;
	}
	public String getDescriereProd() {
		return descriereProd;
	}
	public void setDescriereProd(String descriereProd) {
		this.descriereProd = descriereProd;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	
}
