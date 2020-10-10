package entities;

public class Student extends Person {
	
	private School schoolDistrict;
	
	private Instrument instrument;
	
	private ParentGuardian parentGuardian;

	public Student(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	public Student(String firstName, String lastName, School schoolDistrict, Instrument instrument, ParentGuardian parentGuardian) {
		super(firstName, lastName);
		this.schoolDistrict = schoolDistrict;
		this.instrument = instrument;
		this.parentGuardian = parentGuardian;
	}


	public School getSchoolDistrict() {
		return schoolDistrict;
	}

	public void setSchoolDistrict(School schoolDistrict) {
		this.schoolDistrict = schoolDistrict;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public ParentGuardian getParentGuardian() {
		return parentGuardian;
	}

	public void setParentGuardian(ParentGuardian parentGuardian) {
		this.parentGuardian = parentGuardian;
	}
	

}
