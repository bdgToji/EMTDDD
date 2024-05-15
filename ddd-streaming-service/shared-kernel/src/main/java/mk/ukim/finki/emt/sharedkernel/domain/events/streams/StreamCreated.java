package mk.ukim.finki.emt.sharedkernel.domain.events.streams;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class StreamCreated extends DomainEvent {
    private String movieId;
//    public StreamCreated(String topic) {
//        super(TopicHolder.TOPIC_STREAM_CREATED);
//    }

    public StreamCreated(String movieId) {
        super(TopicHolder.TOPIC_STREAM_CREATED);
        this.movieId=movieId;
    }

}
