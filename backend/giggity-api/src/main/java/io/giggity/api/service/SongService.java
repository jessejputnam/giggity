package io.giggity.api.service;

import io.giggity.api.model.Song;
import io.giggity.api.repository.SongRepository;
import io.giggity.api.security.CurrentUser;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository repo;
    private final CurrentUser currentUser;

    public List<Song> getAll() {
        return repo.findAllByUserId(currentUser.getUserId());
    }

    public Song save(Song song) {
        song.setUserId(currentUser.getUserId());
        return repo.save(song);
    }

    // TODO add update/delete/business rules
}