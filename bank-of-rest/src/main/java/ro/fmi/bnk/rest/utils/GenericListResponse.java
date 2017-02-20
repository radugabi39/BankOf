package ro.fmi.bnk.rest.utils;

import java.util.List;

public class GenericListResponse<T> {

	private String status;
	private String message;
	private List<T> data;

	public GenericListResponse() {
		super();
	}

	public GenericListResponse(String status, String message, List<T> data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}