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
    @PutMapping("/update/{id}")
    public ResponseEntity<Chat> update(@PathVariable Long id,@RequestBody Chat chat){
        return ResponseEntity.ok(chatService.updateChat(id,chat));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id){
        if(chatService.deleteChat(id)){
            return ResponseEntity.ok("Chat with id "+id+" deleted successfully");
        }
        return ResponseEntity.internalServerError().build();
    }


}
