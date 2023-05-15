function addMarginTop() {
    const divEspecial = document.getElementById('div-especial');
    const windowWidth = window.innerWidth;

    if (windowWidth < 992 && windowWidth > 576) {
        divEspecial.style.marginTop = '38px';
    } else {
        divEspecial.style.marginTop = '0';
    }
}

function rearrangeElements() {
    const windowWidth = window.innerWidth;
    const leftImageDiv = document.getElementById('left-image');
    const rightTextDiv = document.getElementById('right-text');
    const parentElement = rightTextDiv.parentNode;

    if (windowWidth < 992) {
        parentElement.appendChild(leftImageDiv);
    } else {
        parentElement.insertBefore(leftImageDiv, rightTextDiv);
    }
}

function applyMarginToDivImage() {
    const windowWidth = window.innerWidth;
    const divImageElements = document.querySelectorAll('.div-image');

    if (windowWidth < 992) {
        divImageElements.forEach((div) => {
            div.style.marginTop = '10px';
        });
    } else {
        divImageElements.forEach((div) => {
            div.style.marginTop = '0';
        });
    }
}

function changeMarginToDivs() {
    const windowWidth = window.innerWidth;
    const divElements = document.querySelectorAll('.margin-19');

    divElements.forEach((div) => {
        if (windowWidth <= 576) {
            div.style.marginTop = '0';
        } else {
            div.style.marginTop = '';
        }
    });
}

function changeMarginToDivSpecial() {
    const windowWidth = window.innerWidth;
    const divElements = document.querySelectorAll('.margin-38');

    divElements.forEach((div) => {
        if (windowWidth <= 576) {
            div.style.marginTop = '0';
        } else {
            div.style.marginTop = '';
        }
    });
}

window.addEventListener('load', addMarginTop);
window.addEventListener('resize', addMarginTop);
window.addEventListener('load', rearrangeElements);
window.addEventListener('resize', rearrangeElements);
window.addEventListener('load', applyMarginToDivImage);
window.addEventListener('resize', applyMarginToDivImage);
window.addEventListener('load', changeMarginToDivs);
window.addEventListener('resize', changeMarginToDivs);
window.addEventListener('load', changeMarginToDivSpecial);
window.addEventListener('resize', changeMarginToDivSpecial);