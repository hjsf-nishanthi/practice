package Event;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener("/CreateSession.jsp")
public class HandleEvent implements HttpSessionListener {

	private int sessionCount = 0;

	public void sessionCreated(HttpSessionEvent event) {
		synchronized(this) {
			sessionCount++;
		}
		System.out.println("Session created" + event.getSession().getId());
		System.out.println("Session Count" + sessionCount);
	}
	public void sessionDestroyed(HttpSessionEvent event) {
		synchronized(this) {
			sessionCount--;
		}
		System.out.println("Session Destroyed" + event.getSession().getId());
		System.out.println("Session Count" + sessionCount);
	}
}
