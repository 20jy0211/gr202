let regExp = /\d$/;
let regSpace = /\s/;
let regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;

function isSubmit(form){
	let errorMsg = '';
	errorMsg += checkEmail()+checkText()+checkeNum()+checkBrith()+ checkI_expiry_date()+regPassword();
	
    if(errorMsg === ''){
        form.submit();
    }else{
        alert(errorMsg);
		return;

    }
}
function checkEmail(){
	let items_email = document.querySelector(".registTable input[type='email']");
	if(!regEmail.test(items_email.value) || items_email.value.length > 64) {
		return '正しいメールアドレスを入力してください。最大64文字まで\n';
	}
	
	return '';
}

function checkBrith(){
    let brith = document.querySelectorAll(".birthday input[type='number']");
    let isError = false;
    if(brith[0].value.length < 4)isError = true;
    if(brith[1].value.length < 2) isError = true;
    if(brith[2].value.length < 2) isError = true;
    if(brith[1].value > 1 && brith[1].value > 12) isError = true;
    if(brith[2].value > 1 && brith[2].value > 31) isError = true;
	if(isError) return '正しい生年月日を入力してください。例)1990 09 05\n';
	return '';
}

function checkI_expiry_date(){
	let expiry_date = document.querySelectorAll(".hoken_td input[type='number']");
    if(expiry_date[0].value.length < 4 || expiry_date[1].value.length < 2 || 
		expiry_date[2].value.length < 2 || expiry_date[1].value > 1 && expiry_date[1].value > 12 || 
		expiry_date[2].value > 1 && expiry_date[2].value > 31)
		return '正しい有効期限を入力してください。例)2022 05 09\n';
	return '';
}

function checkText(){
	let items_text = document.querySelectorAll(".registTable input[type='text']");
    for(let i of items_text){
        if(i.value === "" || i.value === null || regSpace.test(i.value)) {
            return 'テキストボックスにはスペース・空白禁止です。\n';
        }
    }
	return '';
}

function checkeNum(){
	let items_num = document.querySelectorAll(".registTable input[type='number']");
    for(let i of items_num){
        if(i.value === "" || i.value === null || regSpace.test(i.value) || !regExp.test(i.value)) {
            return '数字ボックスにはスペース・空白禁止です。\n';
        }
    }
	return '';
}

function regPassword(){
 	let pw1 = document.getElementById('pw1').value;
    let pw2 = document.getElementById('pw2').value;
	let errorMsg = '';
    if(pw1 === "" || pw1 === null || regSpace.test(pw1) || pw1.length > 64 || pw2.length > 64) {
        errorMsg = 'パスワードは英数字のみ8桁以上64桁以下です。\n';
    }
	if(pw1 !== pw2) errorMsg = 'パスワードをもう一度確認してください。';
    return errorMsg;
}

