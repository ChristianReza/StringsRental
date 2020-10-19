package datamodels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import datamodels.enums.InstrumentType;
import datamodels.enums.Schools;
import datamodels.enums.Size;

@Entity
@Table(name = "STUDENT")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID") // specify the column name. Without it, it will use method name
	private Integer id;

	@Column(name = "STUDENT_FIRST_NAME")
	private String firstName;

	@Column(name = "STUDENT_LAST_NAME")
	private String lastName;

	@Enumerated(EnumType.STRING)
	@Column(name = "SCHL_NAME")
	private Schools schoolName;

	@Column(name = "SCHL_PHONE")
	private String schoolPhone;

	@Column(name = "SCHL_ADDRESS")
	private String schoolAddress;

	@Column(name = "INSTMNT_SERIAL_NUM")
	private String instrumentSerialNumber;

	// https://www.baeldung.com/jpa-persisting-enums-in-jpa
	@Enumerated(EnumType.STRING)
	@Column(name = "INSTMNT_TYPE")
	private InstrumentType instrumentType;

	@Enumerated(EnumType.STRING)
	@Column(name = "INSTMNT_SIZE")
	private Size instrumentSize;

	@Column(name = "PARNT_GUARD_CC")
	private String parentGuardianCC;

	@Column(name = "PARNT_GUARD_PHONE")
	private String parentGuardianPhone;

	@Column(name = "PARNT_GUARD_ADDRESS")
	private String parentGuardianAddress;

	@Column(name = "PARNT_GUARD_EMAIL")
	private String parentGuardianEmail;

	@Column(name = "GRADE_LVL")
	private int gradeLevel;

	public StudentEntity() {
		// Default Constructor
	}

	public StudentEntity(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public StudentEntity(String firstName, String lastName, Integer id, Schools schoolName, String schoolPhone,
			String schoolAddress, String instrumentSerialNumber, InstrumentType instrumentType, Size instrumentSize,
			String parentGuardianCC, String parentGuardianPhone, String parentGuardianAddress,
			String parentGuardianEmail, int gradeLevel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.schoolName = schoolName;
		this.schoolPhone = schoolPhone;
		this.schoolAddress = schoolAddress;
		this.instrumentSerialNumber = instrumentSerialNumber;
		this.instrumentType = instrumentType;
		this.instrumentSize = instrumentSize;
		this.parentGuardianCC = parentGuardianCC;
		this.parentGuardianPhone = parentGuardianPhone;
		this.parentGuardianAddress = parentGuardianAddress;
		this.parentGuardianEmail = parentGuardianEmail;
		this.gradeLevel = gradeLevel;
	}

	public StudentEntity(String firstName, String lastName, Schools schoolName, String schoolPhone,
			String schoolAddress, String instrumentSerialNumber, InstrumentType instrumentType, Size instrumentSize,
			String parentGuardianCC, String parentGuardianPhone, String parentGuardianAddress,
			String parentGuardianEmail, int gradeLevel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolName = schoolName;
		this.schoolPhone = schoolPhone;
		this.schoolAddress = schoolAddress;
		this.instrumentSerialNumber = instrumentSerialNumber;
		this.instrumentType = instrumentType;
		this.instrumentSize = instrumentSize;
		this.parentGuardianCC = parentGuardianCC;
		this.parentGuardianPhone = parentGuardianPhone;
		this.parentGuardianAddress = parentGuardianAddress;
		this.parentGuardianEmail = parentGuardianEmail;
		this.gradeLevel = gradeLevel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Schools getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(Schools schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolPhone() {
		return schoolPhone;
	}

	public void setSchoolPhone(String schoolPhone) {
		this.schoolPhone = schoolPhone;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getInstrumentSerialNumber() {
		return instrumentSerialNumber;
	}

	public void setInstrumentSerialNumber(String instrumentSerialNumber) {
		this.instrumentSerialNumber = instrumentSerialNumber;
	}

	public InstrumentType getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	public Size getInstrumentSize() {
		return instrumentSize;
	}

	public void setInstrumentSize(Size instrumentSize) {
		this.instrumentSize = instrumentSize;
	}

	public String getParentGuardianCC() {
		return parentGuardianCC;
	}

	public void setParentGuardianCC(String parentGuardianCC) {
		this.parentGuardianCC = parentGuardianCC;
	}

	public String getParentGuardianPhone() {
		return parentGuardianPhone;
	}

	public void setParentGuardianPhone(String parentGuardianPhone) {
		this.parentGuardianPhone = parentGuardianPhone;
	}

	public String getParentGuardianAddress() {
		return parentGuardianAddress;
	}

	public void setParentGuardianAddress(String parentGuardianAddress) {
		this.parentGuardianAddress = parentGuardianAddress;
	}

	public String getParentGuardianEmail() {
		return parentGuardianEmail;
	}

	public void setParentGuardianEmail(String parentGuardianEmail) {
		this.parentGuardianEmail = parentGuardianEmail;
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", " + "First Name=" + firstName + ", Last Name=" + lastName + ", Grade Level="
				+ gradeLevel + ", School Name=" + schoolName + ", School Phone=" + schoolPhone + ", School Address="
				+ schoolAddress + ", Instrument Serial Number=" + instrumentSerialNumber + ", Instrument Type="
				+ instrumentType + ", Instrument Size=" + instrumentSize + ", Parent Guardian CC=" + parentGuardianCC
				+ ", Parent Guardian Phone=" + parentGuardianPhone + ", Parent Guardian Address="
				+ parentGuardianAddress + ", Parent Guardian Email=" + parentGuardianEmail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + gradeLevel;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instrumentSerialNumber == null) ? 0 : instrumentSerialNumber.hashCode());
		result = prime * result + ((instrumentSize == null) ? 0 : instrumentSize.hashCode());
		result = prime * result + ((instrumentType == null) ? 0 : instrumentType.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((parentGuardianAddress == null) ? 0 : parentGuardianAddress.hashCode());
		result = prime * result + ((parentGuardianCC == null) ? 0 : parentGuardianCC.hashCode());
		result = prime * result + ((parentGuardianEmail == null) ? 0 : parentGuardianEmail.hashCode());
		result = prime * result + ((parentGuardianPhone == null) ? 0 : parentGuardianPhone.hashCode());
		result = prime * result + ((schoolAddress == null) ? 0 : schoolAddress.hashCode());
		result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result + ((schoolPhone == null) ? 0 : schoolPhone.hashCode());
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
		StudentEntity other = (StudentEntity) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gradeLevel != other.gradeLevel)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instrumentSerialNumber == null) {
			if (other.instrumentSerialNumber != null)
				return false;
		} else if (!instrumentSerialNumber.equals(other.instrumentSerialNumber))
			return false;
		if (instrumentSize != other.instrumentSize)
			return false;
		if (instrumentType != other.instrumentType)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (parentGuardianAddress == null) {
			if (other.parentGuardianAddress != null)
				return false;
		} else if (!parentGuardianAddress.equals(other.parentGuardianAddress))
			return false;
		if (parentGuardianCC == null) {
			if (other.parentGuardianCC != null)
				return false;
		} else if (!parentGuardianCC.equals(other.parentGuardianCC))
			return false;
		if (parentGuardianEmail == null) {
			if (other.parentGuardianEmail != null)
				return false;
		} else if (!parentGuardianEmail.equals(other.parentGuardianEmail))
			return false;
		if (parentGuardianPhone == null) {
			if (other.parentGuardianPhone != null)
				return false;
		} else if (!parentGuardianPhone.equals(other.parentGuardianPhone))
			return false;
		if (schoolAddress == null) {
			if (other.schoolAddress != null)
				return false;
		} else if (!schoolAddress.equals(other.schoolAddress))
			return false;
		if (schoolName == null) {
			if (other.schoolName != null)
				return false;
		} else if (!schoolName.equals(other.schoolName))
			return false;
		if (schoolPhone == null) {
			if (other.schoolPhone != null)
				return false;
		} else if (!schoolPhone.equals(other.schoolPhone))
			return false;
		return true;
	}

}
