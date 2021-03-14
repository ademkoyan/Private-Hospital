<?php

$serverName = "127.0.0.1";
$userName = "root";
$sifre = "";
$dbName = "ozel_hastane";

$baglan = mysqli_connect($serverName, $userName, $sifre, $dbName);

mysqli_set_charset($baglan, "UTF-8");
mysqli_query($baglan, "SET NAMES UFT8");


?>