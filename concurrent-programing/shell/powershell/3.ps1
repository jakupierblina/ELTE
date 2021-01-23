$filename=$args[0]

$a="December"
$b="July"

if ( $filename -eq 0){
    Write-Host "File does not exist"
}
else {
    $filename=$args[0]
}
Get-Content $filename | ForEach-Object {
    $x=$_.tostring().split(" ")[0]
    $y=$_.tostring().split(" ")[1]

    if ($y -eq $a -or $y -eq $b){

      Write-Host "$x $y "
    }
    
}
