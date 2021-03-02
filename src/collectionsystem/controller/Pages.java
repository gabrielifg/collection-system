package collectionsystem.controller;

public enum Pages {
	LOGIN("WEB-INF/view/login.jsp"),
	DASHBOARD("WEB-INF/view/dashboard.jsp"),
	SERVICES("WEB-INF/view/services.jsp"),
	SERVICES_FORM("WEB-INF/view/services-form.jsp");
	
	private String value;
	
	Pages(String s) {
		this.value = s;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
	
}
