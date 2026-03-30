/********************************************************************************************************
 * File:  EmailValidator.java Course Materials CST8277
 *
 * @author Teddy Yap
 * @author Shariar (Shawn) Emami
 * @author (original) Mike Norman
 */
package databank.jsf;

import java.util.regex.Pattern;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator<String> {

	// Really really (!) simple email pattern:  at-least-1-letter, '@', at-least-1-letter
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(.+)$");

	@Override
	public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {

		if (value == null) {
			FacesMessage msg = new FacesMessage("Email should not be empty", "Invalid email format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		if (!EMAIL_PATTERN.matcher(value).matches()) {
		    FacesMessage msg = new FacesMessage(
		        "Invalid email format",
		        "Email must contain '@' and valid text before and after it."
		    );
		    msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		    throw new ValidatorException(msg);
		}
		//TODO 07 - Complete the Matching using the EMAIL_PATTERN above.DONE!
		//You can use methods matcher and matches from EMAIL_PATTERN.DONE!
		//If match fails, create a new FacesMessage(String, String) object.DONE!
		//Use proper error messages.DONE!
		//Set the severity of your FacesMessage to FacesMessage.SEVERITY_ERROR.DONE!
		//Finally, throw an exception with the FacesMessage in it.DONE!
		//To know what exception should be thrown, look at the signature of this method.DONE!
	}

}
