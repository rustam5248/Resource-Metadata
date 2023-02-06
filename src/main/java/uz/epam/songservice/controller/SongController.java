package uz.epam.songservice.controller;

import lombok.AllArgsConstructor;
import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.epam.songservice.dto.ResponseDto;
import uz.epam.songservice.entity.Song;
import uz.epam.songservice.service.SongService;

@RestController
@RequestMapping("/songs")
@AllArgsConstructor
public class SongController {

  private SongService songService;

  @PostMapping
  public ResponseEntity<Song> saveSong(@RequestBody Song song){
    Song saveSong=songService.saveSong(song);
    return new ResponseEntity<>(saveSong, HttpStatus.CREATED);
  }

  @GetMapping("{id}")
  public ResponseEntity<ResponseDto> getSong(@PathVariable("id") Long songId){
    ResponseDto responseDto = songService.getSong(songId);
    return ResponseEntity.ok(responseDto);
  }
}
