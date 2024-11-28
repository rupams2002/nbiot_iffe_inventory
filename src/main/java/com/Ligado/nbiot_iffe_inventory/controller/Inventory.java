package com.Ligado.nbiot_iffe_inventory.controller;

import java.sql.SQLException;

import com.Ligado.nbiot_iffe_inventory.Entity.FiberStatusResponse;

public class Inventory {

	
	public String getHtmlInventory() throws SQLException {
		
		Services service = new Services();
		FiberStatusResponse inventory = service.getNbiot_IFFE_All_Inventory();
		
		
		String myvar = "<html>"+
		"    <head>"+
		"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"+
		"        <title>IFFE Inventory</title>"+
		"		 <link rel=\"icon\" href=\"data:;base64,iVBORw0KGgo=\">"+
		"		 <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">"+
		"		 <script src='https://code.jquery.com/jquery-3.7.1.min.js' integrity='sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=' crossorigin='anonymous'></script>"+
		"        <script src=\"../../JQuery/inventory.js\" type=\"text/javascript\"></script>"+
		"    </head>"+
		"    "+
		"    <body>"+
		"        <table border='0' style=\"width:100%\">"+
		"             <tr> "+
		"                 <td align='center'><h1>Northbound NBIOT IFFE Inventory</h1></td>"+
		"             </tr>             "+
		"             <tr> "+		
		"                 <td align='left'>" +
		"						<div class='input-group mb-3'>" +
		"  							<div class='input-group-prepend'>" +
		"    							<span class='input-group-text' id='inputGroup-sizing-default'>ScienceLogic Environment</span>" +
		" 							</div>" +
		" 							<input type='text' value='https://ressiloaiodev.msvlp.com' id='scilo_env_ip' aria-label='Default' aria-describedby='inputGroup-sizing-default' style='width:300px;'>" +
		"						</div>" +		
		"						<div class='input-group mb-3'>" +
		"  							<div class='input-group-prepend'>" +
		"    							<span class='input-group-text' id='inputGroup-sizing-default'>Device ID (DID)</span>" +
		" 							</div>" +
		" 							<input type='text' value='1689' id='did' aria-label='Default' aria-describedby='inputGroup-sizing-default' style='width:60px;'>" +
		"						</div>" +		
		"				  </td>"+
		"             </tr>             "+
		"             <tr> "+
		"                 <td valign='top' align='center'>"+
		"                    <table border='1'>"+
		"                        <tr bgcolor='#ffff66'> "+
		"                            <td width=\"5%\" align='center'><b>fiber_id</b></td>"+
		"                            <td width=\"5%\" align='center'><b>fwd_link_op_status</b></td>"+
		"                            <td width=\"5%\" align='center'><b>fwd_link_status</b></td>"+
		"                            <td width=\"5%\" align='center'><b>lhcp_link_op_status</b></td>"+
		"                            <td width=\"5%\" align='center'><b>lhcp_link_status</b></td>"+
		"                            <td width=\"5%\" align='center'><b>rhcp_link_op_status</b></td>  "+
		"                            <td width=\"5%\" align='center'><b>rhcp_link_status</b></td>  "+
		"                            <td width=\"5%\" align='center'><b>Action</b></td>  "+
		"                        </tr>";
		                        
						for(int i=0; i<inventory.getData().size(); i++) {
							myvar +=
		                        "<tr> "+
		                            "<td class=\"nr\" width=\"5%\" align='center'>"+ inventory.getData().get(i).getFiber_id()  + "</td>"+
		                            "<td width=\"5%\" align='center'>"+ inventory.getData().get(i).getFwd_link_op_status()  + "</td>"+
		                            "<td width=\"5%\" align='center'>"+ inventory.getData().get(i).getFwd_link_status()  + "</td>"+
		                            "<td width=\"5%\" align='center'>"+ inventory.getData().get(i).getLhcp_link_op_status()  + "</td>"+
		                            "<td width=\"5%\" align='center'>"+ inventory.getData().get(i).getLhcp_link_status()  + "</td>"+
		                            "<td width=\"5%\" align='center'>"+ inventory.getData().get(i).getRhcp_link_op_status()  + "</td>"+
		                            "<td width=\"5%\" align='center'>"+ inventory.getData().get(i).getRhcp_link_status() + "</td>"+
		                            "<td width=\"5%\" align='center'><button id=\"action\" type=\"button\" class=\"btn btn-success\" onCLick=\"APICallToSciLo('" + inventory.getData().get(i).getFiber_id()  + "')\">API Call to Scilo</button></td>"+
		                        "</tr>";
						}
						  myvar += 
		"                    </table>    "+
		"                 </td>"+
		"             </tr>             "+
		"             "+
		"             <tr> "+
		"                 <td style=\"height: 50px\" colspan=\"3\" align='center'>"+
		"                     <input type='submit' class='back' value='Back To Main Page' />"+
		"                 </td>   "+
		"             </tr>             "+
		"             "+
		"             "+
		"             <tr style=\"height: 120px\"> "+
		"                 <td colspan=\"3\" align='center'>"+
		"                     <font size=\"3\" face=\"verdana\" color=\"green\" style=\"font-weight: bold;\"><label hidden=true id=\"TrapLebel\">Phone number has been updated</label></font>"+
		"                 </td>   "+
		"             </tr>             "+
		"             "+
		"        </table>"+
		"    </body>"+
		"    "+
		"</html>";
	

			
		
		return myvar;
	}
	
	
	
}
