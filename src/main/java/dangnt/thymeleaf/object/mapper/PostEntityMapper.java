package dangnt.thymeleaf.object.mapper;

import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.model.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PostEntityMapper {
    @Mappings({
//            @Mapping(source = "id", target = "id"),
//            @Mapping(source = "title", target = "title"),
//            @Mapping(source = "content", target = "content"),
//            @Mapping(source = "introduction", target = "introduction"),
            @Mapping(source = "relatedTag", target = "tags")})
    PostDto toPostDto(PostEntity postEntity);
}
