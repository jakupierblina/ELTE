<!DOCTYPE html>
<html lang="en">
<head>
    <style>.error {color: #FF0000;}
</style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>


<?php

$nameError = $numberError = $colorsError = $radioError = "";
$name = $number = $colors = $radio = "";

$input = range(1,4);

if($_SERVER["REQUEST_METHOD"] == "POST"){
    if(empty($_POST["name"])){
        $nameError = "Name is required";
    } else {
        $name = input($_POST["name"]);
        $input[1]=$name;
        if(!preg_match("/^[a-zA-Z-' ]*$/", $name)){
            $nameError = "Only letters and white space allowed";
        }

    }
    
    if(empty($_POST["number"])){
        $numberError = "Number is required";
    } else {
        $number = input($_POST["number"]);
        $input[2]=$number;
        if(!preg_match('/^([0-9]*)$/', $number)){
            $nameError = "Only numbers allowed";
        }
    }
    
    if(empty($_POST["colors"])){

        $colorsError = "Color is required";
    } else {
    	
        $colors = input($_POST["colors"]);
        $input[3]=$color;
    }
    
    if(empty($_POST["radio"])){
        $radioError = "Answer is required";
    } else {

        $radio = input($_POST["radio"]);
        $input[4]=$radio;
        
    }
}

function input($data){
    $data = trim($data);
    $data = stripcslashes($data);
    $data = htmlspecialchars($data);
    return $data;
    
}


echo"<table>
    <tr>
        <th>Name</th>
        <th>Value</th>
        <th>Color</th>
        <th>Do we keep it?</th>
    </tr>
    <tr>
        <th>$name </th>
        <th> $number </th>
        <th> $colors </th>
        <th> $radio </th>
        
    </tr>";



?>
<p><span class="error">* required field</span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
    treasure name: <input type="text" name="name" value="<?php echo $name; ?>">
    <span class="error">* <?php echo $nameError;?></span><br>
    trasure value: <input type="number" name="number" value="<?php echo $number;?>">
    <span class="error">* <?php echo $numberError;?></span><br>    

    <label for="colors">treasure color:</label>
    <select id="colors" name="colors" value="<?php echo $colors; ?>">
        <option value=""></option>
        <option value="red">red</option>
        <option value="orange">orange</option>
        <option value="yellow">yellow</option>
        <option value="green">green</option>
        <option value="blue">blue</option>
        <option value="purple">purple</option>
    </select>
        <span class="error">* <?php echo $colorsError;?></span>    
    <br>
    <p>Do we keep it?</p>
    <input type="radio" id="keep" name="radio" <?php if (isset($radio) && $radio=="Keep") echo "checked";?> value="keep">yes
<!--    <label for="keep">yes</label><br>-->
    <input type="radio" id="giveAway" name="radio"  <?php if (isset($radio) && $radio=="giveAway") echo "checked";?> value="Give away">no
    <span class="error">* <?php echo $radioError;?></span>    
    <br>
<!--    <label for="giveAway">no</label><br>-->
<!--   <span class="error">* <?php echo $radio;?></span>
 -->    <input type="submit" name="submit" value="Submit">
</form>



</body>
</html>


