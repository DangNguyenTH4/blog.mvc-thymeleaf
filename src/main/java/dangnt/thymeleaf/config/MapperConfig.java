package dangnt.thymeleaf.config;

import dangnt.thymeleaf.object.mapper.PostEntityMapper;
import dangnt.thymeleaf.object.mapper.SubjectEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public PostEntityMapper initPostEntityMapper(){
        PostEntityMapper mapper = Mappers.getMapper(PostEntityMapper.class);

        return mapper;
    }

    @Bean
    public SubjectEntityMapper initSubjectEntityMapper(){
        SubjectEntityMapper mapper = Mappers.getMapper(SubjectEntityMapper.class);

        return mapper;
    }
}
