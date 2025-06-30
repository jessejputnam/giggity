package io.giggity.api.controller;

import io.giggity.api.model.Song;
import io.giggity.api.service.SongService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/songs")
@Validated
public class SongController {

    private final SongService svc;

    public SongController(SongService svc) {
        this.svc = svc;
    }

    @GetMapping
    public ResponseEntity<List<Song>> list() {
        List<Song> songs = svc.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(songs);
    }

    @PostMapping
    public ResponseEntity<Song> create(@Valid @RequestBody Song song) {
        Song saved = svc.save(song);
        URI location = URI.create("/api/songs/" + saved.getId());
        String eTag = "\"" + saved.getId() + "\"";
        return ResponseEntity.created(location)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.ETAG, eTag)
                .body(saved);
    }
}