package websocket;

import java.io.IOException;
import java.util.HashSet;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/myserver")
public class myServer {
	private static HashSet<Session> sessions;
	
	public myServer() {
		// System.out.println("MyServer()");
		if(sessions == null) {
			sessions = new HashSet<>(); // 做出物件實體	
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("onOpen()");
		if (sessions.add(session)) {
			System.out.println("New Session...");
		}
	}
	
	@OnMessage
	public void onMessage(String mesg, Session session) {
		// System.out.println("onMessage()" + mesg);
		for(Session userSession : sessions) {
			try {
				userSession.getBasicRemote().sendText(mesg);
			}catch(IOException e) {
			}
		}
	}
	
	@OnClose
	public void onClose(Session session) {
		// System.out.println("onClose()");
		sessions.remove(session);
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("onError()");
	}
	
	
	
	
}
