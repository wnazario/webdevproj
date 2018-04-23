package controllers_emergency;

import java.io.IOException;   

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers_emergency.AddEmergencyQuery;
import model.Emergency;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Controller for adding a new emergency to the database", urlPatterns = { "/addEmergency" })
public class AddEmergencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmergencyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the data
	    String contact = request.getParameter("emergency_contact");
	    String operator = request.getParameter("drone_operator");
	    String actions = request.getParameter("operator_actions");
	    String comments = request.getParameter("operator_comments");
	    
	
		// set up a emergency object
	    Emergency emergency = new Emergency();
	    emergency.setEmergency_contact(contact);
	    emergency.setDrone_operator(operator);
	    emergency.setOperator_actions(actions);
	    emergency.setOperator_comments(comments);


	    
		// set up an addQuery object
	    AddEmergencyQuery aeq = new AddEmergencyQuery("drone_incidents", "root", "");
	    
		// pass the product to addQuery to add to the database
	    aeq.doAdd(emergency);
	    
		// pass execution control to the ReadServlet
	    String url = "/readEmergency";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	    
		
	}

}
