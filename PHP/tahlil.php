<?php 

include("ayar.php");


$hastatc = isset($_POST["hasta_tc"]);
$sorgula = mysqli_query($baglan,"select * from hasta_tahlil where hasta_tc = '$hastatc' ");
$count = mysqli_num_rows($sorgula);


class tahlilClass{
	public $tahlilid;
	public $hastatc;
	public $tahlilbol;
	public $tahlildok;
	public $tahlilisim;
	public $tahlilresim;
	public $tf;
}

$tahlil = new tahlilClass();
$sayac = 0;
if($count>0){
	echo("[");
	while($bilgi  = mysqli_fetch_assoc($sorgula)){
		
		$sayac = $sayac+1;
		$tahlil->tahlilid = $bilgi["tahlil_id"];
		$tahlil->hastatc = $bilgi["hasta_tc"];
		$tahlil->tahlilbol = $bilgi["tahlil_bol"];
		$tahlil->tahlildok = $bilgi["tahlil_dok"];
		$tahlil->tahlilisim = $bilgi["tahlil_isim"];
		$tahlil->tahlilresim = $bilgi["tahlil_resim"];
		$tahlil->tf = true;
		echo(json_encode($tahlil));
		if($count>$sayac){
			echo(",");
		
		}
	
	}
	echo("]");
}

else{
	echo("[");
	$sayac = $sayac+1;
	$tahlil->tahlilid = null;
	$tahlil->hastatc = null;
	$tahlil->tahlilbol = null;
	$tahlil->tahlildok = null;
	$tahlil->tahlilisim = null;
	$tahlil->tahlilresim = null;
	$tahlil->tf = false;
	echo(json_encode($tahlil));
	echo("]"); 
	echo("Hiç bir tahliliniz bulunmamaktadır");
}

[1 , 2 , 3 ]
?>