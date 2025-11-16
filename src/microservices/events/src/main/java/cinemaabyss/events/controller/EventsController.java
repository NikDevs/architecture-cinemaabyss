package cinemaabyss.events.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cinemaabyss.events.event.Event;
import cinemaabyss.events.event.MovieEvent;
import cinemaabyss.events.event.PaymentEvent;
import cinemaabyss.events.event.UserEvent;
import cinemaabyss.events.kafka.Kafka;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventsController {

    private final Logger logger = LoggerFactory.getLogger(EventsController.class);

    private final KafkaTemplate<Object, Event> template;

    @GetMapping("/health")
    public GetResponse health() {
        logger.info("get health");
        return new GetResponse(true);
    }

    @PostMapping("/movie")
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse movie(@RequestBody MovieEvent movieEvent) {
        logger.info("send: {}", movieEvent);
        template.send(Kafka.TOPIC_EVENTS, movieEvent);
        return new PostResponse("success");
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse user(@RequestBody UserEvent userEvent) {
        logger.info("send: {}", userEvent);
        template.send(Kafka.TOPIC_EVENTS, userEvent);
        return new PostResponse("success");
    }

    @PostMapping("/payment")
    @ResponseStatus(HttpStatus.CREATED)
    public PostResponse payment(@RequestBody PaymentEvent paymentEvent) {
        logger.info("send: {}", paymentEvent);
        template.send(Kafka.TOPIC_EVENTS, paymentEvent);
        return new PostResponse("success");
    }
}
