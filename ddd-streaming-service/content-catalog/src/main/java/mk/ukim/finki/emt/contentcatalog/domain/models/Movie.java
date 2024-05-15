package mk.ukim.finki.emt.contentcatalog.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import java.util.Date;

@Entity
@Table(name="movies")
@Getter
public class Movie extends AbstractEntity<MovieId> {
    private String movieName;
    private String movieDesc;
    private Integer movieDuration;
    private Date movieReleaseDate;

    private Movie(){
        super(MovieId.randomId(MovieId.class));
    }

    public static Movie build(String movieName, String movieDesc, Integer movieDuration, Date movieReleaseDate){
        Movie m = new Movie();
        m.movieName=movieName;
        m.movieDesc=movieDesc;
        m.movieDuration=movieDuration;
        m.movieReleaseDate=movieReleaseDate;
        return m;
    }

}
