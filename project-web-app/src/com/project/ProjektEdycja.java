package com.project;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.model.Projekt;
import com.project.model.Student;
import com.project.model.Zadanie;
import com.project.util.HibernateUtil;

/**
 * Servlet implementation class ProjektEdycja
 */
@WebServlet("/ProjektEdycja")
public class ProjektEdycja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjektEdycja() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("btn_zapisz") != null) {
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
			
			/*
			Projekt projekt = new Projekt();
			projekt.setNazwa("Projekt testowy");

			LocalDate localDate = LocalDate.of(2015, 12, 31);
			projekt.setDataOddania(localDate);
			LocalDateTime localDateTime = LocalDateTime.now();
			projekt.setDataczasUtworzenia(localDateTime);
			Student student = new Student();
			student.setImie("Piotr");
			student.setEmail("piotrek@gmail.com");
			student.setNazwisko("Lipkowski");
			student.setNrIndeksu("108646");
			student.setStacjonarny(true);
			Set<Student> studenci = new HashSet<Student>();
			studenci.add(student);
			projekt.setStudenci(studenci);
			Zadanie zadanie = new Zadanie();
			zadanie.setDataczasOddania(localDateTime);
			zadanie.setKolejnosc(1);
			zadanie.setNazwa("Pierwsze zadanie");
			zadanie.setOpis("Opis");
			List<Zadanie> zadania = new ArrayList<Zadanie>();

			zadania.add(zadanie);
			projekt.setZadania(zadania);
			entityManager.getTransaction().begin();
			entityManager.persist(projekt);
			entityManager.getTransaction().commit();
			entityManager.close(); // zalecane umieszczenie metody close() w bloku finally

*/

			int projektId = 1;
			Projekt projekt = null;
			try {
				projekt = entityManager.find(Projekt.class, projektId);
			} finally {
				entityManager.close();
			}
			if (projekt != null) {
				System.out.println("Projekt ID: " + projektId + ", nazwa: " + projekt.getNazwa());
				request.setAttribute("projekt", projekt);
				ServletContext context = getServletContext();
				RequestDispatcher dispatcher = context.getRequestDispatcher("/projekt_edycja.jsp");
				dispatcher.forward(request, response);
			}

			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
