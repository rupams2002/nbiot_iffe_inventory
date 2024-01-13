//strRoot = "ApplicationPath";

$(document).ready(function () {
	
	
    $("#sendCCMSMessage1").on('click',function(){
        strIPAddress   = $('#hostIP1').val();
        strOID  = $('#ccms_oid1').val();
        strTrap = $('#messageCCMS1').val();

        sendCCMSMessageToDB(strIPAddress, strOID, strTrap);
    });

    $(".back").on('click',function() {
        parent.history.back();
        return false;
    });    
    

}); 


function APICallToSciLo(fiberID){


    $.ajax({
       type: 'GET',
       async: false,
       data: {
			fiberID: fiberID,
       },                   
       url: "/cms-service/webapi/sendAlerttoScilo",
       error: function(data) { alert("Error in 'cms-service/webapi/sendAlerttoScilo'");},
       success: function(data) {
            console.log(data);            

            if( $.trim(data)==='SUCCESS'){
                $('#TrapLebel').show('Highlight');
                $('#TrapLebel').show().delay(4000).fadeOut();
            }
       }    
    });



/*
    $.ajax({
       type: 'POST',
       async: false,
       dataType: 'json',
       crossDomain: true,
       xhrFields: {
         'withCredentials': true 
      },
	   headers: {
			//authorization: 'Basic ZW03YWRtaW46ZW03YWRtaW4=',     
			'Authorization': 'Basic bW9oYW1tZWRAbGlnYWRvLmNvbTpSdXBhbSoqMTIz',     
			'Access-Control-Allow-Origin': 'https://10.1.3.115',
			'Access-Control-Allow-Credentials': true,
            'Content-Type': 'application/json; charset=utf-8',
            'Accept': 'application/json; charset=utf-8'   
	   },       
       data: {
			force_ytype:'0',
			force_yid:'0',
			force_yname:'',
			message:'Hello World 1',
			value:'',
			threshold:'',
			message_time:'0',
			aligned_resource:'/api/device/1689'
       },                   
       url: 'https://10.1.3.115/api/alert',
       error: function(jqXHR, textStatus, errorThrown) { 
			console.log("Error in 'https://10.1.3.115/api/alert'");
			console.log(textStatus, errorThrown);
	   },
       success: function(data) {
            console.log(data);            

            if( $.trim(data)==='SUCCESS'){
                $('#TrapLebel').show('Highlight');
                $('#TrapLebel').show().delay(4000).fadeOut();
            }
       }    
    });
*/    

}




/*
function APICallToSciLo(id){
	alert(id);
	
    $.ajax({
       type: 'POST',
       data: {
          strIPAddress: strIPAddress,
          strOID: strOID,
          strTrap: strTrap
       },                   
       async: false,
       //url: "/" + strRoot + "/cms-service/webapi/apiservice/nbiot/v1/nbiot_iffe_inventory",
       url: "/cms-service/webapi/apiservice/nbiot/v1/nbiot_iffe_inventory",
       error: function(data) { alert("Error in 'cms-service/webapi/apiservice/nbiot/v1/nbiot_iffe_inventory'");},
       success: function(data) {
            //console.log(data);            
            if( $.trim(data)==='SUCCESS'){
                $('#TrapLebel').show('Highlight');
                $('#TrapLebel').show().delay(4000).fadeOut();
            }
       }    
    });
}

function sendCCMSMessageToDB(strIPAddress, strOID, strTrap){
    $.ajax({
       type: 'POST',
       data: {
          strIPAddress: strIPAddress,
          strOID: strOID,
          strTrap: strTrap
       },                   
       async: false,
       url: "/" + strRoot + "/api/WebServicesGeneric/sendTrapToDB",
       error: function(data) { alert("Error in 'WebServicesGeneric/sendTrapToDB'");},
       success: function(data) {
            //console.log(data);            
            if( $.trim(data)==='SUCCESS'){
                $('#TrapLebel').show('Highlight');
                $('#TrapLebel').show().delay(4000).fadeOut();
            }
       }    
    });
}
*/
