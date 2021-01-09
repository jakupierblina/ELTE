const textarea = document.querySelector('#text-image-urls')
const button = document.querySelector('#button-to-select')
const select = document.querySelector('#select-image-urls')
const border = document.querySelector('#border')
const div = document.querySelector('#images')
const bigImage = document.querySelector('#big')


button.addEventListener("click", function(evt) {
    var rawUrls = textarea.value
    var urls = rawUrls.split("\n")
    console.log(urls)
    var previousOptions = document.getElementsByTagName('option');
    if (previousOptions.length) {
        Array.from(previousOptions).forEach(function(prevOpt) {
            select.removeChild(prevOpt)
        })
    }
    urls.forEach(function(url) {
        var opt = document.createElement('option')
        opt.appendChild( document.createTextNode(url) );
        opt.value = url;
        select.appendChild(opt)
    })
})

select.addEventListener('change', function(e, v) {
    var selected = document.querySelectorAll('#select-image-urls option:checked');
    const selectedUrls = Array.from(selected).map(el => el.value);
    var prevImages = document.getElementsByClassName('small-image');
    console.log(prevImages)
    if(prevImages.length) {
        Array.from(prevImages).forEach(function(prevImg) {
            div.removeChild(prevImg)
        })
    } 
    selectedUrls.forEach(function(url) {
        var img = document.createElement('img');
        img.src = url;
        img.height = 100;
        img.width = 100;
        img.classList.add("small-image") 
        div.appendChild(img)
        
        img.addEventListener('mouseover', function(evt) {
            bigImage.src = url
        })
    })
})

border.addEventListener("change", function(e) {
    var borderWidth = e.target.value
    bigImage.style.borderWidth = borderWidth + "px"
})