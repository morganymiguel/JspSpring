package kr.or.ddit.websocket;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketPushMessageHandler extends TextWebSocketHandler {
	@Resource(name="allWsSessions")
	private List<WebSocketSession> allWsSessions;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		allWsSessions.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		allWsSessions.remove(session);
	}
}
