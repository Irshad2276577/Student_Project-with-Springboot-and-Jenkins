package com.chatApplication.controller;

import com.chatApplication.Entity.Chat;
import com.chatApplication.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ResponseEntity<Chat> createChat(@RequestBody Chat chat){
        return new ResponseEntity<>(chatService.createChat(chat), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Chat>> getAllChats(){
        return ResponseEntity.ok(chatService.getAll());
    }


}
