function random(a, b) {
    return Math.floor(Math.random() * (b - a + 1)) + a;
}

function scatter(li) {
    const x = random(0, 500);
    const y = random(0, 300);
    const alpha = random (0, 360);
    li.style.transform = `translate3d(${x}px, ${y}px, 0px) rotate(${alpha}deg)`;
}

let selected;

const lis = Array.from(document.querySelectorAll('ul > li'));
lis.forEach(scatter);

document.addEventListener('click', onClick);
function onClick(e) {
    // console.log(e.target);
    if (e.target.matches('img')) {
        if (selected) {
            selected.classList.remove('active');
            scatter(selected);
        }
        const li = e.target.parentNode;
        selected = li;
        li.style.transform = '';
        li.classList.add('active');
    }
}
document.addEventListener('keydown', onKeyPress);
function onKeyPress(e) {
    if (e.key === 'ArrowRight') {
        let i = lis.findIndex(li => li === selected);
        i = (i+1) % lis.length;

        if (selected) {
            selected.classList.remove('active');
            scatter(selected);
        }

        const li = lis[i];
        selected = li;
        li.style.transform = '';
        li.classList.add('active');
    }
}