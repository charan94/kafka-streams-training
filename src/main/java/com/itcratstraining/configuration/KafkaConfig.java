package com.itcratstraining.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class KafkaConfig {

	@Value(value = "${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
	public KafkaStreamsConfiguration kafkaConfig() {
		// Bootstrap Servers config
		// Producer consumer properties
		// String, JSON
		Map<String, Object> props = new HashMap();
		props.put("APPLICATION_ID_CONFIG", "kafka_streams_training");
		props.put("BOOTSTRAP_SERVERS_CONFIG", bootstrapServers);
		return new KafkaStreamsConfiguration(props);
	}
	
	
}
