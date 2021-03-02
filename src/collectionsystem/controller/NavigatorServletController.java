package collectionsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collectionsystem.controller.actions.UserAuthenticator;



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
					//pageToGo = new StudentListGetter(req).execute();
				}
				if (page.equals("services-form")) {
					pageToGo = Pages.SERVICES_FORM.toString();
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
