package action;

public class ActionForward{
	
	private static ActionForward forward = new ActionForward();
	private String path = null;
	private String errorMsg = null;
	private boolean isError = false;
	
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

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}
	
	
}
