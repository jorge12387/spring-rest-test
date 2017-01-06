package org.spring.test.socket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by user on 1/6/2017.
 */
@ServerEndpoint(value = "/game")
public class MySocket {

    @OnOpen
    public void onOpen(Session session) {

    }

    @OnMessage
    public String onMessage(String message, Session session) {
        if (message.equals("quit")) {
                try {
                    session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Game ended"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
        return message;
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {

    }
}