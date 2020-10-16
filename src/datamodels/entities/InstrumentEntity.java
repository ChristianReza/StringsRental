package datamodels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import datamodels.dto.InstrumentDTO;
import datamodels.enums.InstrumentType;
import datamodels.enums.Size;

@Entity
@Table(name = "INSTMNT")
public class InstrumentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID") // specify the column name. Without it, it will use method name
	private Integer id;
	
	@Column(name = "SERIAL_NUM")
	private String serialNumber;
	
	// https://www.baeldung.com/jpa-persisting-enums-in-jpa
    @Enumerated(EnumType.ORDINAL)
	@Column(name = "INST_TYPE")
	private InstrumentType instrumentType;
	
    @Enumerated(EnumType.ORDINAL)
	@Column(name = "SIZE")
	private Size size;
	
	@Column(name = "STUDENT")
	private StudentEntity student;

	public InstrumentEntity(Integer id, String serialNumber, InstrumentType instrumentType, Size size, StudentEntity student) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.instrumentType = instrumentType;
		this.size = size;
		this.student = student;
	}
	
	public InstrumentEntity(String serialNumber, InstrumentType instrumentType, Size size, StudentEntity student) {
		super();
		this.serialNumber = serialNumber;
		this.instrumentType = instrumentType;
		this.size = size;
		this.student = student;
	}
	

	public InstrumentEntity(InstrumentDTO instrument) {
		super();
		this.serialNumber = instrument.getSerialNumber();
		this.instrumentType = instrument.getInstrumentType();
		this.size = instrument.getSize();
		this.student = new StudentEntity(instrument.getStudent());
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

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
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
		InstrumentEntity other = (InstrumentEntity) obj;
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
