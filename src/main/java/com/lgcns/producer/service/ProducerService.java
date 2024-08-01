package com.lgcns.producer.service;

import com.lgcns.producer.dto.TopicDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerService {

    private final KafkaTemplate<String, TopicDto> kafkaTemplate;

    public TopicDto sendMessageToTopic(String topicName, TopicDto topicDto) {
        log.info("send message '{}' to topic '{}'", topicDto, topicName);
        kafkaTemplate.send(topicName, topicDto);
        return topicDto;
    }
}
