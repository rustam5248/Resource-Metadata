package uz.epam.songservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.epam.songservice.entity.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

}
