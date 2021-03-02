package collectionsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collectionsystem.controller.actions.services.*;

@WebServlet(urlPatterns = "/services")
public class ServiceServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6582386246707804295L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		String id = req.getParameter("id");
		if(acao != null) {
			if(acao.equals("editar")) {
				if(id != null) {
					ActionLoadingServiceData actionLoadingServiceData = new ActionLoadingServiceData(req);
					String pagina = actionLoadingServiceData.execute();
					RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
					dispatcher.forward(req, resp);
				}
			}
			if(acao.equals("excluir")) {
				if(id != null) {
					String page = new ActionDeleteService(req).execute();
					RequestDispatcher dispatcher = req.getRequestDispatcher(page);
					dispatcher.forward(req, resp);
					resp.sendRedirect("services.jsp");
				}
			}
		} else {
			String pagina = new ActionListingServices(req).execute();
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);	
		}	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String id = req.getParameter("id");
		String page = new ActionSaveServices(req).execute();
		RequestDispatcher dispatcher = req.getRequestDispatcher(page);
		dispatcher.forward(req, resp);
	}
}
