package com.chatApplication.service;

import com.chatApplication.Entity.Chat;
import com.chatApplication.Repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat createChat(Chat chat){
        return chatRepository.save(chat);
    }
}
