package mk.ukim.finki.emt.streamingmanagement.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.streamingmanagement.domain.valueObjects.MovieId;

@Entity
@Table(name = "watch_movie")
@Getter
public class WatchMovie extends AbstractEntity<WatchMovieId> {

    @AttributeOverride(name = "id", column = @Column(name = "movie_id", nullable = false))
    private MovieId movieId;

    public WatchMovie(@NonNull MovieId movieId){
        super(DomainObjectId.randomId(WatchMovieId.class));
        this.movieId=movieId;
    }
}
