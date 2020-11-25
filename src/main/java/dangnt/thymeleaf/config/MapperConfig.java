package dangnt.thymeleaf.config;

import dangnt.thymeleaf.object.mapper.PostEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public PostEntityMapper initBean(){
        PostEntityMapper mapper = Mappers.getMapper(PostEntityMapper.class);

        return mapper;
    }
}
