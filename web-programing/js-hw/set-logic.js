//atributes i need
var players_array = [ ];
var level;
var optionmode;
var lsit = "";

//when the button submit is pressed save the selected option 
var submit = $("#submit");


function show(){ 
  
  /** SAVE the LABELS **/
   level = $('#optionlevel option:selected').val();
  optionplayers = $('#optionplayers option:selected').val();
  optionmode = $('#optionmode option:selected').val();

 var x = document.getElementById("gamedesk");
 var t = document.getElementById("context");

  if (x.style.display === "none") {
    x.style.display = "block";
  } else if(x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
  }

  if ( x.style.display === "none"){
    t.style.display ="block";
  } else {
        t.style.display ="none";

  }

  startGame();
 
}

/** TIMER  */

function starttime(){
    let timeleft = 10;
    var downloadTimer = setInterval(function(){
    timeleft--;
    document.getElementById("timer").textContent = timeleft;
    if(timeleft < 0)
        clearInterval(downloadTimer);
    if(timeleft == 0) {
        alert("Time is done");
    }
    },1000);


}
/*** Insert in array the names of players everytime you press enter ***/
function submitname(){

    var name = document.getElementById("playersname").required;
    var nam = $('#playersname').val();
    players_array.push(nam,0);
    alert("Thank you we registerd the name");
}


/** DESK**/


var deck = [];
var on_table = []; // unique number (0 - 80) for each card
var selected = []; // indicies (0 - 11 or 14) of selected cards in on_table
var score =0;

var start_time = 0;
var final_time = null;
const pad2 = num => num.toString().padStart(2, '0');


function startGame() {


  showplayers();
  assaignDeck();
  assaignCards();
  updateDeckCount(); 

}

function starover(){
    score=0;
  showplayers();
  assaignDeck();
  assaignCards();
  updateDeckCount(); 

}

 /*** SHOW LIST***/
function showplayers(){
    for (prop in  players_array){
      document.getElementById('result').innerHTML +='<li>' + "default player" +'</li>';
    }
}

//refresh-assaign new cards in table
function assaignCards() {

    var grid = document.getElementById("cardsOnTable");
    //row
    for (var r = 0; r < 4; r++) {
        //column
        for (var c = 0; c < 3; c++) {
            var card_num = deck.pop();
            var image_tag = '<img src="cards/'.concat(card_num.toString(), '.png">');
            grid.rows[r].cells[c].style.visibility = "visible"; 
            grid.rows[r].cells[c].innerHTML = image_tag; 
            on_table.push(card_num);
        }
    }
}

function updateDeckCount() {
        document.getElementById("levelcount").innerHTML = "Level: " + level;
        document.getElementById("deckCount").innerHTML = 
        "Cards left in deck: ".concat(deck.length.toString());
         document.getElementById("score").innerHTML = "Score: " + score;

}

function assaignDeck() {
    deck = [];
    on_table = [];
    selected = [];
    var notification = document.getElementById("notification");

    //select level
     if (level == "Starter"){ 
        for (var i = 0; i < 27 ; i++) {
            deck.push(i);
        }
    } else if (level === "Advanced"){
         for (var i = 0; i < 81; i++) {
                    deck.push(i);
       }

    }
  
    document.getElementById("deck").style.visibility = "visible";


    shuffleDeck();
}

function shuffleDeck() {
    for (var tmp = 0; tmp < deck.length; tmp++) {
        swapx = tmp + Math.floor(Math.random() * (deck.length - tmp));
        var tmp2 = deck[tmp];
        deck[tmp] = deck[swapx];
        deck[swapx] = tmp2;
    }


}

function selectCard(elmnt, loc) {

    document.getElementById("notification").style.color = "black";
    
    // Check if loc already in selected array (-1 if not)
    var select = selected.indexOf(loc);

    // Deselect card
    if (select >= 0) {
        selected.splice(select, 1);
        elmnt.style.border = "5px solid #bfbfbf";
    // Select card
    } else if (select < 0 && selected.length < 3) {
        selected.push(loc); 
        elmnt.style.border = "5px solid black";
        if (selected.length == 3) {
            checkSelectedSet();
        } 
    }
}


function replaceCards(cardIds) {
    var deckLogo = document.getElementById("deck");
    if (deck.length > 0) {
        for (var i = 0; i < cardIds.length; i++) {
            var new_card = deck.pop();
            var image_tag = '<img src="cards/'.concat(new_card.toString(), '.png">');
            var cellid = "cell".concat(cardIds[i].toString); 
            var cell = document.getElementById("cell".concat(cardIds[i].toString()));
            on_table.splice(cardIds[i], 1, new_card) 
            cell.innerHTML = image_tag;
            cell.style.border = "5px solid #bfbfbf";
        }
        deckLogo.style.visibility = (deck.length == 0 ? "hidden" : "visible");
    } else {
        for (var i = 0; i < cardIds.length; i++) {
            var cellid = "cell".concat(cardIds[i].toString); 
            var cell = document.getElementById("cell".concat(cardIds[i].toString()));
            on_table.splice(cardIds[i], 1, -1) 
            cell.style.border = "5px solid #bfbfbf";
        }
        for (var i = on_table.length-1; i >= 0; i--) {
            if (on_table[i] == -1) {
                on_table.splice(i, 1);
            } 
        }
        for (var i = 0; i < 12; i++) {
            var cell = document.getElementById("cell".concat(i.toString()));
            if (i < on_table.length) {
                cell.innerHTML = '<img src="cards/'.concat(on_table[i].toString(), '.png">');
            } else {
                cell.style.visibility = "hidden";
            }
        }
    }
    document.getElementById("deck").style.visibility = "visible";
    updateDeckCount();
    selected = [];
    checkRemaining();
}


function getFeatures(possible_set) {
    var color = [];
    var number = [];
    var shape = [];
    var shading = [];
    for (var i in possible_set) {
        color.push(getColor(possible_set[i]));
        number.push(getNumber(possible_set[i]));
        shape.push(getShape(possible_set[i]));
        shading.push(getShading(possible_set[i]));
    }
    return features = [ 
       arrSum(color) % 3,
       arrSum(number) % 3,
       arrSum(shape) % 3,
       arrSum(shading) % 3,
    ];
}

function isSet(features) {
    return arrSum(features) == 0;
}



function checkSelectedSet() {
    
 
    var statusk = document.getElementById("setStatus")

    var possible_set = selected.map(x => on_table[x]);
  
    const names = {0:"color", 1:"number", 2:"shape", 3:"shading"};
    reasons = document.getElementById("reasons");
    reasons.innerHTML = "";


    const features = getFeatures(possible_set);
    if (isSet(features)) {
        
        statusk.innerHTML = "That was a set :)";
        statusk.style.color = "purple";
        score = score+1;
       
        replaceCards(selected);
                      
    } else {
        statusk.innerHTML = "That was not a set :(";
        statusk.style.color = "purple";
        for (var i = 0; i < 4; i++) {
            if (features[i] > 0) {
                console.log(i)
                reasons.innerHTML += "<li>Because 2 cards have same ".concat(names[i], "</li>");
            }
        }
        score = score-1;
        checkRemaining();
    }
    updateDeckCount();
}


function countSets(cards) {
    var count = 0;
    for (var i = 0; i < cards.length; i++) {
        for (var j = i + 1; j < cards.length; j++) {
            for (var k = j + 1; k < cards.length; k++) {
                count = (isSet(getFeatures([cards[i], cards[j], cards[k]])) ? count + 1 : count);   
            }
        }
    }
    return count;
}


function checkRemaining() {
    if (deck.length + on_table.length < 21) {
        var remaining = [];
        remaining.push(...deck);
        remaining.push(...on_table);
        console.log(remaining);
        console.log("sets remaining: ".concat(countSets(remaining).toString()));
        if (countSets(remaining) == 0) {
            var alrt ="Game over!!!! Your score was: " + score;
            alert(alrt);
            location.reload();
        }
    } 
}

const arrSum = arr => arr.reduce((a,b) => a + b, 0);

function getColor(card) {
    if(optionlevel === "Starter"){
    return Math.floor(card / 27);
    } 
    else {
        return Math.floor(card / 81);
    }
}

function getNumber(card) {
    return card % 3;
}

function getShape(card) {
    return Math.floor((card % 9) / 3);
}

function getShading(card) {
    if(optionlevel === "Starter"){
    return Math.floor((card % 27) / 9);
    } else {
      return Math.floor((card % 81) / 9);
  }
}

function isthereaSet(){

    alert("Yes there is a set");
} 


function showmeaset(){
    reasons = document.getElementById("reasons");
  for (var i = 0; i < on_table.length; i++) {
        for (var j = i + 1; j < on_table.length; j++) {
            for (var k = j + 1; k < on_table.length; k++) {
                const fetr =  getFeatures([on_table[i], on_table[j], on_table[k]]);
                if (isSet(fetr)){
                    reasons.innerHTML = "Select elements: "+ getNumber(on_table[i]) + " ,"
                                                           +getNumber(on_table[j]) +" ,"
                                                           +getNumber(on_table[k]);


                }               
                } 
            }
        }
    }

function plusthreecards(){

    var plus = document.getElementById("plus3");
    plus.style.visibility = "visible";

    //increase the length by 3
    on_table.length = on_table.length+3;
    var new_card = document.getElementById("cell10");
    var image_tag = '<img src="cards/'.concat(new_card.toString(), '.png">');

    var newcell1 = document.getElementById("cell12");
    on_table.splice(12, 1, new_card);
    newcell1.innerHTML = image_tag;


    var newcell2 = document.getElementById("cell13");
    on_table.splice(13, 1, new_card);
    newcell2.innerHTML = image_tag;


    var newcell3 = document.getElementById("cell14");
    on_table.splice(14, 1, new_card);
    newcell3.innerHTML = image_tag;

    deck.length = deck.length-3;

    updateDeckCount();
    checkRemaining();

}