package com.app;

public class Result {
//	무조건 결과를 받아야하고 따로받으면 컨트롤러에서 마지막에 보내줘야하는데 리턴을 두번할수없기때문에 객체로 받는거임
//	이 객체를 무조건 리턴할 수 있게 인터페이스를 만들어준다 그럼 무조건 리턴을 할 수 밖에 없게됨
//	어떻게
	private boolean isRedirect;
//	어디로
	private String path;
	
	public Result() {;}

	public Result(boolean isRedirect, String path) {
		this.isRedirect = isRedirect;
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Result [isRedirect=" + isRedirect + ", path=" + path + "]";
	}
}
