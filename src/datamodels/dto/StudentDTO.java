package datamodels.dto;

import datamodels.enums.InstrumentType;
import datamodels.enums.Schools;
import datamodels.enums.Size;

public class StudentDTO {

	private String firstName;

	private String lastName;

	private Schools schoolName;

	private String schoolPhone;

	private String schoolAddress;

	private String instrumentSerialNumber;

	private InstrumentType instrumentType;

	private Size instrumentSize;
	
	private String parentGuardianFirstName;
	
	private String parentGuardianLastName;

	private String parentGuardianCC;

	private String parentGuardianPhone;

	private String parentGuardianAddress;

	private String parentGuardianEmail;

	private int gradeLevel;

	public StudentDTO(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public StudentDTO(String firstName, String lastName, Schools schoolName, String schoolPhone, String schoolAddress,
			String instrumentSerialNumber, InstrumentType instrumentType, Size instrumentSize,
			String parentGuardianFirstName, String parentGuardianLastName, String parentGuardianCC,
			String parentGuardianPhone, String parentGuardianAddress, String parentGuardianEmail, int gradeLevel) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.schoolName = schoolName;
		this.schoolPhone = schoolPhone;
		this.schoolAddress = schoolAddress;
		this.instrumentSerialNumber = instrumentSerialNumber;
		this.instrumentType = instrumentType;
		this.instrumentSize = instrumentSize;
		this.parentGuardianFirstName = parentGuardianFirstName;
		this.parentGuardianLastName = parentGuardianLastName;
		this.parentGuardianCC = parentGuardianCC;
		this.parentGuardianPhone = parentGuardianPhone;
		this.parentGuardianAddress = parentGuardianAddress;
		this.parentGuardianEmail = parentGuardianEmail;
		this.gradeLevel = gradeLevel;
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

	public String getParentGuardianFirstName() {
		return parentGuardianFirstName;
	}


	public void setParentGuardianFirstName(String parentGuardianFirstName) {
		this.parentGuardianFirstName = parentGuardianFirstName;
	}


	public void setInstrumentSize(Size instrumentSize) {
		this.instrumentSize = instrumentSize;
	}

	public String getParentGuardianLastName() {
		return parentGuardianLastName;
	}

	public void setParentGuardianLastName(String parentGuardianLastName) {
		this.parentGuardianLastName = parentGuardianLastName;
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

}
