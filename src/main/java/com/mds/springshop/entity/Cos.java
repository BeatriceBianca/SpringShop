package com.mds.springshop.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COS")
public class Cos implements Serializable{
	private static final long serialVersionUID = -2054386655979281968L;
	private int idCos;
	private String userEmail;
	private int idProd;
	private String denumireProd;
	private long pretProd;
	private int cantitate;
	@Id
	@Column(name = "idCos")
	public int getIdCos() {
		return idCos;
	}
	public void setIdCos(int idCos) {
		this.idCos = idCos;
	}
	@Column(name = "userEmail")
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Column(name = "idprod")
	public int getIdProd() {
		return idProd;
	}
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}
	@Column(name = "denumireprod")
	public String getDenumireProd() {
		return denumireProd;
	}
	public void setDenumireProd(String denumireProd) {
		this.denumireProd = denumireProd;
	}
	@Column(name = "pretprod")
	public long getPretProd() {
		return pretProd;
	}
	public void setPretProd(long pretProd) {
		this.pretProd = pretProd;
	}
	
	@Column(name = "cantitate")
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	
}
