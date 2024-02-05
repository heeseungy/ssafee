package coffee.ssafy.ssafee.domain.chat.controller;

import coffee.ssafy.ssafee.domain.chat.dto.request.ChatRequest;
import coffee.ssafy.ssafee.domain.chat.dto.response.ChatResponse;
import coffee.ssafy.ssafee.domain.chat.service.ChatService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/parties/{access_code}/chats")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    @Operation(summary = "채팅 생성")
    public ResponseEntity<Void> createChat(@PathVariable("access_code") String accessCode,
                                           @RequestBody ChatRequest chatRequest) {
        chatService.createChat(accessCode, chatRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "채팅 기록 조회")
    public ResponseEntity<List<ChatResponse>> getChats(@PathVariable("access_code") String accessCode) {
        return ResponseEntity.ok().body(chatService.getChats(accessCode));
    }

}
