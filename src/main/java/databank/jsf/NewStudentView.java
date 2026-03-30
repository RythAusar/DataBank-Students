package databank.jsf;

import java.io.Serializable;
import java.time.LocalDateTime;

import databank.model.StudentPojo;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;


/**
 * This class represents the scope of adding a new student to the DB.
 * 
 * 
 * 
 */
@Named("newStudent")
@ViewScoped
public class NewStudentView implements Serializable {
	/** explicit set serialVersionUID */
	private static final long serialVersionUID = 1L;

	protected String lastName;
	protected String firstName;
	protected String email;
	protected String phoneNumber;
	protected String program;

	
	@Inject
	@ManagedProperty("#{studentController}")
	protected StudentController studentController;

	public NewStudentView() {
	}

	/**
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
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

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	

	/**
	 * @param lastName lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void addStudent() {
		if (allNotNullOrEmpty(firstName, lastName, email, phoneNumber, program)) /* TODO 11 - Don't forget to add the other variables that are not nullable */ {
			StudentPojo theNewStudent = new StudentPojo();
			theNewStudent.setFirstName(getFirstName());
			theNewStudent.setLastName(getLastName());
			theNewStudent.setPhoneNumber(getPhoneNumber());
			theNewStudent.setEmail(getEmail());
			theNewStudent.setProgram(getProgram());
			
			studentController.addNewStudent(theNewStudent);
			//Clean up
			studentController.toggleAdding();
			setFirstName(null);
			setLastName(null);
			setPhoneNumber(null);
			setEmail(null);
			setProgram(null);
			
		}
	}

	static boolean allNotNullOrEmpty(final Object... values) {
		if (values == null) {
			return false;
		}
		for (final Object val : values) {
			if (val == null) {
				return false;
			}
			if (val instanceof String) {
				String str = (String) val;
				if (str.isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
}
