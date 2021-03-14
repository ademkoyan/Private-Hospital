<?php 

include("ayar.php");

$mailA = isset($_POST["mailadres"]);
$sifre=isset($_POST["parola"]);

$control = mysqli_query($baglan, "select *from hasta_kayıt where hasta_mail= '$mailA' and hasta_şifre= '$sifre' ");
$count = mysqli_num_rows($control);

class UserLogin{
	public $id; 
	public $mailadres;
	public $tc;
	public $parola;
	public $tf;
	public $text;
}

$user = new UserLogin();


if($count>0){
	
	$parse = mysqli_fetch_assoc($control);
	$durum = $parse["durum"];
	$id = $parse["hasta_adı"];
	$parola = $parse["hasta_şifre"];
	$tc = $parse["hasta_tc"];
	$mailadres = $parse["hasta_mail"];
	
	
	if($durum == 1){
		$user->tf=true;
		$user->text= "Sisteme giriş başarılı.";
		$user->id = $id;
		$user->parola = $parola;
		$user->tc = $tc;
		$user->mailadres = $mailadres;
		echo(json_encode($user));
		
	}
	else{
		$user->tf=true;
		$user->text= "Sisteme giriş yapabilmek için e-mail adresinizi onaylayın..";
		$user->id = null;
		$user->parola = null;
		$user->tc = null;
		$user->mailadres = null;
		echo(json_encode($user));
	}
	
}
else{
	$user->tf=false;
	$user->text= "Sistemde giriş bilgileriniz ile kullanıcı bulunmamaktadır.";
	$user->id = null;
	$user->parola = null;
	$user->tc = null;
	$user->mailadres = null;
	echo(json_encode($user));
	}




?>