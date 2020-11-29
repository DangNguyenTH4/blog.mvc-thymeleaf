package dangnt.thymeleaf.object.mapper;

import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.model.PostEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
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

    @Mappings({
//            @Mapping(source = "id", target = "id"),
//            @Mapping(source = "title", target = "title"),
            @Mapping(target = "content", ignore = true),
//            @Mapping(source = "introduction", target = "introduction"),
        @Mapping(source = "relatedTag", target = "tags")})
    PostDto toIntroductionPostDto(PostEntity postEntity);


    default List<PostDto> toListIntroductionPostDto(List<PostEntity> list){
        return list.stream().map(this::toIntroductionPostDto).collect(Collectors.toList());
    }

    default List<PostDto> toListPostDto(List<PostEntity> list){
        return list.stream().map(this::toPostDto).collect(Collectors.toList());
    }

    default List<String> mapTags(String relatedTag){
        String[] tags = StringUtils.split(relatedTag, ",");
        if(tags != null){
            return Arrays.asList(tags);
        }
        else{
            return new ArrayList<>();
        }
    }
}
