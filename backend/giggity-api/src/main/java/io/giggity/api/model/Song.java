package io.giggity.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

/**
 * Simplest possible entity. Add columns as you flesh out the schema.
 */
@Document(collection = "songs")
@Data
public class Song {
    @Id
    private String id;
    private String title;
    private String artist;
    private String keySignature;
    private Integer capoFret;
    private String genre;
    private String lyricsPath; // e.g. path to markdown file
}