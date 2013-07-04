package sg.edu.nus.iss.eleave.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sg.edu.nus.iss.eleave.dao.gaeds.EmployeeDAOImpl;
import sg.edu.nus.iss.eleave.dao.gaeds.Util;
import sg.edu.nus.iss.eleave.dto.Employee;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Servlet implementation class TestData
 */
public class TestData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestData() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		Key co = KeyFactory.createKey("Company", "nus");
		Iterable<Entity> entities = Util.listEntities("Employee", "company", "nus");
		List<Employee> employees = new ArrayList<Employee>();
		for(Entity entity : entities) {
//			employees.add(dao.buildEmployeeDTO(entity));
		}
		
		for (Employee e: employees) {
			out.write(e.getName() + "\n");
			out.write(e.getDesignation());
		}
	}

}
