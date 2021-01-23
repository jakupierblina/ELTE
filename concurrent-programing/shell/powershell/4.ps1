#the aveage grade 



$filename=$args[0]


Get-Content $filename | ForEach-Object {
    $x=$_.tostring().split(",")[1]
    $y=$_.tostring().split(",")[2]
    $z=$_.tostring().split(",")[3]
    $average=([int]$x+[int]$y+[int]$z)/3
    Write-Host $average
}
