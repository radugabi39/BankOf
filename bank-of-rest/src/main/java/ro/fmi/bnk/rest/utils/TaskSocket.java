package ro.fmi.bnk.rest.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import ro.fmi.bnk.dao.repo.TaskDAO;
import ro.fmi.bnk.models.TaskModel;
@Component
public class TaskSocket extends TextWebSocketHandler {
	@Autowired
	private TaskDAO taskDAO;
    WebSocketSession session;

    // This will send only to one client(most recently connected)
    public void counterIncrementedCallback() {
//        System.out.println("Trying to send:" + counter);
         if (session != null && session.isOpen()) {
        	String uri=session.getUri().toString();
        	int ind=uri.indexOf("userName=");
        	String userName=session.getUri().toString().substring(ind+9,uri.length());
        	
    		
        	List<TaskModel> obj=taskDAO.getPendingTasks(userName);
            try {ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(obj);
//                System.out.println("Now sending:" + counter);
                session.sendMessage(new TextMessage(jsonInString));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("Connection established");
        this.session = session;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        if ("CLOSE".equalsIgnoreCase(message.getPayload())) {
            session.close();
        } else {
            System.out.println("Received:" + message.getPayload());
        }
    }
    
//	public void handleMessage(WebSocketSession session, WebSocketMessage<?> messag
    @Override
	public void handleMessage(WebSocketSession session, WebSocketMessage message)
            throws Exception {
        System.out.println("recivied");
    }
}