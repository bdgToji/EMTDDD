package mk.ukim.finki.emt.streamingmanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.streamingmanagement.domain.valueObjects.Movie;
import mk.ukim.finki.emt.streamingmanagement.domain.valueObjects.MovieId;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "watched_history")
@Getter
public class WatchHistory extends AbstractEntity<WatchHistoryId> {
    private Instant watchedOn;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<WatchMovie> watchMovieList;

    private WatchHistory(){
        super(WatchMovieId.randomId(WatchHistoryId.class));
    }

    public WatchHistory(Instant now){
        super(WatchHistoryId.randomId((WatchHistoryId.class)));
        this.watchedOn=now;
    }

    public WatchMovie addMovie(@NonNull Movie movie){
        Objects.requireNonNull(movie, "movie must not be null");
        var item = new WatchMovie(movie.getId());
        watchMovieList.add(item);
        return item;
    }

    public void removeMovie(@NonNull WatchMovieId watchMovieId){
        Objects.requireNonNull(watchMovieId, "Watched Movie must not be null");
        watchMovieList.removeIf(v->v.getId().equals(watchMovieId));
    }
}
