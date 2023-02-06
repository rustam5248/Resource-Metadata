package uz.epam.songservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.epam.songservice.dto.ResourceDto;
import uz.epam.songservice.dto.ResponseDto;
import uz.epam.songservice.dto.SongDto;
import uz.epam.songservice.entity.Song;
import uz.epam.songservice.repository.SongRepository;
import uz.epam.songservice.service.SongService;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

  private SongRepository songRepository;
  private RestTemplate restTemplate;

  @Override
  public Song saveSong(Song song){
    return songRepository.save(song);
  }

  @Override
  public ResponseDto getSong(Long songId){

    ResponseDto responseDto=new ResponseDto();
    Song song=songRepository.findById(songId).get();
    SongDto songDto=mapToSong(song);

    ResponseEntity<ResourceDto> responseEntity =
        restTemplate.getForEntity(
            String.format("http://localhost:8080/resources/%s", song.getResourceId()),
            ResourceDto.class);

    ResourceDto resourceDto=responseEntity.getBody();

    System.out.println(responseEntity.getStatusCode());

    responseDto.setSong(songDto);
    responseDto.setResource(resourceDto);
    return responseDto;
  }

  private SongDto mapToSong(Song song){
    SongDto songDto = new SongDto();
    songDto.setId(song.getId());
    songDto.setName(song.getName());
    songDto.setAlbum(song.getAlbum());
    songDto.setArtist(song.getArtist());
    songDto.setLength(song.getLength());
    songDto.setYear(song.getYear());

    return songDto;
  }
}
