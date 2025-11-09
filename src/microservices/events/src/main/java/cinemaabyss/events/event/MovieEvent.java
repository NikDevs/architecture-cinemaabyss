package cinemaabyss.events.event;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MovieEvent implements Event {

    private Long movie_id;
    private String title;
    private String action;
    private Long user_id;
}
