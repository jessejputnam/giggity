package io.giggity.api.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    @NotBlank
    private String email;
    @NotBlank
    private String displayName;
    @NotBlank
    private String password;
    @NotBlank
    private String status = "Active";
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
}
