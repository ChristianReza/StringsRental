package datamodels.dto;

import datamodels.general.Person;

public class ParentGuardianDTO extends Person {
	
	private Integer id;

	private String cc;
	
	private String phoneNumber;
	
	private String address;
	
	private String email;
	
	public ParentGuardianDTO(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public ParentGuardianDTO(Integer id, String firstName, String lastName, String cc, String phoneNumber, String address,
			String email) {
		super(firstName, lastName);
		this.id = id;
		this.cc = cc;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}
	
	public ParentGuardianDTO(String firstName, String lastName, String cc, String phoneNumber, String address,
			String email) {
		super(firstName, lastName);
		this.cc = cc;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cc == null) ? 0 : cc.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParentGuardianDTO other = (ParentGuardianDTO) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cc == null) {
			if (other.cc != null)
				return false;
		} else if (!cc.equals(other.cc))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
}
