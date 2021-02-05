package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Loginimpl implements HttpSessionBindingListener{

	String user_id;
	String user_pw;
	
	public static int number = 0;
	
	public Loginimpl() {
		
	}
	
	public Loginimpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		++number;
		System.out.println("접속자 로그인");
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		number--;
		System.out.println("접속자 로그아웃");
	}
	
	
	
}
