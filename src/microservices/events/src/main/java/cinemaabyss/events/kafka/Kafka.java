package cinemaabyss.events.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;

import cinemaabyss.events.event.MovieEvent;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class Kafka {

    public static final String TOPIC_EVENTS = "events";
    private final Logger logger = LoggerFactory.getLogger(Kafka.class);

    @Bean
    public RecordMessageConverter converter() {
        return new JsonMessageConverter();
    }

    @KafkaListener(id = "movieEventListener", topics = TOPIC_EVENTS)
    public void listenMovieEvent(MovieEvent event) {
        logger.info("Received: " + event);
    }

    @KafkaListener(id = "paymentEventListener", topics = TOPIC_EVENTS)
    public void listenPaymentEvent(MovieEvent event) {
        logger.info("Received: " + event);
    }

    @KafkaListener(id = "userEventListener", topics = TOPIC_EVENTS)
    public void listenUserEvent(MovieEvent event) {
        logger.info("Received: " + event);
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic(TOPIC_EVENTS, 1, (short) 1);
    }
}
