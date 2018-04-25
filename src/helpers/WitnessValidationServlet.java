package helpers;

import helpers.Validator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/ValidateWitness")
public class WitnessValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WitnessValidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String url = "/addWitness";
		// name <= 15 characters
		//sets new userName String value from whatever has parameter from request object (in this case index.jsp)
		String name = request.getParameter("name");
		
		//if it is/not a name... appends to "msg" string
		if (!Validator.isName(name)){
			msg += "The name has not been entered.<br />";
			url = "/inputErrors.jsp";
		} else if (!Validator.isShortName(name)){
			msg += "The name should be no greater than 15 characters.<br />";
			url = "/inputErrors.jsp";
		} else {
		    request.setAttribute("name", name);
		}
		
		// phone
		String phone = request.getParameter("phone");
		if (!Validator.isPhone(phone)){
			msg += "The phone number is not entered correctly.<br />";
			url = "/inputErrors.jsp";
		} else {
			 request.setAttribute("phone", phone);
			}
		
		// email
		String email = request.getParameter("email");
		if (!Validator.isEmail(email)){
			msg += "The email is not entered correctly.<br />";
			url = "/inputErrors.jsp";
		} else {
		    request.setAttribute("email", email);
		}
		
		
		
		request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

