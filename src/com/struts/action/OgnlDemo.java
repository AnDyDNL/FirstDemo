package com.struts.action;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class OgnlDemo extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getAttribute(){
		Map<String, Object> request = ActionContext.getContext().getContextMap();
		request.put("username", "hello");
		return "success";
	}
}
