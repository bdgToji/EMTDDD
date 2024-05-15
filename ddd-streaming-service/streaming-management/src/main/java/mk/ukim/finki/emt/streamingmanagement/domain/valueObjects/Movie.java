package mk.ukim.finki.emt.streamingmanagement.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import java.util.Date;

@Getter
public class Movie implements ValueObject {
    private final MovieId id;
    private final String movieName;
    private final String movieDesc;
    private final Integer movieDuration;
    private final Date movieReleaseDate;

    private Movie(){
        this.id=MovieId.randomId(MovieId.class);
        this.movieName="";
        this.movieDesc="";
        this.movieDuration=0;
        this.movieReleaseDate=null;
    }

    @JsonCreator
    public Movie(MovieId id, @JsonProperty("movieName") String movieName, @JsonProperty("movieDesc") String movieDesc,
                 @JsonProperty("movieDuration") Integer movieDuration, @JsonProperty("movieReleaseDate") Date movieReleaseDate) {
        this.id = id;
        this.movieName = movieName;
        this.movieDesc = movieDesc;
        this.movieDuration = movieDuration;
        this.movieReleaseDate = movieReleaseDate;
    }
}
