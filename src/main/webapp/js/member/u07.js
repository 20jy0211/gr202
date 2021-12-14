function addSubmit(form){
    let items = document.querySelectorAll('.items input');
    
    //space tap enterがあればreturn true
    let regSpace = /\s/g;
    let isError = false;
    let errorMsg = "以下の項目に空白・スペースがあります。\n";
    let regNum = /^([0-9]{0,7})$/;
    
    for(let i of items){
        if(i.value === "" || i.value === null || regSpace.test(i.value)){
            //電話番号のINPUTの場合兄弟のElementがnull
            if(i.previousElementSibling !== null){
                errorMsg += i.previousElementSibling.textContent+ " ";
            }
            isError = true;
        }
    }
    if(!regNum.test(items[0].value)){
        isError = true;
        errorMsg += "\n 子供医療証の番号は 7桁以下です。"
    }
    if(!isError) form.submit();
    else alert(errorMsg);
}
function isUpdate(form){
    let items = document.querySelectorAll('.items input');
    
    //space tap enterがあればreturn true
    let regSpace = /\s/g;
    let isError = false;
    let errorMsg = "以下の項目に空白・スペースがあります。\n";
    let regNum = /^([0-9]{0,7})$/;
    
    for(let i of items){
        if(i.value === "" || i.value === null || regSpace.test(i.value)){
            //電話番号のINPUTの場合兄弟のElementがnull
            if(i.previousElementSibling !== null){
                errorMsg += i.previousElementSibling.textContent+ " ";
            }
            isError = true;
        }
    }
    if(!regNum.test(items[0].value)){
        isError = true;
        errorMsg += "\n 子供医療証の番号は 7桁以下です。"
    }
    if(confirm('子供情報変更をしますか？')){
        if(!isError) form.submit();
        else alert(errorMsg);
    }else{
        return;
    }
}

function isSubmit(form){
    if(confirm('子供登録をしますか？')) form.submit();
    else return;
}