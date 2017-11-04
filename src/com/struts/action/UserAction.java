package com.struts.action;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.oracle.entity.User;


public class UserAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;

	User user = new User();
	//1.ͨ������ע��ķ�ʽ

	//2.ͨ��ʵ�����ע��
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String login(){
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		session.put("userName", user.getName());
		return "success";
	}
	@Override
	public void validate() {
		/**
		 * ������Ҫ��֤���ֶ�
		 */
		super.validate();
	}
	//Action�ж��巽����ָ֤���ķ���
	public void validateLogin() {
		if(user.getName()==null||"".equals(user.getName())){
			super.addFieldError("nameError", "�û�������Ϊ��");
			//ģ�����service�����ҵ�����ж��û����������Ƿ���ȷ
			if(!user.getName().equals("xiaoming")||!user.getPwd().equals("123456")){
			super.addFieldError("nameError", "�û��������������");
			}
		}
	}
	@SuppressWarnings("deprecation")
	public String list(){
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> request = ac.getContextMap();
		List<User> list=new ArrayList<User>();
		list.add(new User("����",new Date(19960724)));
		list.add(new User("����",new Date(1998824)));
		list.add(new User("����",new Date(19960612)));
		request.put("list",list);
		return "list";
	}
	@Override
	public String execute() throws Exception {
		System.out.println("����ִ��action");
		System.out.println("username="+user.getName());
		return SUCCESS;
	}
	//3.ͨ��ʵ��ModelDriven����д����  ����Ҫuser�����set��get����������ҳ���������Ҫ���޸�
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
