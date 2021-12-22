let regExp = /\d$/;
let regSpace = /\s/;
let regEmail = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}.[A-Za-z0-9]{1,}$/;
let regLength = /[a-zA-Z0-9]{8,50}$/;

function isSubmit(form){
    let items_email = document.querySelector(".registTable input[type='email']");
    let items_text = document.querySelectorAll(".registTable input[type='text']");
    let items_num = document.querySelectorAll(".registTable input[type='number']");
    let pw1 = document.getElementById('pw1').value;
    let pw2 = document.getElementById('pw2').value;
    
    if(!checkText(items_text) && !checkeNum(items_num) && !regPassword(pw1, pw2) && regEmail.test(items_email.value)){
        form.submit();
    }else{
        alert('入力欄にはスペース・空白禁止です。修正してください。\n パスワードは8桁以上です。');
    }
}
function checkText(items_text){
    for(let i of items_text){
        if(i.value === "" || i.value === null || regSpace.test(i.value)) {
            return true;
        }
    }
    return false;
}

function checkeNum(items_num){
    for(let i of items_num){
        if(i.value === "" || i.value === null || regSpace.test(i.value) || !regExp.test(i.value)) {
            return true;
        }
    }
    return false;
}

function regPassword(pw1, pw2){
    if(pw1 === "" || pw1 === null || regSpace.test(pw1) ||  pw1 != pw2) {
        return true;
    }
    return false;
}