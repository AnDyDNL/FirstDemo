package com.struts.action;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.oracle.entity.User;
public class MyAction extends ActionSupport implements ModelDriven<User>,ServletRequestAware,RequestAware{
	//1实体类注入对象
	//2属性注入
	//3.通过实现ModelDriven，重写方法  不需要user对象的set和get方法，而且页面表单名不需要做修改
	private Map req;
	private HttpServletRequest request;
	User user=new User();
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String execute(){
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> req = ac.getContextMap();
		req.put("req",req+user.getName());
		//获取session对象
		Map<String, Object> session = ac.getSession();
		
		//HttpservletRequest对象
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("name", request+user.getName());
		//获取页面的参数
		System.out.println("userName="+user.getName());
		return "success";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	@Override
	public void setRequest(Map<String, Object> req) {
		// TODO Auto-generated method stub
		this.req=req;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
