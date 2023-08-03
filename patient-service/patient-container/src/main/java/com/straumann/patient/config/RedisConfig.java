package com.straumann.patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.straumann.patient.service.domain.dto.PatientDTO;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, PatientDTO> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, PatientDTO> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(PatientDTO.class));
        return template;
    }
}
