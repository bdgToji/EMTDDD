package mk.ukim.finki.emt.streamingmanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class WatchHistoryId extends DomainObjectId {
    private WatchHistoryId(){
        super(WatchHistoryId.randomId(WatchHistoryId.class).getId());
    }

    public WatchHistoryId(@NonNull String uuid){
        super(uuid);
    }
}
