<?php

include("ayar.php");

$hasta_adı = isset($_POST["hasta_adı"]);
$hasta_mail = isset($_POST["hasta_mail"]);
$hasta_tc = isset($_POST["hasta_tc"]);
$hasta_şifre = isset($_POST["hasta_şifre"]);
$dogrulamaKodu = rand(0,10000).rand(0,10000);
$durum = 0;
$kontrol = mysqli_query($baglan,"select*from hasta_kayıt where hasta_mail='$hasta_mail' or hasta_tc = '$hasta_tc' ");
$count = mysqli_num_rows($kontrol);

class User{
	public $text;
	public $tf;
}
$user = new User();



if($count > 0)
{
	$user ->text = "Girmiş oldupunuz biligler ait kullanıcı bulunmaktadır.Lüfen bilgileri değiştirin.";
	$user ->tf = false;
	echo(json_encode($user));
}
else
{

	$addUser = mysqli_query($baglan,"insert into hasta_kayıt(hasta_adı,hasta_mail,hasta_tc,hasta_şifre,dogrulamaKodu,durum) values
	('$hasta_adı','$hasta_mail','$hasta_tc','$hasta_şifre','$dogrulamaKodu','$durum')");
	
	$git = "localhost\aktifet.php?mail=".$hasta_mail."&dogrulamaKodu=".$dogrulamaKodu."; //buraya aktif etme sayfası gelecek
	$to = $hasta_mail;
	$subject = "kullanıcı hesabı aktifletirme";
	$text = "Merhaba sayın".$hasta_adı ."\n Sisteme giriş yapmak için tıklayın.<a href ='".$git."'> Onayla </a> ";
	$from = "From: asemhospital@gmail.com";
	$from .= "MIME-Version: 1.0\r\n";
	$from .= "Content-Type: text/html; charset=UTF-8\r\n";
	mail($to,$subject,$text,$from);
	
	$user ->text = "Hesabınız kayıt edildi fakat mail adresinizi onaylamalısınız";
	$user ->tf = true; 
	echo(json_encode($user));  



}


?>