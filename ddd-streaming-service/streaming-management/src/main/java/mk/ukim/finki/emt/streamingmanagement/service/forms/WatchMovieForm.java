package mk.ukim.finki.emt.streamingmanagement.service.forms;

import lombok.Data;
import mk.ukim.finki.emt.streamingmanagement.domain.valueObjects.Movie;

import javax.validation.constraints.NotNull;

@Data
public class WatchMovieForm {

    @NotNull
    private Movie movie;
}
