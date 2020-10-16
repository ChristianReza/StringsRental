package datamodels.dto;

import datamodels.enums.InstrumentType;
import datamodels.enums.Size;

public class InstrumentDTO {
	
	private Integer id;
	
	private String serialNumber;
	
	private InstrumentType instrumentType;
	
	private Size size;
	
	private StudentDTO student;

	public InstrumentDTO(Integer id, String serialNumber, InstrumentType instrumentType, Size size, StudentDTO student) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.instrumentType = instrumentType;
		this.size = size;
		this.student = student;
	}
	
	public InstrumentDTO(String serialNumber, InstrumentType instrumentType, Size size, StudentDTO student) {
		super();
		this.serialNumber = serialNumber;
		this.instrumentType = instrumentType;
		this.size = size;
		this.student = student;
	}
	

	public InstrumentDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public InstrumentType getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instrumentType == null) ? 0 : instrumentType.hashCode());
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		InstrumentDTO other = (InstrumentDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instrumentType != other.instrumentType)
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (size != other.size)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

}
