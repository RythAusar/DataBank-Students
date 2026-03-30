package databank.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.faces.view.ViewScoped;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.Version;


@ViewScoped
@Entity(name = "StudentPojo")
@EntityListeners(StudentPojoListener.class)
@Table(name = "student", catalog = "databank", schema = "databank")
@Access(AccessType.FIELD)
@NamedQuery(name = StudentPojo.STUDENT_FIND_ALL, query = "SELECT s FROM StudentPojo s")
@NamedQuery(name = StudentPojo.STUDENT_FIND_ID, query = "SELECT s FROM StudentPojo s WHERE s.id = :id")
public class StudentPojo implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String STUDENT_FIND_ALL = "Student.findAll";
	public static final String STUDENT_FIND_ID = "Student.findById";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	protected int id;


	@Column(name = "last_name")
	protected String lastName;
	
	
	@Column(name = "first_name")
	protected String firstName;

	
	@Column(name = "email")
	protected String email;

	
	@Column(name = "phone")
	protected String phoneNumber;

	
	@Column(name = "created")
	protected LocalDateTime created;

	@Column(name = "updated")
	protected LocalDateTime updated;
	
	@Column(name = "program")
	protected String program;

	@Version
	@Column(name = "version")
	protected int version = 1;

	@Transient
	protected boolean editable;

	public StudentPojo() {
		super();
	}
	
	public boolean getEditable() {
		return editable;
	}
	
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public int getId() {
		return id;
	}
	
	public String getProgram() {
		return program;
	}
	
	/**
	 * @param id new value for id
	 */
	public void setId(int id) {
		this.id = id;
	}

	
	public void setProgram(String program)
	{
		this.program = program;
	}
	
	
	/**
	 * @return the value for lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName new value for lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the value for firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName new value for firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getCreated() {
		return created;
	}
	
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}
	
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		
		return prime * result + Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		
		if (obj instanceof StudentPojo otherStudentPojo) {
			// See comment (above) in hashCode():  compare using only member variables that are
			// truly part of an object's identity.
			return Objects.equals(this.getId(), otherStudentPojo.getId());
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id = ").append(getId());
		if (getLastName() != null) {
			builder.append(", ").append("lastName = ").append(getLastName());
		}
		if (getFirstName() != null) {
			builder.append(", ").append("firstName = ").append(getFirstName());
		}
		if (getPhoneNumber() != null) {
			builder.append(", ").append("phoneNumber = ").append(getPhoneNumber());
		}
		if(getProgram() != null) {
			builder.append(", ").append("program = ").append(getProgram());
		}
		if (getEmail() != null) {
			builder.append(", ").append("email = ").append(getEmail());
		}
		if (getCreated() != null) {
			builder.append(", ").append("created = ").append(getCreated());
		}
		if (getUpdated() != null) {
			builder.append(", ").append("updated = ").append(getUpdated());
		}
		builder.append("]");
		return builder.toString();
	}

}
