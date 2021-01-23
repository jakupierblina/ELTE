

$a = Read-Host "Nr 1"
$b = Read-Host "Nr 2" 

if ($a % 2 -eq 0 -and $b % 2 -eq 0 )
{
    Write-output "Yes. Both are odd number"
} 
else
{
    Write-Output "No. They are not odd number "
}