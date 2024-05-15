package mk.ukim.finki.emt.contentcatalog.domain.repository;

import mk.ukim.finki.emt.contentcatalog.domain.models.Movie;
import mk.ukim.finki.emt.contentcatalog.domain.models.MovieId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, MovieId> {
}
