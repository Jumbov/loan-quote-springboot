
     $(document).ready(function(){
            $("#insert_amount_section").show();         
            $("#quote_section").hide();
     });

      /* --------  functions  --------- */


       

         /* --------  on click events  -------- */

        
        $("#submit").click(function(e) {
        	$("#quote_section").empty();;
            e.preventDefault();
            $.ajax({                                                        
               url: 'http://localhost:8094/loan',
               type: "POST",
               data: {
            	   amount: $("#amount").val()
               },
               success: function (data, status) {
                  $("#quote_section").show();
                  console.log(data);
                  
                  for (var key in data.response) {
                	  $("#quote_section").append("<h3>" + key + ": " + data.response[key] + "</h3>"); 
                  }
                  
               },
               error: function(result) {
            	   $("#quote_section").show();
            	   $("#quote_section").append(result.responseText);
                  console.log(result);
               }
            });
        });

