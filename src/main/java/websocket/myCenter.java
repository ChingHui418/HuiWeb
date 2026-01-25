package websocket;

import java.io.IOException;
import java.util.HashSet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/mycenter")
public class myCenter {
	private static HashSet<Session> sessions;
	private static boolean isExistTeacher = false;
	private static Session teacherSession;
	
	public myCenter() {
		if (sessions == null) {
			sessions = new HashSet<>();
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		if (sessions.add(session)) {
			// System.out.println("New Session..");
		}
	}
	
	@OnMessage
	public void onMessage(String mesg, Session session) {
		// 判斷是否 Teacher => mesg
		if (!isExistTeacher && mesg.contains("isTeacher")) {
			isExistTeacher = true;
			teacherSession = session;
			System.out.println("Teacher Exist");
		}else if (session == teacherSession) {
			// System.out.println("Teacher Drawing");
			for (Session userSession : sessions) {
				try {
					userSession.getBasicRemote().sendText(mesg);
					// System.out.println("Send Student");
				} catch (IOException e) {
				}
			}			
		}
	}
	
//	@OnClose
//	public void onClose(Session session) {
//		//System.out.println("onClose()");
//		sessions.remove(session);
//	}
	
	@OnClose
	public void onClose(Session session) {
	    // 移除連線
	    sessions.remove(session);
	    
	    // 【新增】如果是老師斷線，要把位置讓出來！
	    if (session == teacherSession) {
	        teacherSession = null;
	        isExistTeacher = false;
	        System.out.println("老師已離開，釋出權限");
	    }
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("onError()");		
	}
	
}