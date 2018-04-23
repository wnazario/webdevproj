package controllers_witness;

import java.io.IOException;    

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Witness;
import dbHelpers_witness.ReadWitnessRecord;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet(description = "This will get an witness and use the data to fill in a table for updating the record", urlPatterns = { "/update4" })
public class UpdateWitnessFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWitnessFormServlet() {
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
		// get the id
		int id = Integer.parseInt(request.getParameter("witnessID"));
		
		// create ReadRecord class
		ReadWitnessRecord rwr = new ReadWitnessRecord("drone_incidents", "root", "", id);
		
		// Use ReadRecord to get the product data
		rwr.doRead();
		
		Witness witness = rwr.getWitness();
		
		// pass Incident and control to the updateForm.jsp
		request.setAttribute("witness", witness);
		
		String url = "/updateWitnessForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
