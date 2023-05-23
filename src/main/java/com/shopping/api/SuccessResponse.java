package com.shopping.api;

public class SuccessResponse {
	
	Boolean isSuccess;
	
	
	public SuccessResponse(boolean isSusscess) {
		this.isSuccess=Boolean.valueOf(isSusscess);
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

}
