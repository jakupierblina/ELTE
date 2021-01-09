<?php 
if(count($_GET)>0){

  //nese qekjo bahet ateher ndrroje
  $goblinsValid = false;
  if(!isset($_GET['goblins'])){
    echo("Invalid goblin quantity!<br>");
   
  }
  else{
    if(is_float(($_GET['goblins']))==0 && is_numeric($_GET['goblins'])==1 && $_GET['goblins']>0){
      $goblinsValid = true;
    }
    else{
      echo("Invalid goblin quantity!<br>"); //sepse eshte 
    }
    
    
  }

  if( !isset($_GET['chief']) && $_GET['chief']!=''){
    echo("Invalid leader!<br>");
  }
  else{
   if(strpos($_GET['chief'],' ')==false){
    echo("Invalid leader!<br>");
   }
   

   $leaderArr = explode(" " ,$_GET['chief'] );
   $chiefLevel = end($leaderArr);
   $possibleChief=["lil'goblin","lil'chief","grandchief","general","tribechief"];
   if(!in_array($chiefLevel,$possibleChief)){
    echo("Invalid rank!<br>");
   }
  else if(array_search($chiefLevel,$possibleChief) <2){
    echo("Rank too low!!<br>");
  }
  }

  if(!isset($_GET['shovels'])){
    echo("Invalid shovel quantity!!!<br>");
    
  }
  else{
    $shovels = $_GET['shovels'];
    
    if(is_float($_GET['shovels'])==0 && is_numeric($_GET['shovels'])==1 && $_GET['shovels']>0){
      if($goblinsValid){
        if( $_GET['shovels']< $_GET['goblins']){
          echo("Too few shovels!<br>");
        }
      }
    }
    else{
      echo("Invalid shovel quantity!!!<br>");
      
    }
  }
}
?>



<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Task 2</title>
</head>
<body>
  <h1>Task 2</h1>

  <h2>Messages</h2>
  <h2>Example links</h2>
  <a href="index.php?goblins=5&chief=Snuch Nawdow grandchief&shovels=7"><pre>index.php?goblins=5&chief=Snuch Nawdow grandchief&shovels=7</pre></a>
  <a href="index.php?goblins=5&chief=Snuch Nawdow grandchief&shovels=10"><pre>index.php?goblins=5&chief=Snuch Nawdow grandchief&shovels=10</pre></a>
  <a href="index.php"><pre>index.php</pre></a>
  <a href="index.php?goblins=notanumber&chief=nospace&shovels=notanumber"><pre>index.php?goblins=notanumber&chief=nospace&shovels=notanumber</pre></a>
  <a href="index.php?goblins=-5&chief=Snuch Nawdow grandchief&shovels=10"><pre>index.php?goblins=-5&chief=Snuch Nawdow grandchief&shovels=10</pre></a>
  <a href="index.php?goblins=16.2&chief=Snuch Nawdow grandchief&shovels=10"><pre>index.php?goblins=16.2&chief=Snuch Nawdow grandchief&shovels=10</pre></a>
  <a href="index.php?goblins=16&chief=Snuch Nawdow grandchief&shovels=10"><pre>index.php?goblins=16&chief=Snuch Nawdow grandchief&shovels=10</pre></a>
  <a href="index.php?goblins=5&chief=Snuch Nawdow secretary&shovels=10"><pre>index.php?goblins=5&chief=Snuch Nawdow secretary&shovels=10</pre></a>
  <a href="index.php?goblins=5&chief=Snuch Nawdow lil%27chief&shovels=10"><pre>index.php?goblins=5&chief=Snuch Nawdow lil'chief&shovels=10</pre></a>
</body>
</html>