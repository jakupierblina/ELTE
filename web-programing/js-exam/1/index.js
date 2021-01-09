const txtNumbers = document.querySelector('#numbers')
const task1 = document.querySelector('#task1')
const task2 = document.querySelector('#task2')
const task3 = document.querySelector('#task3')
const task4 = document.querySelector('#task4')
const task5 = document.querySelector('#task5')

txtNumbers.addEventListener("keydown", function(el) {
    createArray(el.target, el.key)
})

function createArray(el, val) {
    var numbers = el.value;
    if(val) {
        numbers += val
    }
    var array = numbers.split(",")
    console.log(array)

    var numberArray = transformToNumbers(array)
    console.log("NumberedArray", numberArray)

    // filter unnecessary elems
    var filteredNumberArray = numberArray.filter(function(elems) {
        return !isNaN(elems)
    })
    console.log("Pure Numbers Only", filteredNumberArray)
    t1(filteredNumberArray)
    t2(filteredNumberArray)
    t3(filteredNumberArray)
    t4(filteredNumberArray)
    t5(filteredNumberArray)
}

function transformToNumbers(arr) {
    return arr.map(function(elem) {
        return parseInt(elem)
    })
}

function t1(arr) {
    var divisibleByThree = arr.filter(function(el) {
        return el % 3 === 0
    }).length

    task1.innerText = divisibleByThree
}

function t2(arr) {
    var negativeNumbers = arr.filter(function(el) {
        return el < 0
    })
    if(negativeNumbers.length) {
        task2.innerText = negativeNumbers[0]
    } else {
        task2.innerText = "No negative number"
    }
}

function t3(arr) {
    var allOdd = arr.every(function(el) {
        return el % 2 === 1
    })
    if (allOdd) {
        task3.innerText = "All numbers are odd"
    } else {
        task3.innerText = "There's at least one even number"

    }
}

function t4(arr) {
    var highest = Math.max(...arr)
    task4.innerText = highest
}

function t5(arr) {
    var unique = [...new Set(arr)];
    console.log(unique.join(","))
    task5.innerText = unique.join(",")
}
createArray(txtNumbers)