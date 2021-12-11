package objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="employees")
public class Employee {
	
	@Id @GeneratedValue
	@Column(name="id_employee")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="firm")
	private String firm;
	
	@Column(name="position")
	private String position;
	
	@Column(name="date_of_employement")
	private Date dateOfEmployement;
	
	@OneToMany(mappedBy = "employee")
	@Cascade(CascadeType.ALL)
	private Set<Course> courses;
	
	public Employee() {}
	public Employee(String name, String firm, String position, Date dateOfEmployement) {
		this.name = name;
		this.firm = firm;
		this.position = position;
		this.dateOfEmployement = dateOfEmployement;
	}

	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDateOfEmployement() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(dateOfEmployement).toString();
	}
	public void setDateOfEmployement(Date dateOfEmployement) {
		this.dateOfEmployement = dateOfEmployement;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", firm=" + firm + ", position=" + position
				+ ", dateOfEmployement=" + dateOfEmployement.toString() + "]";
	}
}
