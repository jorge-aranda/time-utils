
package es.jaranda.commons.timeutils.examples.timerangeexample.api.configuration;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class MappingsConfiguration {
    @Bean
    public ObjectMapper objectMapper(
            final Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
        return jackson2ObjectMapperBuilder
                    .createXmlMapper(false)
                    .serializationInclusion(JsonInclude.Include.NON_NULL)
                    // Using ISO-8601 to serialize/deserialize dates instead of
                    // timestamps
                    .featuresToDisable(
                            SerializationFeature.WRITE_DATES_AS_TIMESTAMPS
                    )
            .build();
    }
}
