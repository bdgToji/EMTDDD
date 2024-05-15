package mk.ukim.finki.emt.streamingmanagement.service.forms;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class WatchHistoryForm {

    @Valid
    @NotEmpty
    private List<WatchMovieForm> items = new ArrayList<>();
}
