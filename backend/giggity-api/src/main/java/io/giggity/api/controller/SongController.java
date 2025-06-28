package io.giggity.api.controller;

import io.giggity.api.model.Song;
import io.giggity.api.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongService svc;

    public SongController(SongService svc) {
        this.svc = svc;
    }

    @GetMapping
    public List<Song> list() {
        return svc.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Song create(@RequestBody Song song) {
        return svc.save(song);
    }
}