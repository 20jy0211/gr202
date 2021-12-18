function isUpdate(form){
    let regEmail = /^[A-Za-z0-9]{1}[A-Za-z0-9_.-]*@{1}[A-Za-z0-9_.-]{1,}.[A-Za-z0-9]{1,}$/;
    let regSpace = /\s/g;
    let items = document.querySelectorAll('.items input');
    let isError = false;
    let emailError = false; 
    if(regEmail.test(items[0].value)) emailError = true;
    for(let i of items){
        if(i.value === null || i.value === '' || regSpace.test(i.value)) isError = true;
    }
    if(emailError){
        if(!isError){
            if(confirm('変更しますか？')) form.submit();
            else return;
        }else{
            alert('パスワードに空白・スペースは禁止です。');
        }
    }else{
        alert('正しいメールアドレスを入力してください。');
    }
}