package io.giggity.api.service;

import io.giggity.api.model.Song;
import io.giggity.api.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository repo;

    public SongService(SongRepository repo) {
        this.repo = repo;
    }

    public List<Song> getAll() {
        return repo.findAll();
    }

    public Song save(Song song) {
        return repo.save(song);
    }

    // TODO add update/delete/business rules
}