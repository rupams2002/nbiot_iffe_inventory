package com.Ligado.nbiot_iffe_inventory.controller;

import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Ligado.nbiot_iffe_inventory.Entity.Authentication;
import com.Ligado.nbiot_iffe_inventory.Entity.FiberStatusResponse;
import com.Ligado.nbiot_iffe_inventory.Entity.SciloDataEntity;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping("/cms-service/webapi")
public class LigadoController {

	@GetMapping(value = "/HelloWorld")
    public String HelloWorld() throws Exception{
		return "<h1>Test Application</h1><h2>Port : 10006</h2><h3>Application is running successfully on port 10006</h3><h4>Version 1.0.3</h4>";
	}
	
	
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response Login(@RequestBody Authentication auth) throws Exception{
		//String strAuth = auth.getUsername() + auth.getPassword();
		
		if(auth.getUsername().equals("admin") && auth.getPassword().equals("Ph03nix5parr0w!).")) {
			return Response.ok().build();
		}else{
			return Response.status(403) .build();
		}
	}


	
	@GetMapping(value = "/homepage")
    public String HomePage() throws Exception{

		Inventory html = new Inventory(); 
		html.getHtmlInventory();
		
		return html.getHtmlInventory();
	}
	
	
//	@GetMapping(value = "/apiservice/nbiot/v1/nbiot_iffe_inventory", produces = MediaType.APPLICATION_JSON_VALUE )
//    public FiberStatusResponse getNbiot_IFFE_Inventory() throws SQLException{
//		
//		Services service = new Services();
//		FiberStatusResponse inventory = service.getNbiot_IFFE_All_Inventory();
//		
//        return inventory;			  
//	}	
	
	@GetMapping(value = "/apiservice/nbiot/v1/nbiot_iffe_inventory", produces = MediaType.APPLICATION_JSON_VALUE )
    public String getNbiot_IFFE_Inventory2() throws SQLException, Exception{
		
		Services service = new Services();
		FiberStatusResponse inventory = service.getNbiot_IFFE_All_Inventory();

		ObjectMapper objectMapper = new ObjectMapper();	
		String jsonInventory = objectMapper.writeValueAsString(inventory);
		
		
		// Read JSON string and convert it to JsonNode
        JsonNode jsonNode = objectMapper.readTree(jsonInventory);

        // Enable pretty printing
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        // Convert JsonNode back to formatted JSON string
        String prettyJsonString = objectMapper.writeValueAsString(jsonNode);

        return prettyJsonString;			  
	}	
		
	
	
	
	@GetMapping(value = "/sendAlerttoScilo")
    public SciloDataEntity sendAlerttoScilo( @RequestParam(name = "strSciLoIPAddress") String strSciLoIPAddress, @RequestParam(name = "strDID") String strDID, @RequestParam(name = "fiberID") int fiberID) throws Exception{

		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
		headers.setAccessControlAllowOrigin("*");
		headers.setBasicAuth("bW9oYW1tZWRAbGlnYWRvLmNvbTpSdXBhbSoqMTIz");
		
		Services service = new Services();
		FiberStatusResponse inventory = service.getNbiot_IFFE_Single_Inventory(fiberID);
		
		ObjectMapper objectMapper = new ObjectMapper();	
		String jsonInventory = objectMapper.writeValueAsString(inventory);

		//URI uri = new URI("https://10.1.3.115/api/alert");
		//URI uri = new URI("https://ressiloaiodev.msvlp.com/api/alert");
		URI uri = new URI(strSciLoIPAddress + "/api/alert");
		SciloDataEntity sciloData = new SciloDataEntity(jsonInventory, "/api/device/" + strDID);
		
		HttpEntity<SciloDataEntity> httpEntity = new HttpEntity(sciloData, headers);
	    
	    RestTemplate restTemplate = new RestTemplate();
	    //String response = restTemplate.getForObject(uri, String.class, params);
	    SciloDataEntity response = restTemplate.postForObject(uri, httpEntity, SciloDataEntity.class);
	    
		System.out.println("DONE");
		
		return response;
	}
	
	
/*	
	@GetMapping(value = "/apiservice/nbiot/v1/nbiot_iffe_inventory", produces = MediaType.APPLICATION_JSON_VALUE )
    public Response getNbiot_IFFE_Inventory() throws Exception{
		
		Random random = new Random();
		int fiber_id = random.nextInt(10);
		
		// Generate a random number (0 or 1)
        int fwd_link_randomIndex = random.nextInt(2);
        // Use the random number to select "UP" or "DOWN"
        String fwd_link_op_status_result = (fwd_link_randomIndex == 1) ? "UP" : "DOWN";		
		String fwd_link_status_result = (fwd_link_op_status_result == "UP") ? "ACTIVE" : "STANDBY";


		// Generate a random number (0 or 1)
        int lhcp_link_randomIndex = random.nextInt(2);
        // Use the random number to select "UP" or "DOWN"
        String lhcp_link_op_status_result = (lhcp_link_randomIndex == 1) ? "UP" : "DOWN";		
		String lhcp_link_status_result = (lhcp_link_op_status_result == "UP") ? "ACTIVE" : "STANDBY";

		
		// Generate a random number (0 or 1)
        int rhcp_link_randomIndex = random.nextInt(2);
        // Use the random number to select "UP" or "DOWN"
        String rhcp_link_op_status_result = (rhcp_link_randomIndex == 1) ? "UP" : "DOWN";		
		String rhcp_link_status_result = (lhcp_link_op_status_result == "UP") ? "ACTIVE" : "STANDBY";
		
		
		String strJSON = "{" +
	    	    "status" + ":" + "OperationSucceeded" + "," +
	    	    "data" + ":" + "[" +

	    	    		"{" + 
							"fiber_id" + ":" + fiber_id + "," +
							"fwd_link_op_status" + ":" + fwd_link_op_status_result + "," +     
							"fwd_link_status" + ":" + fwd_link_status_result + "," +
							"lhcp_link_op_status" + ":" + lhcp_link_op_status_result + "," +
							"lhcp_link_status" + ":" + lhcp_link_status_result + "," +
							"rhcp_link_op_status" + ":" + rhcp_link_op_status_result + "," +
							"rhcp_link_status" + ":" + rhcp_link_status_result +
						"}" +
							
						
					"]" +
	    	"}";   	
	
		return Response.ok(strJSON.toString()).build();

	}   	
*/	


	

	
	
	//****** In case of all 3 links switch ******** 
	
	@PostMapping(value = "/apiservice/nbiot/v1/update_nbiot_enodeb_iffe_fwd_lhcp_rhcp_mapping", produces = MediaType.APPLICATION_JSON_VALUE )
    public Response update_nbiot_enodeb_iffe_fwd_lhcp_rhcp_mapping_V1(@RequestBody String object) throws SQLException, JsonParseException, IOException{
		System.out.println(object);
		
		Integer old_fiber_id = null;
		Integer new_fiber_id = null;
		
		JsonFactory factory = new JsonFactory();
		JsonParser  parser  = factory.createParser(object);		
		
		while(!parser.isClosed()){
		    JsonToken jsonToken = parser.nextToken();

		    if(JsonToken.FIELD_NAME.equals(jsonToken)){
		        String fieldName = parser.getCurrentName();
		        System.out.println(fieldName);

		        jsonToken = parser.nextToken();
	            System.out.println(parser.getValueAsString());	

		        if("old_fiber_id".equals(fieldName)){
		        	old_fiber_id = parser.getValueAsInt();
		        } else if ("new_fiber_id".equals(fieldName)){
		        	new_fiber_id = parser.getValueAsInt();
		        }
		    }
		}
		
		String jdbcURL = "jdbc:h2:mem:testdb"; 
		Connection connection = DriverManager.getConnection(jdbcURL, "sa", "password");
		//System.out.println("Connected to H2 in-memory database.");	

		
		//String sql = "UPDATE nbiot_iffe_inventory SET fwd_link_op_status='UP', fwd_link_status='ACTIVE', lhcp_link_op_status='UP', lhcp_link_status='ACTIVE', rhcp_link_op_status='UP', rhcp_link_status='ACTIVE' WHERE fiber_id = ";
		String sql = "INSERT INTO nbiot_iffe_inventory (fiber_id, fwd_link_op_status, fwd_link_status, lhcp_link_op_status, lhcp_link_status, rhcp_link_op_status, rhcp_link_status) VALUES (" + new_fiber_id + ", 'DOWN', 'STANDBY', 'UP', 'ACTIVE',  'DOWN', 'STANDBY');";
		Statement statement = connection.createStatement();
		statement.execute(sql);
		
		sql = "DELETE FROM nbiot_iffe_inventory WHERE fiber_id = " + old_fiber_id + "";
		statement = connection.createStatement();
		statement.execute(sql);
		
		connection.close();
		
		return Response.ok(object).build();
		
	}	
	
	
	
}
