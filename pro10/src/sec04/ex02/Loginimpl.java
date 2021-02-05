package sec04.ex02;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Loginimpl implements HttpSessionBindingListener{

	String user_id;
	String user_pw;
	
	static int user_num = 0;
	
	public Loginimpl() {
		
	}
	
	public Loginimpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("立加磊 刘啊");
		++user_num;
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("立加磊 皑家");
		user_num--;
	}
}
