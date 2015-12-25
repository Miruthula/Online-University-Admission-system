/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$( document ).ready(function() {
//alert('hhh');
//    $('.go').click( function() {
//    window.location = $(this).attr('href') + '=' + $('.search').val();
//    return false;
//        });
   
   $( "#datepicker" ).datepicker();
   
   $( "#datepicker1" ).datepicker();

$('input[id="datepicker1"]').prop('disabled',false);
$('input[class=one-radio]').on('click', function(){            
    $('#datepicker1').prop('disabled',true);
});
$('input[class=round-radio]').on('click', function(){            
    $('#datepicker1').prop('disabled',false);
});
   });