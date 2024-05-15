package mk.ukim.finki.emt.contentcatalog.services;

import mk.ukim.finki.emt.contentcatalog.domain.models.Movie;
import mk.ukim.finki.emt.contentcatalog.domain.models.MovieId;
import mk.ukim.finki.emt.contentcatalog.services.forms.MovieForm;

import java.util.List;

public interface MovieService {

    Movie findById(MovieId id);
    Movie createMovie(MovieForm form);
    Movie watchMovieCreated(MovieId movieId);
    Movie watchMovieRemoved(MovieId movieId);
    List<Movie> getAll();
}
