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
	//1.通过属性注入的方式

	//2.通过实体类的注入
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
		 * 输入需要验证的字段
		 */
		super.validate();
	}
	//Action中定义方法验证指定的方法
	public void validateLogin() {
		if(user.getName()==null||"".equals(user.getName())){
			super.addFieldError("nameError", "用户名不能为空");
			//模拟调用service层进行业务处理判断用户名和密码是否正确
			if(!user.getName().equals("xiaoming")||!user.getPwd().equals("123456")){
			super.addFieldError("nameError", "用户名或者密码错误");
			}
		}
	}
	@SuppressWarnings("deprecation")
	public String list(){
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> request = ac.getContextMap();
		List<User> list=new ArrayList<User>();
		list.add(new User("张三",new Date(19960724)));
		list.add(new User("李四",new Date(1998824)));
		list.add(new User("王五",new Date(19960612)));
		request.put("list",list);
		return "list";
	}
	@Override
	public String execute() throws Exception {
		System.out.println("正在执行action");
		System.out.println("username="+user.getName());
		return SUCCESS;
	}
	//3.通过实现ModelDriven，重写方法  不需要user对象的set和get方法，而且页面表单名不需要做修改
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
