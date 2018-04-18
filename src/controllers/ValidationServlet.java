package controllers;

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
@WebServlet("/Go")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String url = "/page2.jsp"; //TODO: Change to new target page
		// username <= 15 characters
		//sets new userName String value from whatever has parameter from request object (in this case index.jsp)
		String userName = request.getParameter("userName");
		
		//if it is/not a name... appends to "msg" string
		if (!Validator.isName(userName)){
			msg += "The name has not been entered.<br />";
			url = "/inputErrors.jsp";
		} else if (!Validator.isShortName(userName)){
			msg += "The name should be no greater than 15 characters.<br />";
			url = "/inputErrors.jsp";
		} else {
		    request.setAttribute("userName", userName);
		}
		
		// age is a number between 0 and 100
		try{
			int gps = Integer.parseInt(request.getParameter("TODO: Find GPS location identifier"));
			if(gps < 0 || gps > 100){
				msg += "The gps location should be between 0 and 100.<br />";
				url = "/inputErrors.jsp";
			}
		} catch (NumberFormatException nfe){
			msg += "The gps location should entered as a number.<br />";
			url = "/inputErrors.jsp";
		}
		
		// date
		String date = request.getParameter("birthDate");
		if (!Validator.isDate(date)){
			msg += "The date is not entered correctly.<br />";
			url = "/inputErrors.jsp";
		} else {
		    request.setAttribute("date", date);
		}
		
		// phone
		String phone = request.getParameter("phone");
		if (!Validator.isPhone(phone)){
			msg += "The phone is not entered correctly.<br />";
			url = "/inputErrors.jsp";
		} else {
		    request.setAttribute("phone", phone);
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

