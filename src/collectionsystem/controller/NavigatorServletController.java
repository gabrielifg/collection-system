package collectionsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collectionsystem.controller.actions.UserAuthenticator;
import collectionsystem.controller.actions.clients.ActionListingClients;
import collectionsystem.controller.actions.services.ActionListingServices;


@WebServlet(urlPatterns = "/go")
public class NavigatorServletController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3621914167720742188L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String pageToGo = Pages.LOGIN.toString();

		if(isSessionOpen(req)) {
			if (page != null) {
				if (page.equals("services")) {
					pageToGo = new ActionListingServices(req).execute();
				}
				if (page.equals("services-form")) {
					pageToGo = Pages.SERVICES_FORM.toString();
				}
				if (page.equals("clients")) {
					pageToGo = new ActionListingClients(req).execute();
				}
				if (page.equals("clients-form")) {
					pageToGo = Pages.CLIENTS_FORM.toString();
				}
				if (page.equals("dashboard")) {
					pageToGo = Pages.DASHBOARD.toString();
				}
			}
			
		}else {
			pageToGo = new UserAuthenticator(req).execute();
		}
		req.getRequestDispatcher(pageToGo).forward(req, resp);
	}
	
	private boolean isSessionOpen(HttpServletRequest req) {
		return req.getSession().getAttribute("authenticatedUser")!=null;
	}
}
