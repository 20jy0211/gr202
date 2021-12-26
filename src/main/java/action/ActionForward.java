package action;

public class ActionForward{
	
	private String path = null;
	private boolean isError = false;
	
	public ActionForward() {}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}
	
	
}
