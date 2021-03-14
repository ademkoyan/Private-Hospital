<?php 

include("ayar.php");


$sorgula = mysqli_query($baglan,"select * from hastane_yonetim ");
$count = mysqli_num_rows($sorgula);


class yonetClass{
	public $yonetid;
	public $yonetunvan;
	public $yonetisim;
	public $yonetmeslek;
	public $yonetresim;
	public $tf;
}

$yonet = new yonetClass();
$sayac = 0;
if($count>0){
	echo("[");
	while($bilgi  = mysqli_fetch_assoc($sorgula)){
		
		$sayac = $sayac+1;
		$yonet->yonetid = $bilgi["yonet_id"];
		$yonet->yonetunvan = $bilgi["yonet_unvan"];
		$yonet->yonetisim = $bilgi["yonet_isim"];
		$yonet->yonetmeslek = $bilgi["yonet_meslek"];
		$yonet->yonetresim = $bilgi["yonet_resim"];
		$yonet->tf = true;
		echo(json_encode($yonet));
		if($count>$sayac){
			echo(",");
		
		}
	
	}
	echo("]");
}

else{
	echo("[");
	$sayac = $sayac+1;
	$yonet->yonetid =null;
	$yonet->yonetunvan = null;
	$yonet->yonetisim = null;
	$yonet->yonetmeslek = null;
	$yonet->yonetresim = null;
	$yonet->tf = false;
	echo(json_encode($yonet));
	echo("]");
}

[1 , 2 , 3 ]
?>