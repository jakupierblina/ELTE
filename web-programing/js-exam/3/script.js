const canvas  = document.querySelector("canvas")
const ctx     = canvas.getContext("2d")

const plus = document.getElementById('plus')
const minus = document.getElementById('minus')


function getRndInteger(min, max) {
    return Math.floor(Math.random() * (max - min + 1) ) + min;
}

let array = []

for(let i= 0; i<=6; i++) {
    array.push(getRndInteger(50, 380))
}

function draw(){
    ctx.drawImage(bg, 0, 0)
    // TODO

    // drawing the blue line
    array.forEach(function(el, i) {
        if(i < array.length - 1) {
            ctx.beginPath();
            ctx.moveTo((i+1) * 100, 400 - el);
            ctx.lineTo((i+2) * 100, 400 - array[i+1]);
            ctx.strokeStyle = '#0000ff'
            ctx.lineWidth = 3
            ctx.stroke();
        }
    })

    // drawing the red line
    ctx.beginPath();
    ctx.moveTo(700, 400 - array[6])
    ctx.lineTo(800, 400 - array[6])
    ctx.strokeStyle = '#ff0000'
    ctx.lineWidth = 3
    ctx.stroke()
}

console.log("Random Array:", array)

let bg        = new Image()
bg.src        = "bg.png"
bg.onload     = draw

// plus.addEventListener("click", function() {
//     ctx.clearRect(0, 0, 800, 400);
//     draw()
// })