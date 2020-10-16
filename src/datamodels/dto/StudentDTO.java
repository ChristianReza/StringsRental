package datamodels.dto;

import datamodels.general.Person;

public class StudentDTO extends Person {
	
	private Integer id;
	
	private SchoolDTO schoolDistrict;
	
	private InstrumentDTO instrument;
	
	private ParentGuardianDTO parentGuardian;
	
	private int gradeLevel;

	public StudentDTO(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public StudentDTO(String firstName, String lastName, Integer id, SchoolDTO schoolDistrict, InstrumentDTO instrument,
			ParentGuardianDTO parentGuardian, int gradeLevel) {
		super(firstName, lastName);
		this.id = id;
		this.schoolDistrict = schoolDistrict;
		this.instrument = instrument;
		this.parentGuardian = parentGuardian;
		this.gradeLevel = gradeLevel;
	}
	
	public StudentDTO(String firstName, String lastName, SchoolDTO schoolDistrict, InstrumentDTO instrument,
			ParentGuardianDTO parentGuardian, int gradeLevel) {
		super(firstName, lastName);
		this.schoolDistrict = schoolDistrict;
		this.instrument = instrument;
		this.parentGuardian = parentGuardian;
		this.gradeLevel = gradeLevel;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SchoolDTO getSchoolDistrict() {
		return schoolDistrict;
	}

	public void setSchoolDistrict(SchoolDTO schoolDistrict) {
		this.schoolDistrict = schoolDistrict;
	}

	public InstrumentDTO getInstrument() {
		return instrument;
	}

	public void setInstrument(InstrumentDTO instrument) {
		this.instrument = instrument;
	}

	public ParentGuardianDTO getParentGuardian() {
		return parentGuardian;
	}

	public void setParentGuardian(ParentGuardianDTO parentGuardian) {
		this.parentGuardian = parentGuardian;
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + gradeLevel;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((instrument == null) ? 0 : instrument.hashCode());
		result = prime * result + ((parentGuardian == null) ? 0 : parentGuardian.hashCode());
		result = prime * result + ((schoolDistrict == null) ? 0 : schoolDistrict.hashCode());
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
		StudentDTO other = (StudentDTO) obj;
		if (gradeLevel != other.gradeLevel)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (instrument == null) {
			if (other.instrument != null)
				return false;
		} else if (!instrument.equals(other.instrument))
			return false;
		if (parentGuardian == null) {
			if (other.parentGuardian != null)
				return false;
		} else if (!parentGuardian.equals(other.parentGuardian))
			return false;
		if (schoolDistrict == null) {
			if (other.schoolDistrict != null)
				return false;
		} else if (!schoolDistrict.equals(other.schoolDistrict))
			return false;
		return true;
	}

}
