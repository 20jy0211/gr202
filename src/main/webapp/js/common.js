//header
var _window = $(window),
    _header = $('.site-header'),
    logo_text = $('.logo_text'),
    menu_bar = $('.menu_bar'),
    account_menu = $('.account-btn'),
    singup_btn = $('.singup_btn'),
    login_btn = $('.login_btn');

_window.on('scroll',function(){
    if(_window.scrollTop() > 20){
        _header.addClass('transform');   
        logo_text.addClass('transform');   
        menu_bar.addClass('transform');
        account_menu.addClass('transform');
        singup_btn.addClass('transform');
        login_btn.addClass('transform');   
    }
    else{
        _header.removeClass('transform');   
        logo_text.removeClass('transform');  
        menu_bar.removeClass('transform');
        account_menu.removeClass('transform');
        singup_btn.removeClass('transform');
        login_btn.removeClass('transform');  
    }
    
  });

  let currentMenu;
  for(let item of menu_bar){
    item.addEventListener('click',function(e){
      e.preventDefault();
          if(e.target.className.indexOf('active') == -1){
            activeMenu(e.target);
          }else{
            removeActiveMenu(e.target);
          }
          console.log(e.target);
          location.href = e.target.href;
      });
  }
_window.trigger('scroll');

//scroll top btn
$(window).scroll(function () {
    if ($(this).scrollTop() > 20) {
      $('.top_btn_con').fadeIn(500);
    } else {
      $('.top_btn_con').fadeOut('fast');
    }
  });

$('.top_btn_con').click(function (e) {
  e.preventDefault();
  $('html, body').animate({scrollTop: 0}, 200);
});
  let top_btn = document.getElementById('top_btn_con');
  let footer = document.querySelector('footer');
  document.getElementById('account-btn-check').addEventListener('click', function(){
    if(top_btn.style.position === 'unset'){
        top_btn.style.position = 'fixed';
        footer.style.display = 'block';
    }else{
        top_btn.style.position = 'unset';
        footer.style.display = 'unset';
    }
  })


function activeMenu(element){
  element.classList.add('menu_a_active');
  element.parentElement.classList.add('menu_li_active');
  currentMenu = element;
}

function removeActiveMenu(element){
  element.classList.remove('menu_a_active');
  element.parentElement.classList.remove('menu_li_active');
}

