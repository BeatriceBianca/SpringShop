package com.mds.springshop.model;

public class CosInfo {
	private int idCos;
	private String userEmail;
	private int idProd;
	private String denumireProd;
	private long pretProd;
	private int cantitate;
	
	public CosInfo(){
		
	}
	public CosInfo(String userEmail,int idProd,String denumireProd,long pretProd,int idCos,int cantitate){
		this.userEmail=userEmail;
		this.idProd=idProd;
		this.denumireProd=denumireProd;
		this.pretProd=pretProd;
		this.cantitate=cantitate;
		this.idCos=idCos;
	}
	public int getIdCos() {
		return idCos;
	}
	public void setIdCos(int idCos) {
		this.idCos = idCos;
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
	
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	
}
