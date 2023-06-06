/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


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

function reveal() {
    let reveals = document.querySelectorAll(".reveal");

    for (let i = 0; i < reveals.length; i++) {
        let windowHeight = window.innerHeight;
        let elementTop = reveals[i].getBoundingClientRect().top;
        let elementVisible = 150;

        if (elementTop < windowHeight - elementVisible) {
            reveals[i].classList.add("active");
        }
        // Efecto Opcional donde re recarga la animación:
        // else{
        //     reveals[i].classList.remove("active")
        // }
        // Queda a consideración dejarlo o no
    }
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
window.addEventListener("scroll", reveal);
window.onscroll = function () {
    scrollFunction()
};

function scrollFunction() {
    var scrollBtn = document.getElementById("scrollBtn");
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        scrollBtn.classList.add("show");
    } else {
        scrollBtn.classList.remove("show");
    }
}

function scrollToTop() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}