package collectionsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collectionsystem.controller.actions.clients.ActionDeleteClient;
import collectionsystem.controller.actions.clients.ActionListingClients;
import collectionsystem.controller.actions.clients.ActionLoadingClientData;
import collectionsystem.controller.actions.clients.ActionSaveClients;


@WebServlet(urlPatterns = "/clients")
public class ClientServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8810072559941655016L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		String cnpj = req.getParameter("cnpj");
		if(operation != null) {
			if(operation.equals("edit")) {
				if(cnpj != null) {
					ActionLoadingClientData actionLoadingClientData = new ActionLoadingClientData(req);
					String page = actionLoadingClientData.execute();
					RequestDispatcher dispatcher = req.getRequestDispatcher(page);
					dispatcher.forward(req, resp);
				}
			}
			if(operation.equals("delete")) {
				if(cnpj != null) {
					String page = new ActionDeleteClient(req).execute();
					RequestDispatcher dispatcher = req.getRequestDispatcher(page);
					dispatcher.forward(req, resp);
					//resp.sendRedirect("services.jsp");
				}
			}
		} else {
			String page = new ActionListingClients(req).execute();
			RequestDispatcher dispatcher = req.getRequestDispatcher(page);
			dispatcher.forward(req, resp);	
		}	
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String page = new ActionSaveClients(req).execute();
		RequestDispatcher dispatcher = req.getRequestDispatcher(page);
		dispatcher.forward(req, resp);
	}
}
