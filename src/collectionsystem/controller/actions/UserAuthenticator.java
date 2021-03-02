package collectionsystem.controller.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import collectionsystem.controller.Pages;



public class UserAuthenticator implements Action{

	private HttpServletRequest req;
	private HttpSession session;

	public UserAuthenticator(HttpServletRequest req) {
		this.req = req;
	}
	
	@Override
	public String execute() {
		String login = req.getParameter("login-input");
		String pass = req.getParameter("pass-input");
		session = req.getSession();
		
		if(session.getAttribute("authenticatedUser")!=null)
			return Pages.DASHBOARD.toString();
		if(login!=null && pass!=null) {
			if(login.equals("kenyo") && pass.equals("123")) {
				session.setAttribute("authenticatedUser", login);
				return Pages.DASHBOARD.toString();
			}
		}
		return Pages.LOGIN.toString();
	}

}

