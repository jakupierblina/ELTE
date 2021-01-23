

$name=Read-Host "Names"

$i = $name.Length
$q="A"

for ( $a=0; $a -lt $i; $a++){

    if ( $name[$a].ToString().StartsWith($q) ){
	Write-Output $name
   }
}