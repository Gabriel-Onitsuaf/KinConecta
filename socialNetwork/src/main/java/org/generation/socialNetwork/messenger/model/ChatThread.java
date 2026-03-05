package generation.socialNetwork.messenger.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chat_threads")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatThread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long threadId;

    private Long tripId;

    private Long touristId;

    private Long guideId;

    private LocalDateTime lastMessageAt;

    private String status;

    private LocalDateTime createdAt;

}