package com.revature.models;

public class Request {
	
	private String type;
	private String status;
	private double amount;
	private long Request_ID;
	private long Account_ID;
	
	public Request() {}

	public Request(String type, String status, double amount, long request_ID, long account_ID) {
		super();
		this.type = type;
		this.status = status;
		this.amount = amount;
		Request_ID = request_ID;
		Account_ID = account_ID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getRequest_ID() {
		return Request_ID;
	}

	public void setRequest_ID(long request_ID) {
		Request_ID = request_ID;
	}

	public long getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(long account_ID) {
		Account_ID = account_ID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Account_ID ^ (Account_ID >>> 32));
		result = prime * result + (int) (Request_ID ^ (Request_ID >>> 32));
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (Account_ID != other.Account_ID)
			return false;
		if (Request_ID != other.Request_ID)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [type=" + type + ", status=" + status + ", amount=" + amount + ", Request_ID=" + Request_ID
				+ ", Account_ID=" + Account_ID + "]";
	}
	
	
	

}
