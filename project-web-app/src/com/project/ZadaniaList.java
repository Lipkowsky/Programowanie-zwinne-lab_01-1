package com.project;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.Projekt;
import com.project.model.Zadanie;
import com.project.util.HibernateUtil;

/**
 * Servlet implementation class ZadaniaList
 */
@WebServlet("/ZadaniaList")
public class ZadaniaList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZadaniaList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
		
		String projekt_id = (String) request.getAttribute("x_projekt_id");
		System.out.println(projekt_id);
		
		
		List<Zadanie> zadania = entityManager
				.createNativeQuery("SELECT * FROM zadanie", Zadanie.class).getResultList();
		request.setAttribute("zadania", zadania);
		ServletContext context = getServletContext();
		
		
		RequestDispatcher dispatcher = context.getRequestDispatcher("/zadania.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
