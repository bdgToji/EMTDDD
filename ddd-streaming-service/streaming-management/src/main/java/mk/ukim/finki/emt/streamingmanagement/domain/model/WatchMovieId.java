package mk.ukim.finki.emt.streamingmanagement.domain.model;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class WatchMovieId extends DomainObjectId {
    private WatchMovieId(){
        super(WatchMovieId.randomId(WatchMovieId.class).getId());
    }

    public WatchMovieId(String uuid){
        super(uuid);
    }
}
