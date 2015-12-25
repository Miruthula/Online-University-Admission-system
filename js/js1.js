/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$( document ).ready(function() {
   //alert("hii");
    $( "#datepicker" ).datepicker();
    $( "#datepicker1" ).datepicker();

    $('input[id="datepicker1"]').prop('disabled',false);
    $('input[class=one-radio]').on('click', function(){            
        $('#datepicker1').prop('disabled',true);
    });
    $('input[class=round-radio]').on('click', function(){            
        $('#datepicker1').prop('disabled',false);
    });
    
    $(".searchbutton").click(function() {
       if($("#source").val() == $("#destination").val()) {
           confirm("Source and Destination cannot be the same.Please choose a different Source and a different Destination");
        window.location.reload();
        }
        });
    });
   
   