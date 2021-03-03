package eu.abalogh.blackout.usersapi.config;

import java.util.UUID;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import eu.abalogh.blackout.usersapi.model.UtilityType;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mm = new ModelMapper();
		mm.addConverter(new AbstractConverter<Integer, UtilityType>() {
			@Override
			protected UtilityType convert(Integer code) {
				return UtilityType.fromCode(code);
			}
		});
		return mm;
	}
}
