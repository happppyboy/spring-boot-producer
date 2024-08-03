package com.lgcns.producer.config;

import com.lgcns.producer.dto.TopicDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class KafkaProducerConfig {

    @Value("${cloudaa.kafka.producer.bootstrap-servers-config}")
    String bootstrapServersConfig;

    @Value("${cloudaa.kafka.producer.key-serializer-class-config}")
    String keySerializerClassConfig;

    @Value("${cloudaa.kafka.producer.value-serializer-class-config}")
    String valueSerializerClassConfig;

    @Bean
    public ProducerFactory<String, TopicDto> factory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServersConfig);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializerClassConfig);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializerClassConfig);

        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, TopicDto> kafkaTemplate(){
        return new KafkaTemplate<>(factory());
    }
}
