package com.example.hastaneozel.Models;

public class TahlilModel{
	private String tahlilresim;
	private String tahlilisim;
	private boolean tf;
	private String tahlilbol;
	private String hastatc;
	private String tahlildok;
	private String tahlilid;

	public void setTahlilresim(String tahlilresim){
		this.tahlilresim = tahlilresim;
	}

	public String getTahlilresim(){
		return tahlilresim;
	}

	public void setTahlilisim(String tahlilisim){
		this.tahlilisim = tahlilisim;
	}

	public String getTahlilisim(){
		return tahlilisim;
	}

	public void setTf(boolean tf){
		this.tf = tf;
	}

	public boolean isTf(){
		return tf;
	}

	public void setTahlilbol(String tahlilbol){
		this.tahlilbol = tahlilbol;
	}

	public String getTahlilbol(){
		return tahlilbol;
	}

	public void setHastatc(String hastatc){
		this.hastatc = hastatc;
	}

	public String getHastatc(){
		return hastatc;
	}

	public void setTahlildok(String tahlildok){
		this.tahlildok = tahlildok;
	}

	public String getTahlildok(){
		return tahlildok;
	}

	public void setTahlilid(String tahlilid){
		this.tahlilid = tahlilid;
	}

	public String getTahlilid(){
		return tahlilid;
	}

	@Override
 	public String toString(){
		return 
			"TahlilModel{" + 
			"tahlilresim = '" + tahlilresim + '\'' + 
			",tahlilisim = '" + tahlilisim + '\'' + 
			",tf = '" + tf + '\'' + 
			",tahlilbol = '" + tahlilbol + '\'' + 
			",hastatc = '" + hastatc + '\'' + 
			",tahlildok = '" + tahlildok + '\'' + 
			",tahlilid = '" + tahlilid + '\'' + 
			"}";
		}
}
