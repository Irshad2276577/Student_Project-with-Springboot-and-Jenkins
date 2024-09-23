package com.chatApplication.service;

import com.chatApplication.Entity.Chat;
import com.chatApplication.Repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Chat updateChat(Long id,Chat chat){
        Optional<Chat> byId = chatRepository.findById(id);
        if(byId.isPresent()){
            Chat chat1 = byId.get();
            chat1.setTitle(chat.getTitle());
            chat1.setMessage(chat.getMessage());
            return chatRepository.save(chat1);
        }else{
            return null;
        }
    }
}
