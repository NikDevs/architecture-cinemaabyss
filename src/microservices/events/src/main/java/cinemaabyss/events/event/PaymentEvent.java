package cinemaabyss.events.event;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PaymentEvent implements Event {

    private Long payment_id;
    private Long user_id;
    private Double amount;
    private String status;
    private String timestamp;
    private String method_type;
}
