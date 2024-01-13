package com.Ligado.nbiot_iffe_inventory.Entity;

import java.util.List;

public class FiberStatusResponse {
	
	private String status;
    private List<FiberStatus> data;

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<FiberStatus> getData() {
		return data;
	}

	public void setData(List<FiberStatus> data) {
		this.data = data;
	}


	
	
	public FiberStatusResponse(String status, List<FiberStatus> data) {
        this.status = status;
        this.data = data;
    }

   
}
