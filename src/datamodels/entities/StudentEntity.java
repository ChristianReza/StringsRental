package datamodels.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import datamodels.general.Person;

@Entity
@Table(name = "STUDENT")
public class StudentEntity extends Person {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID") // specify the column name. Without it, it will use method name
	private Integer id;
	
	@Column(name = "SCHL_DIST")
	private SchoolEntity schoolDistrict;
	
	@Column(name = "INST")
	private InstrumentEntity instrument;
	
	@Column(name = "PARENT_GUARD")
	private ParentGuardianEntity parentGuardian;
	
	@Column(name = "GRADE_LVL")
	private int gradeLevel;

	public StudentEntity(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public StudentEntity(String firstName, String lastName, Integer id, SchoolEntity schoolDistrict, InstrumentEntity instrument,
			ParentGuardianEntity parentGuardian, int gradeLevel) {
		super(firstName, lastName);
		this.id = id;
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

	public SchoolEntity getSchoolDistrict() {
		return schoolDistrict;
	}

	public void setSchoolDistrict(SchoolEntity schoolDistrict) {
		this.schoolDistrict = schoolDistrict;
	}

	public InstrumentEntity getInstrument() {
		return instrument;
	}

	public void setInstrument(InstrumentEntity instrument) {
		this.instrument = instrument;
	}

	public ParentGuardianEntity getParentGuardian() {
		return parentGuardian;
	}

	public void setParentGuardian(ParentGuardianEntity parentGuardian) {
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
		StudentEntity other = (StudentEntity) obj;
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
