package mk.ukim.finki.emt.contentcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.contentcatalog.domain.models.Movie;
import mk.ukim.finki.emt.contentcatalog.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@AllArgsConstructor
public class MovieResource {

    private final MovieService movieService;

    @GetMapping
    public List<Movie> getAll(){
        return movieService.getAll();
    }
}
