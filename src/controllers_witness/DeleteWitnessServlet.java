package controllers_witness;

import java.io.IOException;   

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers_witness.DeleteWitnessQuery;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(description = "Deletes a record for a particular id", urlPatterns = { "/deleteWitness" })
public class DeleteWitnessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWitnessServlet() {
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
		// get the id
		int id = Integer.parseInt(request.getParameter("witnessID"));
		
		// create a deleteQuery object
		DeleteWitnessQuery dwq = new DeleteWitnessQuery("drone_incidents", "root", "");
		
		// use deleteQuery to delete the record
		dwq.doDelete(id);
		
		// pass execution on to the ReadServlet
		String url = "/readWitness";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
