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
	//1ʵ����ע�����
	//2����ע��
	//3.ͨ��ʵ��ModelDriven����д����  ����Ҫuser�����set��get����������ҳ���������Ҫ���޸�
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
		//��ȡsession����
		Map<String, Object> session = ac.getSession();
		
		//HttpservletRequest����
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("name", request+user.getName());
		//��ȡҳ��Ĳ���
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
