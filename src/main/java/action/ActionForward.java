package action;

public class ActionForward{
	
	private static ActionForward forward = new ActionForward();
	private String path = null;
	private boolean redirect = false;
	
	public static ActionForward getInstance(){
		return forward;
	}
	
	ActionForward() {}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	
}
