$(function(){
    $('#language-selector').change(function (){
        const lang = $('#language-selector').val();
        if(lang){
            window.location.replace('?lang=' + lang);
        }
    });
});