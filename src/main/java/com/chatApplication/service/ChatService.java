package com.chatApplication.service;

import com.chatApplication.Entity.Chat;
import com.chatApplication.Repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public Chat createChat(Chat chat){
        return chatRepository.save(chat);
    }

    public List<Chat> getAll(){
        return chatRepository.findAll();
    }
}
