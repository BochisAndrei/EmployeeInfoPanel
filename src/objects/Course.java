package objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	
	@Id @GeneratedValue
	@Column(name="id_course")
	private int idCourse;
	
	@ManyToOne
	@JoinColumn(name = "id_employee")
	private Employee employee;
	
	@Column(name="name")
	private String name;
	
	@Column(name="number_of_hours")
	private int numberOfHours;
	
	@Column(name="value")
	private int value;
	
	@Column(name="graduation_diploma")
	private String graduationDiploma;
	
	@Column(name="year")
	private int year;
	
	public Course() {}

	public Course(String name, int numberOfHours, int value, String graduationDiploma,
			int year, Employee employee) {
		this.name = name;
		this.numberOfHours = numberOfHours;
		this.value = value;
		this.graduationDiploma = graduationDiploma;
		this.year = year;
		this.employee = employee;
	}
	
	public int getIdCourse() {
		return idCourse;
	}
	
	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public int getEmployeeId() {
		return employee.getId();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfHours() {
		return numberOfHours;
	}
	public void setNumberOfHours(int numberOfHours) {
		this.numberOfHours = numberOfHours;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getGraduationDiploma() {
		return graduationDiploma;
	}
	public void setGraduationDiploma(String graduationDiploma) {
		this.graduationDiploma = graduationDiploma;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Course [idCourse=" + idCourse + ", idEmployee=" + ", name=" + name + ", numberOfHours="
				+ numberOfHours + ", value=" + value + ", graduationDiploma=" + graduationDiploma + ", year=" + year
				+ "]";
	}

}
