package io.giggity.api.repository;

import io.giggity.api.model.Song;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SongRepository extends MongoRepository<Song, String> {
    List<Song> findAllByUserId(String userId);
}