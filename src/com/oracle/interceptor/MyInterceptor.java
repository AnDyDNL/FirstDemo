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
		System.out.println("��������������");
	}

	@Override
	public void destroy() {
		System.out.println("����������");
	}

	@Override
	public void init() {
		System.out.println("ִ���������ĳ�ʼ����");

	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
	    System.out.println("2. ��������ҵ����-��ʼ");
		//�õ���ǰִ�еķ��������жϣ�ֻ�е�ǰ����������login,�ͽ�����֤
		// ��ȡActionContext����
		ActionContext ac = invocation.getInvocationContext();
		// ��ȡaction�Ĵ������
		ActionProxy proxy = invocation.getProxy();
		// ��ȡ��ǰִ�еķ�����
		String methodName = proxy.getMethod();
		// �жϵ�ǰ���ĸ�����-->�������login���ж���û�е�¼
		if (!"login".equals(methodName)) {
			//��ȡsession
			Map<String, Object> session = ac.getSession();
			//�ж�session��Ϊ�����Ѿ���¼��
			 // �Ȼ�ȡ��ǰ��½���û�
			 Object obj = ac.getSession().get("userInfo");
			 if (obj == null) {
				 // û�е�½
				 return "input";
			 } else {
				 // ��ǰ�û��е�½
				 return invocation.invoke();
			 }
		 } else {
			 // ˵����ǰ�û����ڵ�½
			 System.out.println("3.������ҵ�����");
			 return invocation.invoke();
		 }
	}
}