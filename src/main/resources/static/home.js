$(document).ready(function () {

    $('#btn_submit').on("click", function (e) {
        e.preventDefault();
        $.ajax({
            type: "GET",
            url: "/clients",
            timeout: 60000,
            success: function (response) {
                $("#result tbody").html("");
                if(response.length > 0) {
                    for (i = 0; i < response.length; i++) {
                        $("#result tbody").append(
                            "<tr id="+ response[i].clientId +" >" +
                                "<td> " + response[i].clientId + "</td>" +
                                "<td id='firstName'>" + response[i].firstName + "</td>" +
                                "<td id='lastName'>" + response[i].lastName + "</td>" +
                                "<td id='telephoneNumber'>" + response[i].telephoneNumber + "</td>" +
                                "<td id='city'>" + response[i].city + "</td>" +
                                "<td id='street'>" + response[i].street + "</td>" +
                                "<td id='zipCode'>" + response[i].zipCode + "</td>" +
                                "<td> " +
                                    "<button type='button' class='btn btn-warning' id='btn_update' value="+response[i].clientId+">Click to Update</button> " +
                                    "<button type='button' class='btn btn-danger' id='btn_delete' value="+response[i].clientId+">Delete</button> " +
                                "</td>" +
                            "</tr>"
                        );
                    }
                    $("#result").show();
                }
                else{
                    alert("No clients available")
                }
            }
        });

    });

    $('#btn_submit_form').on("click", function (e) {
        e.preventDefault();
        if(($('#firstName').length && $('#lastName').length) >= 1){
            $.ajax({
                type: "POST",
                url: "/client",
                data: $('#clientInfo').serialize(),
                timeout: 60000,
                success: function (response) {
                    alert("Client successfully created with Id  "+response);
                    $('button#reset').click();
                    $('button#btn_submit').click();
                }
            });
        }else{
            alert("Please input client details")
        }


    });

    $('#result tbody').on('click','#btn_delete',  function (e) {
        var id = $('#btn_delete').attr('value');
        $.ajax({
            type: "DELETE",
            url: "/client/"+id,
            timeout: 60000,
            success: function () {
                alert("Client successfully deleted with Id  "+id)
                $('#result tbody #'+id).remove();
            }
        });

    });

    $('#result tbody').on('click','#btn_update',  function (e) {
        var id = $(this).attr('value');
        var firstNameSelector = "#result tbody #"+id+" #firstName";
        var lastNameSelector = "#result tbody #"+id+" #lastName";
        var telephoneNumberSelector = "#result tbody #"+id+" #telephoneNumber";
        var citySelector = "#result tbody #"+id+" #city";
        var streetSelector = "#result tbody #"+id+" #street";
        var zipCodeSelector = "#result tbody #"+id+" #zipCode";

        var firstName = $(firstNameSelector).text();
        var lastName = $(lastNameSelector).text();
        var telephoneNumber = $(telephoneNumberSelector).text();
        var city = $(citySelector).text();
        var street = $(streetSelector).text();
        var zipCode = $(zipCodeSelector).text();

        $('#firstName').val(firstName);
        $('#lastName').val(lastName);
        $('#telephoneNumber').val(telephoneNumber);
        $('#city').val(city);
        $('#street').val(street);
        $('#zipCode').val(zipCode);

        alert("Update client details for id " +id)
        $( "#firstName" ).focus();
        $("#submit_main").hide();
        $("#btn_update").hide();
        $("#update_main").show();
        $("#btn_update_form").attr("value", id);
    });

    $('#btn_update_form').on('click',function (e) {
        var updateId = $('#btn_update_form').attr('value');
        e.preventDefault();
        $.ajax({
            type: "PUT",
            url: "/client/"+updateId,
            data: $('#clientInfo').serialize(),
            timeout: 600000,
            success: function (response) {
                alert("Update successful with id "+ response);
                $("#btn_update_form").attr("value", "");
                $("#update_main").hide();
                $("#submit_main").show();
                $('button#btn_submit').click();

            }
        });
    });


});