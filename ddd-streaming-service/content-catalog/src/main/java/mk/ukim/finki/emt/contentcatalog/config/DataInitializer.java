package mk.ukim.finki.emt.contentcatalog.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.contentcatalog.domain.models.Movie;
import mk.ukim.finki.emt.contentcatalog.domain.repository.MovieRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final MovieRepository movieRepository;

    @PostConstruct
    public void initData(){
        Movie m1 = Movie.build("Movie1","Desc1",90,new GregorianCalendar(2014, Calendar.MAY, 11).getTime());
        Movie m2 = Movie.build("Movie2","Desc2",110,new GregorianCalendar(2012, Calendar.JULY, 21).getTime());
        if(movieRepository.findAll().isEmpty()){
            movieRepository.saveAll(Arrays.asList(m1,m2));
        }
    }
}
