package mk.ukim.finki.emt.contentcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.contentcatalog.domain.models.MovieId;
import mk.ukim.finki.emt.contentcatalog.services.MovieService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.streams.StreamCreated;
import mk.ukim.finki.emt.sharedkernel.domain.events.streams.StreamRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieEventListener {
    private final MovieService movieService;
    @KafkaListener(topics= TopicHolder.TOPIC_STREAM_CREATED, groupId = "contentCatalog")
    public void consumeStreamCreatedEvent(String jsonMessage){
        try{
            StreamCreated event = DomainEvent.fromJson(jsonMessage, StreamCreated.class);
            movieService.watchMovieCreated(MovieId.of(event.getMovieId()));
        }
        catch (Exception e){

        }
    }

    @KafkaListener(topics= TopicHolder.TOPIC_STREAM_REMOVED, groupId = "contentCatalog")
    public void consumeStreamRemovedEvent(String jsonMessage){
        try{
            StreamRemoved event = DomainEvent.fromJson(jsonMessage, StreamRemoved.class);
            movieService.watchMovieRemoved(MovieId.of(event.getMovieId()));
        }
        catch (Exception e){

        }
    }
}
