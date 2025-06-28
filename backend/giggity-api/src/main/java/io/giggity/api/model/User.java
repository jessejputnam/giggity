package io.giggity.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.time.Instant;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    @NonNull
    private String email;
    @NonNull
    private String displayName;
    @NonNull
    private String password;
    @NonNull
    private String status;
    @NonNull
    private Instant createdAt;
    @NonNull
    private Instant updatedAt;

    /**
     * A lyric section (verse, chorus, bridge, etc.).
     */
    @Data
    public static class LyricSection {
        private int order;
        private String type;
        private String text;
    }
}
