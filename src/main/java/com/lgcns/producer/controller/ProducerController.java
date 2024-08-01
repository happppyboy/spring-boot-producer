package com.lgcns.producer.controller;

import com.lgcns.producer.dto.TopicDto;
import com.lgcns.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/producer")
public class ProducerController {

    private final ProducerService producerService;

    @PostMapping("/topic/{topicname}")
    public TopicDto sendMessageToTopic(@PathVariable("topicname") String topicName, @RequestBody TopicDto topicDto) {
        return producerService.sendMessageToTopic(topicName, topicDto);
    }
}
