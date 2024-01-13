package com.Ligado.nbiot_iffe_inventory.Entity;

public class SciloDataEntity {

	private String force_ytype;
	private String force_yid;
	private String force_yname;
	private String message;
	private String value;
	private String threshold;
	private String message_time;
	private String aligned_resource;


	public SciloDataEntity() {

	}
	
	
	//	force_ytype:'0',
	//	force_yid:'0',
	//	force_yname:'',
	//	message:'Hello World 1',
	//	value:'',
	//	threshold:'',
	//	message_time:'0',
	//	aligned_resource:'/api/device/1689'
	
	public SciloDataEntity(String message, String aligned_resource ) {
		this.force_ytype = "0";
		this.force_yid = "0";
		this.force_yname = "";
		this.message = message;
		this.value = "";
		this.threshold = "";
		this.message_time = "";
		this.aligned_resource = aligned_resource;
	}
	
	
	
	public String getForce_ytype() {
		return force_ytype;
	}
	public void setForce_ytype(String force_ytype) {
		this.force_ytype = force_ytype;
	}
	public String getForce_yid() {
		return force_yid;
	}
	public void setForce_yid(String force_yid) {
		this.force_yid = force_yid;
	}
	public String getForce_yname() {
		return force_yname;
	}
	public void setForce_yname(String force_yname) {
		this.force_yname = force_yname;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getThreshold() {
		return threshold;
	}
	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}
	public String getMessage_time() {
		return message_time;
	}
	public void setMessage_time(String message_time) {
		this.message_time = message_time;
	}
	public String getAligned_resource() {
		return aligned_resource;
	}
	public void setAligned_resource(String aligned_resource) {
		this.aligned_resource = aligned_resource;
	}


}
