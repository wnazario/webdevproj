package controllers_witness;

import java.io.IOException;      

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers_witness.AddWitnessQuery;
import model.Witness;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Controller for adding a new witness to the database", urlPatterns = { "/addWitness" })
public class AddWitnessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddWitnessServlet() {
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
	    String name = request.getParameter("name");
	    int phone = Integer.parseInt(request.getParameter("phone"));
	    String email = request.getParameter("email");
	    String address = request.getParameter("address");
	    String type = request.getParameter("type");
	    String report = request.getParameter("report");
	    String contact = request.getParameter("emergency_contact");
	    
	
		// set up a incident object
	    Witness witness = new Witness();
	    witness.setName(name);
	    witness.setPhone(phone);
	    witness.setEmail(email);
	    witness.setAddress(address);
	    witness.setWitness_type(type);
	    witness.setWitness_report(report);
	    witness.setEmergencyContact(contact);


	    
		// set up an addQuery object
	    AddWitnessQuery awq = new AddWitnessQuery("drone_incidents", "root", "");
	    
		// pass the product to addQuery to add to the database
	    awq.doAdd(witness);
	    
		// pass execution control to the ReadServlet
	    String url = "/readWitness";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	    
		
	}

}
