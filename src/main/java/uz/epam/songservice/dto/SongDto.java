package uz.epam.songservice.dto;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {
    private Long id;
    private String name;
    private String artist;
    private String album;
    private String length;
    private String year;

}
