package mk.ukim.finki.emt.contentcatalog.services.forms;

import lombok.Data;

import java.util.Date;

@Data
public class MovieForm {
    private String movieName;
    private String movieDesc;
    private Integer movieDuration;
    private Date movieReleaseDate;
}
