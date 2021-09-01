package br.com.heycristhian.JpaSpecification.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Singleton {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
