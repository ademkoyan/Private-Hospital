package com.example.hastaneozel.Models;

public class YonetimModel{
	private String yonetisim;
	private boolean tf;
	private String yonetmeslek;
	private String yonetid;
	private String yonetunvan;
	private String yonetresim;

	public void setYonetisim(String yonetisim){
		this.yonetisim = yonetisim;
	}

	public String getYonetisim(){
		return yonetisim;
	}

	public void setTf(boolean tf){
		this.tf = tf;
	}

	public boolean isTf(){
		return tf;
	}

	public void setYonetmeslek(String yonetmeslek){
		this.yonetmeslek = yonetmeslek;
	}

	public String getYonetmeslek(){
		return yonetmeslek;
	}

	public void setYonetid(String yonetid){
		this.yonetid = yonetid;
	}

	public String getYonetid(){
		return yonetid;
	}

	public void setYonetunvan(String yonetunvan){
		this.yonetunvan = yonetunvan;
	}

	public String getYonetunvan(){
		return yonetunvan;
	}

	public void setYonetresim(String yonetresim){
		this.yonetresim = yonetresim;
	}

	public String getYonetresim(){
		return yonetresim;
	}

	@Override
 	public String toString(){
		return 
			"YonetimModel{" + 
			"yonetisim = '" + yonetisim + '\'' + 
			",tf = '" + tf + '\'' + 
			",yonetmeslek = '" + yonetmeslek + '\'' + 
			",yonetid = '" + yonetid + '\'' + 
			",yonetunvan = '" + yonetunvan + '\'' + 
			",yonetresim = '" + yonetresim + '\'' + 
			"}";
		}
}
