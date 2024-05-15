package mk.ukim.finki.emt.sharedkernel.domain.events.streams;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class StreamRemoved extends DomainEvent {
    private String movieId;
    public StreamRemoved(String topic) {
        super(TopicHolder.TOPIC_STREAM_REMOVED);
    }

    public StreamRemoved(String topic, String movieId) {
        super(TopicHolder.TOPIC_STREAM_REMOVED);
        this.movieId=movieId;
    }
}
