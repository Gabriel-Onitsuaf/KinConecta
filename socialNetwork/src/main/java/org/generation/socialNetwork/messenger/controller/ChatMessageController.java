package org.generation.socialNetwork.messenger.controller;

import org.generation.socialNetwork.messenger.model.ChatMessage;
import org.generation.socialNetwork.messenger.service.ChatMessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
@AllArgsConstructor
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @PostMapping
    public ChatMessage sendMessage(@RequestBody ChatMessage message) {

        return chatMessageService.sendMessage(message);
    }

    @GetMapping("/thread/{threadId}")
    public List<ChatMessage> getMessagesByThread(@PathVariable Long threadId) {

        return chatMessageService.getMessagesByThread(threadId);
    }

}