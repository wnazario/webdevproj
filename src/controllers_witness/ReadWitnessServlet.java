package controllers_witness;

import java.io.IOException;   

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers_witness.ReadWitnessQuery;

/**
 * Servlet implementation class ReadEmergencyServlet
 */
@WebServlet(
		description = "Controller for reading the witness table", 
		urlPatterns = { 
				"/ReadWitnessServlet", 
				"/readWitness",
		})
public class ReadWitnessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadWitnessServlet() {
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
		// Create a ReadQuery helper object
		ReadWitnessQuery rwq = new ReadWitnessQuery("drone_incidents", "root", "");
		
		// Get the html table from the REadQuery object
		rwq.doRead();
		String table = rwq.getHTMLTable();
		
		// pass execution control to read.jsp along with the table
		request.setAttribute("table", table);
		String url = "/readWitness.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
