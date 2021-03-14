<?php 

include("ayar.php");


$sorgula = mysqli_query($baglan,"select * from hastane_doktor_listesi ");
$count = mysqli_num_rows($sorgula);


class dokClass{
	public $dokid;
	public $dokresim;
	public $dokisim;
	public $doktur;
	public $dokbol;
	public $tf;
}

$dok = new dokClass();
$sayac = 0;
if($count>0){
	echo("[");
	while($bilgi  = mysqli_fetch_assoc($sorgula)){
		
		$sayac = $sayac+1;
		$dok->dokid = $bilgi["id"];
		$dok->dokresim = $bilgi["dok_resim"];
		$dok->dokisim = $bilgi["dok_isim"];
		$dok->doktur = $bilgi["dok_tur"];
		$dok->dokbol = $bilgi["dok_bol"];
		$dok->tf = true;
		echo(json_encode($dok));
		if($count>$sayac){
			echo(",");
		
		}
	
	}
	echo("]");
}

else{
	echo("[");
	$sayac = $sayac+1;
	$dok->dokid = null;
	$dok->dokresim = null;
	$dok->dokisim = null;
	$dok->doktur = null;
	$dok->dokbol = null;
	$dok->tf = false;
	echo(json_encode($dok));
	echo("]");
}

[1 , 2 , 3 ]
?>