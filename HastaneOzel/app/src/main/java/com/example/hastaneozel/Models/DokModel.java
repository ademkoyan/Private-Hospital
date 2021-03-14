package com.example.hastaneozel.Models;

public class DokModel{
	private String dokisim;
	private String dokresim;
	private String doktur;
	private boolean tf;
	private String dokbol;
	private String dokid;

	public void setDokisim(String dokisim){
		this.dokisim = dokisim;
	}

	public String getDokisim(){
		return dokisim;
	}

	public void setDokresim(String dokresim){
		this.dokresim = dokresim;
	}

	public String getDokresim(){
		return dokresim;
	}

	public void setDoktur(String doktur){
		this.doktur = doktur;
	}

	public String getDoktur(){
		return doktur;
	}

	public void setTf(boolean tf){
		this.tf = tf;
	}

	public boolean isTf(){
		return tf;
	}

	public void setDokbol(String dokbol){
		this.dokbol = dokbol;
	}

	public String getDokbol(){
		return dokbol;
	}

	public void setDokid(String dokid){
		this.dokid = dokid;
	}

	public String getDokid(){
		return dokid;
	}

	@Override
 	public String toString(){
		return 
			"DokModel{" + 
			"dokisim = '" + dokisim + '\'' + 
			",dokresim = '" + dokresim + '\'' + 
			",doktur = '" + doktur + '\'' + 
			",tf = '" + tf + '\'' + 
			",dokbol = '" + dokbol + '\'' + 
			",dokid = '" + dokid + '\'' + 
			"}";
		}
}
