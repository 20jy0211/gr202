function send_qr(form){
    if(confirm('登録メールアドレスにQR-コードを発行しますか？')){
        form.submit();
    }else{
        return;
    }
    
}