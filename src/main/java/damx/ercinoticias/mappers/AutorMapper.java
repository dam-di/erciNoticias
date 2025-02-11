package damx.ercinoticias.mappers;

import damx.ercinoticias.dtos.AutorDto;
import damx.ercinoticias.entities.Autor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AutorMapper {
    Autor toEntity(AutorDto autorDto);

    AutorDto toDto(Autor autor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Autor partialUpdate(AutorDto autorDto, @MappingTarget Autor autor);
}