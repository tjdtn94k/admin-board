package com.admin.board.projectboardadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * **클래스 설명:**
 *
 * * 이 클래스는 웹 소켓 메시징을 구성하고 웹 애플리케이션에서 웹 소켓을 사용할 수 있도록 설정하는 클래스입니다.
 * * `@EnableWebSocketMessageBroker` 어노테이션은 웹 소켓 메시징 기능을 활성화합니다.
 * * `@Configuration` 어노테이션은 이 클래스가 Spring 애플리케이션의 구성 클래스임을 나타냅니다.
 * * `WebSocketMessageBrokerConfigurer` 인터페이스를 구현하여 웹 소켓 메시징 관련 설정을 정의합니다.
 *
 * **```java
 * **메소드 설명:**
 *
 * * Stomp(Simple Text Oriented Messaging Protocol) 엔드포인트를 등록하는 메소드입니다.
 * * `registry.addEndpoint("/chat").withSockJS();`: "/chat" 엔드포인트를 추가하고 SockJS를 사용하도록 설정합니다. SockJS는 다양한 브라우저에서 웹 소켓을 지원할 수 있도록 해주는 기능입니다.
 *
 * **요약:**
 *
 * * 이 설정은 웹 소켓 메시징을 활성화하고, 메시지 브로커를 구성하며, Stomp 엔드포인트를 등록하여 웹 애플리케이션에서 웹 소켓을 사용할 수 있게 합니다.
 * * 클라이언트는 "/chat" 엔드포인트를 통해 웹 소켓에 연결할 수 있습니다.
 * * 클라이언트에서 "/app"으로 시작하는 메시지 엔드포인트로 메시지를 보내면, 해당 메시지는 애플리케이션의 메시지 핸들러에서 처리됩니다.
 * * 애플리케이션에서 "/topic"으로 시작하는 메시지 엔드포인트로 메시지를 보내면, 메시지 브로커가 해당 메시지를 구독자에게 전달합니다.
 *
 */

@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").withSockJS();
    }

}
