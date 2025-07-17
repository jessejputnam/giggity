package io.giggity.api.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.List;

@Document(collection = "songs")
@Data
public class Song {
    @Id
    private String id;
    // @NotBlank // TODO re-add when implementing DTO
    private String userId;
    @NotBlank
    private String title;
    @NotBlank
    private String artist;
    private String keySignature;
    private Integer capoFret;
    private String genre;
    @Valid
    private List<LyricSection> lyrics;
    private String[] tags;
    private String[] notes;
    @NotBlank
    private String status = "Active";
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;

    @Data
    public static class LyricSection {
        @Min(0)
        private int order;
        @NotBlank
        private String type;
        @NotBlank
        private String text;
    }
}
