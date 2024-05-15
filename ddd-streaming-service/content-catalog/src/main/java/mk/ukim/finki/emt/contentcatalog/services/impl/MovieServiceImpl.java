package mk.ukim.finki.emt.contentcatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.contentcatalog.domain.exceptions.MovieNotFoundException;
import mk.ukim.finki.emt.contentcatalog.domain.models.Movie;
import mk.ukim.finki.emt.contentcatalog.domain.models.MovieId;
import mk.ukim.finki.emt.contentcatalog.domain.repository.MovieRepository;
import mk.ukim.finki.emt.contentcatalog.services.MovieService;
import mk.ukim.finki.emt.contentcatalog.services.forms.MovieForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    @Override
    public Movie findById(MovieId id) {
        return movieRepository.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    @Override
    public Movie createMovie(MovieForm form) {
        Movie m = Movie.build(form.getMovieName(), form.getMovieDesc(), form.getMovieDuration(), form.getMovieReleaseDate());
        movieRepository.save(m);
        return m;
    }

    @Override
    public Movie watchMovieCreated(MovieId movieId) {
        Movie m = movieRepository.findById(movieId).orElseThrow(MovieNotFoundException::new);
        movieRepository.saveAndFlush(m);
        return m;
    }

    @Override
    public Movie watchMovieRemoved(MovieId movieId) {
        Movie m = movieRepository.findById(movieId).orElseThrow(MovieNotFoundException::new);
        movieRepository.saveAndFlush(m);
        return m;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
