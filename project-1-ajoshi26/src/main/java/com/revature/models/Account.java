package com.revature.models;

public class Account {
	
	private long Account_ID;
	private String username;
	private String password;
	private String role;
	
	public Account(){}

	public Account(long account_ID, String username, String password, String role) {
		super();
		Account_ID = account_ID;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public long getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(long account_ID) {
		Account_ID = account_ID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (Account_ID ^ (Account_ID >>> 32));
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Account other = (Account) obj;
		if (Account_ID != other.Account_ID)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [Account_ID=" + Account_ID + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}
	
	

}
