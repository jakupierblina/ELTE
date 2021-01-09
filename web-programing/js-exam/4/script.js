
const placesInput = document.querySelector('#number')
const speciesInput = document.querySelector('#number')
const tableContainer = document.querySelector('#table-container')

const button = document.querySelector('#start')

let matrix = []
var table = document.createElement("table"); 


button.addEventListener('click', onGenerate)
function onGenerate(e) {
  //document.getElementById("controls").hide();
  //$('#controls').hide();
  document.getElementById('controls').style.display = 'none';
  const n = placesInput.valueAsNumber
  const m = speciesInput.valueAsNumber

  matrix = generateMatrix(n, m)
  console.log(matrix);


  var existingTable = document.getElementsByTagName("table")[0];

  if(existingTable) {
    tableContainer.removeChild(existingTable)
  }

  matrix.forEach(function(el, i) {
    var row = document.createElement('tr');
    el.forEach(function(elem, j) {
    var cell = document.createElement("td");
    cell.style.border = '1px solid black';
    
    var cellText = document.createTextNode(elem);
    cell.appendChild(cellText);
    row.appendChild(cell);


      //event listeners

      cell.addEventListener('click', function() {
        console.log("Row:", i," ", "Column:", j)
        alert("Row:" + i + " " +"Column:" + j)
        //document.innerHTML.style.color = black;
      })
    })
    table.appendChild(row);
  })

  tableContainer.appendChild(table)
}


function generateMatrix(n, m) {
  const matrix = []
  for(let i = 0; i<n; i++) {
    const row = []
    for(let j = 0; j<m; j++) {
      row.push('')
      //table.style.border = '1px solid black';
    }
    matrix.push(row)
  }
  return matrix
}

