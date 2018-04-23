package controllers_witness;

import java.io.IOException;     

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Witness;
import dbHelpers_witness.UpdateWitnessQuery;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet(description = "Controller which starts the actual witness update to the database", urlPatterns = { "/updateWitness" })
public class UpdateWitnessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWitnessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the form data and set up a incident object
		int id = Integer.parseInt(request.getParameter("witnessID"));
		String name = request.getParameter("name");
	    int phone = Integer.parseInt(request.getParameter("phone"));
	    String email = request.getParameter("email");
	    String address = request.getParameter("address");
	    String type = request.getParameter("type");
	    String report = request.getParameter("report");
	    String contact = request.getParameter("emergencyContact");
		
	 // set up a incident object
	    Witness witness = new Witness();
	    witness.setWitnessID(id);
	    witness.setName(name);
	    witness.setPhone(phone);
	    witness.setEmail(email);
	    witness.setAddress(address);
	    witness.setWitness_type(type);
	    witness.setWitness_report(report);
	    witness.setEmergencyContact(contact);

		
		// create an UpdateQuery object and use it to update the book
		UpdateWitnessQuery uwq = new UpdateWitnessQuery("drone_incidents", "root", "");
		uwq.doUpdate(witness);
		
		// pass control on to the ReadServlet
		String url = "/readWitness";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
