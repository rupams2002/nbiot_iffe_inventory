package com.Ligado.nbiot_iffe_inventory.Entity;

public class FiberStatus {
	
	private int fiber_id;
    private String fwd_link_op_status;
    private String fwd_link_status;
    private String lhcp_link_op_status;
    private String lhcp_link_status;
    private String rhcp_link_op_status;
    private String rhcp_link_status;
    
    
	public FiberStatus(int fiber_id, String fwd_link_op_status, String fwd_link_status, String lhcp_link_op_status,
			String lhcp_link_status, String rhcp_link_op_status, String rhcp_link_status) {
		super();
		this.fiber_id = fiber_id;
		this.fwd_link_op_status = fwd_link_op_status;
		this.fwd_link_status = fwd_link_status;
		this.lhcp_link_op_status = lhcp_link_op_status;
		this.lhcp_link_status = lhcp_link_status;
		this.rhcp_link_op_status = rhcp_link_op_status;
		this.rhcp_link_status = rhcp_link_status;
	}

	
	public int getFiber_id() {
		return fiber_id;
	}
	public void setFiber_id(int fiber_id) {
		this.fiber_id = fiber_id;
	}
	public String getFwd_link_op_status() {
		return fwd_link_op_status;
	}
	public void setFwd_link_op_status(String fwd_link_op_status) {
		this.fwd_link_op_status = fwd_link_op_status;
	}
	public String getFwd_link_status() {
		return fwd_link_status;
	}
	public void setFwd_link_status(String fwd_link_status) {
		this.fwd_link_status = fwd_link_status;
	}
	public String getLhcp_link_op_status() {
		return lhcp_link_op_status;
	}
	public void setLhcp_link_op_status(String lhcp_link_op_status) {
		this.lhcp_link_op_status = lhcp_link_op_status;
	}
	public String getLhcp_link_status() {
		return lhcp_link_status;
	}
	public void setLhcp_link_status(String lhcp_link_status) {
		this.lhcp_link_status = lhcp_link_status;
	}
	public String getRhcp_link_op_status() {
		return rhcp_link_op_status;
	}
	public void setRhcp_link_op_status(String rhcp_link_op_status) {
		this.rhcp_link_op_status = rhcp_link_op_status;
	}
	public String getRhcp_link_status() {
		return rhcp_link_status;
	}
	public void setRhcp_link_status(String rhcp_link_status) {
		this.rhcp_link_status = rhcp_link_status;
	}
    	
	
}
