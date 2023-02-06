package uz.epam.songservice.service;

import uz.epam.songservice.dto.ResponseDto;
import uz.epam.songservice.entity.Song;

public interface SongService {

  Song saveSong(Song song);

  ResponseDto getSong(Long songId);

}
