<?php

include("ayar.php");
$mail= isset($_GET["hasta_mail"]);
$kod = isset($_GET["dogrulamakodu"]);

$guncelle = mysqli_query($baglan,"update hastane_ozel set durum = '1' where hasta_mail = '$mail' and dogrulamakodu = '$kod' ");

if($guncelle)
{

?>

<h1> Tebrikler hesabınız doğrulandı <\h1>

<?php

}


?>