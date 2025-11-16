package cinemaabyss.events.event;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserEvent implements Event {

    private Long user_id;
    private String username;
    private String action;
    private String timestamp;
}
