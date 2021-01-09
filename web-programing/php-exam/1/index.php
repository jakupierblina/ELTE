<?php
$activities = [
    1 => [
        "name" => "sleeping",
        "difficulty" => 0.05
    ],
    2 => [
        "name" => "mining",
        "difficulty" => 0.6
    ],
    3 => [
        "name" => "family time",
        "difficulty" => 0.4
    ],
    4 => [
        "name" => "programming",
        "difficulty" => 0.95
    ],
    5 => [
        "name" => "poaching",
        "difficulty" => 0.7
    ],
    6 => [
        "name" => "hunting",
        "difficulty" => 0.6
    ],
    7 => [
        "name" => "playing",
        "difficulty" => 0.0
    ],
    8 => [
        "name" => "cooking",
        "difficulty" => 0.6
    ]
];

$goblins = [
    "WEB'LIN" => [
        [
            "startHour" => 0,
            "activityKey" => 3
        ],
        [
            "startHour" => 1,
            "activityKey" => 3
        ],
        [
            "startHour" => 3,
            "activityKey" => 5
        ],
        [
            "startHour" => 4,
            "activityKey" => 4
        ],
        [
            "startHour" => 5,
            "activityKey" => 4
        ],
        [
            "startHour" => 7,
            "activityKey" => 1
        ]
    ],
    "HUN'TER" => [
        [
            "startHour" => 0,
            "activityKey" => 1
        ],
        [
            "startHour" => 1,
            "activityKey" => 6
        ],
        [
            "startHour" => 3,
            "activityKey" => 3
        ],
        [
            "startHour" => 4,
            "activityKey" => 3
        ],
        [
            "startHour" => 5,
            "activityKey" => 6
        ],
        [
            "startHour" => 7,
            "activityKey" => 6
        ]
    ],
    "MOT'HER" => [
        [
            "startHour" => 0,
            "activityKey" => 3
        ],
        [
            "startHour" => 1,
            "activityKey" => 3
        ],
        [
            "startHour" => 3,
            "activityKey" => 6
        ],
        [
            "startHour" => 4,
            "activityKey" => 8
        ],
        [
            "startHour" => 5,
            "activityKey" => 8
        ],
        [
            "startHour" => 7,
            "activityKey" => 3
        ]
    ],
    "GOB'KID" => [
        [
            "startHour" => 0,
            "activityKey" => 7
        ],
        [
            "startHour" => 1,
            "activityKey" => 7
        ],
        [
            "startHour" => 3,
            "activityKey" => 7
        ],
        [
            "startHour" => 4,
            "activityKey" => 7
        ],
        [
            "startHour" => 5,
            "activityKey" => 7
        ],
        [
            "startHour" => 7,
            "activityKey" => 7
        ]
    ]
];


?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task 1</title>
    <style>
        table, td, th {
            border: 1px black solid;
            border-collapse: collapse;
        }
        td { text-align: center; }
    </style>
</head>

<body>
    <h1>Task 1</h1>
    <h2>Timetable</h2>
    <table>
        <tr>
            <th>Time</th>
            <?php foreach($goblins as $key=> $value){
                echo("<th>". $key ."</th> ");
            }?>   
           
        </tr>
        <tr>
            <td>0</td>
           
            <?php 
            foreach($goblins as $key=>$value)
            {
                foreach($value as $val){
                    if($val['startHour']==0){
                        // echo("<td>". $activities[$e['activityKey']]['name']."</td><");
                        if($activities[$val['activityKey']]['difficulty']<=0.5){
                            echo("<td style='background-color:lightgreen'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        elseif($activities[$val['activityKey']]['difficulty']>0.5 && $activities[$val['activityKey']]['difficulty']<0.8)
                        {
                            echo("<td style='background-color:orange'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        else{
                            echo("<td style='background-color:red'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                    }
                }
            }
            
            
            ?>
       
        </tr>
        <tr>
            <td>1</td>
            <?php 
            foreach($goblins as $key=>$value)
            {
                foreach($value as $val){
                    if($val['startHour']==1){
                        if($activities[$val['activityKey']]['difficulty']<=0.5){
                            echo("<td style='background-color:lightgreen'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        elseif($activities[$val['activityKey']]['difficulty']>0.5 && $activities[$val['activityKey']]['difficulty']<0.8)
                        {
                            echo("<td style='background-color:orange'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        else{
                            echo("<td style='background-color:red'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                    }
                }
            }
            
            
            ?>
      
        </tr>
        <tr>
            <td>2</td>
            <?php 
            foreach($goblins as $key=>$value)
            {
                foreach($value as $val){
                    if($val['startHour']==2){
                        if($activities[$val['activityKey']]['difficulty']<=0.5){
                            echo("<td style='background-color:lightgreen'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        elseif($activities[$val['activityKey']]['difficulty']>0.5 && $activities[$val['activityKey']]['difficulty']<0.8)
                        {
                            echo("<td style='background-color:orange'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        else{
                            echo("<td style='background-color:red'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                    }
                }
            }
            
            
            ?>
        </tr>
        <tr>
            <td>3</td>
            <?php 
            foreach($goblins as $key=>$value)
            {
                foreach($value as $val){
                    if($val['startHour']==3){
                        if($activities[$val['activityKey']]['difficulty']<=0.5){
                            echo("<td style='background-color:lightgreen'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        elseif($activities[$val['activityKey']]['difficulty']>0.5 && $activities[$val['activityKey']]['difficulty']<0.8)
                        {
                            echo("<td style='background-color:orange'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        else{
                            echo("<td style='background-color:red'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                    }
                }
            }
            
            
            ?>
        </tr>
        <tr>
            <td>4</td>
            <?php 
            foreach($goblins as $key=>$value)
            {
                foreach($value as $val){
                    if($val['startHour']==4){
                        if($activities[$val['activityKey']]['difficulty']<=0.5){
                            echo("<td style='background-color:lightgreen'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        elseif($activities[$val['activityKey']]['difficulty']>0.5 && $activities[$val['activityKey']]['difficulty']<0.8)
                        {
                            echo("<td style='background-color:orange'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        else{
                            echo("<td style='background-color:red'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                    }
                }
            }
            
            
            ?>
        </tr>
        <tr>
            <td>5</td>
            <?php 
            foreach($goblins as $key=>$value)
            {
                foreach($value as $val){
                    if($val['startHour']==5){
                        if($activities[$val['activityKey']]['difficulty']<=0.5){
                            echo("<td style='background-color:lightgreen'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        elseif($activities[$val['activityKey']]['difficulty']>0.5 && $activities[$val['activityKey']]['difficulty']<0.8)
                        {
                            echo("<td style='background-color:orange'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        else{
                            echo("<td style='background-color:red'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                    }
                }
            }
            
            
            ?>
        </tr>
        <tr>
            <td>6</td>
            <?php 
            foreach($goblins as $key=>$value)
            {
                foreach($value as $val){
                    if($val['startHour']==6){
                        if($activities[$val['activityKey']]['difficulty']<=0.5){
                            echo("<td style='background-color:lightgreen'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        elseif($activities[$val['activityKey']]['difficulty']>0.5 && $activities[$val['activityKey']]['difficulty']<0.8)
                        {
                            echo("<td style='background-color:orange'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        else{
                            echo("<td style='background-color:red'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                    }
                }
            }
            
            
            ?>
        </tr>
        <tr>
            <td>7</td>
            <?php 
            foreach($goblins as $key=>$value)
            {
                foreach($value as $val){
                    if($val['startHour']==7){
                        if($activities[$val['activityKey']]['difficulty']<=0.5){
                            echo("<td style='background-color:lightgreen'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        elseif($activities[$val['activityKey']]['difficulty']>0.5 && $activities[$val['activityKey']]['difficulty']<0.8)
                        {
                            echo("<td style='background-color:orange'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                        else{
                            echo("<td style='background-color:red'>". $activities[$val['activityKey']]['name']."</td>");
                        }
                    }
                }
            }
            
            
            ?>
        </tr>
       
    </table>
</body>

</html>