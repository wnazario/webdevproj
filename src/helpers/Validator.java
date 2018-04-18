// package helpers;
//public class Validator {
package helpers;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	//check if String parameter is a name; returns false if not
	public static boolean isName(String name){
		// if name is empty
		if (name == null){
			return false;
		} else if (name.equals("") || name.isEmpty()){
		   return false;	
		}
		return true;
	}
	
	//check if String parameter is less than 15 characters; 
	//returns false if not
	public static boolean isShortName(String name){
		// if name is empty
		if (name.length() > 15){
		   return false;	
		}
		return true;
	}
	
	//check to see if String parameter is a date
	public static boolean isDate(String date) {
	    if (date == null || !date.matches("\\d{4}-[01]\\d-[0-3]\\d")){
	        return false;
	    }
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    df.setLenient(false);
	    try {
	        df.parse(date);
	        return true;
	    } catch (ParseException ex) {
	        return false;
	    }
	}
	
	//checks to see if String parameter is an e-mail
	public static boolean isEmail(String emailStr) {
		Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailRegex.matcher(emailStr);
		return matcher.find();
	}
	
	//checks to see if String parameter is a phone number
	public static boolean isPhone(String phoneStr) {
		Pattern phoneRegex = Pattern.compile("^(?=.{7,32}$)(\\(?\\+?[0-9]*\\)?)?[0-9_\\- \\(\\)]*((\\s?x\\s?|ext\\s?|extension\\s?)\\d{1,5}){0,1}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = phoneRegex.matcher(phoneStr);
		return matcher.find();
	}
	
	//checks to see if String parameter is a URL
	public static boolean isURL(String urlStr) {
		Pattern urlRegex = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = urlRegex.matcher(urlStr);
		return matcher.find();
	}
}
