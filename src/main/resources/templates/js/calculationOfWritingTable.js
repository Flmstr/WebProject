 $(document).ready(function() {
    var showLine = 0;
    //Очищаем значения, т.к. некорректно отображается пустой инпут числа
    resetForm();
    //Показываем первую запись
    $(".0").show(500);
    showLine++;

    $( "#mainForm" ).bind( "reset", function() {
        resetForm();
    });


    $( ".quantity, .price , .discount" ).keyup(function(e) {
        var targetID = e.target.id;
        var id = targetID.match(/\d+/);
        var price =  parseFloat($(".price:eq("+ id +")").val());
        var discount = parseFloat($(".discount:eq("+ id +")").val());
        var quantity = $(".quantity:eq("+ id +")").val();

        if (id == showLine - 1){
            showLines();
        }

            if (id){
                var sum = (quantity * price).toFixed(2);
                if (sum != "NaN"){
                    $('.sum:eq('+ id +')').val(sum);
                    $(".endSum:eq("+ id +")").val((sum - discount).toFixed(2));
                }
                else{
                    $('.sum:eq('+ id +')').val(0);
                    $(".endSum:eq("+ id +")").val(0);
                    $(".discount:eq("+ id +")").val(0);
                }
            }
      });

    $("#mainForm").validate();
    $(".quantity, .price, .discount ").each(function() {
        $(this).rules('add', {
            number: true
        });
    $(".quantity, .price, .discount ").rules('add', {
        messages: {
            number:"Введите число"
        }
        });
    });


      $('.employeesname').autocomplete({
                      source: 'query/EmployeesNames',
                      delay: 0
                  });
      $('.typework').autocomplete({
                      source: 'query/TypeWork',
                      delay: 0
                  });
      $('#company').autocomplete({
                      source: '/query/Organization',
                      delay: 0
                  });
      $('#address').autocomplete({
                      source: function(request, response) {
                                  $.getJSON(
                                  '/query/Address',
                                  { term:request.term, company:$('#company').val() },
                                  response);},
                      delay: 0
                  });

      function showLines() {
        $("."+showLine).show(500);
        showLine++;
      }
      function resetForm(){
//        $( ".company" ).val("");
//        $( ".address" ).val("");
//        $( ".nameObject" ).val("");
//        $( ".quantity" ).val("");
//        $( ".price" ).val("");
//        $( ".sum" ).val("");
//        $( ".discount" ).val("");
//        $( ".endSum" ).val("");
//        $( ".typework" ).val("");
//        $( ".employeesname" ).val("");
      }

 });