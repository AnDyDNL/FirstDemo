package com.oracle.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

class MyInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyInterceptor() {
		System.out.println("创建拦截器对象");
	}

	@Override
	public void destroy() {
		System.out.println("拦截器销毁");
	}

	@Override
	public void init() {
		System.out.println("执行拦截器的初始方法");

	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	    System.out.println("2. 拦截器，业务处理-开始");
		//拿到当前执行的方法名：判断，只有当前方法名不是login,就进行验证
		// 获取ActionContext对象
		ActionContext ac = invocation.getInvocationContext();
		// 获取action的代理对象
		ActionProxy proxy = invocation.getProxy();
		// 获取当前执行的方法名
		String methodName = proxy.getMethod();
		// 判断当前是哪个方法-->如果不是login则判断有没有登录
		if (!"login".equals(methodName)) {
			//获取session
			Map<String, Object> session = ac.getSession();
			//判断session不为空则已经登录呢
			 // 先获取当前登陆的用户
			 Object obj = ac.getSession().get("userInfo");
			 if (obj == null) {
				 // 没有登陆
				 return "input";
			 } else {
				 // 当前用户有登陆
				 return invocation.invoke();
			 }
		 } else {
			 // 说明当前用户正在登陆
			 System.out.println("3.拦截器业务结束");
			 return invocation.invoke();
		 }
	}
}