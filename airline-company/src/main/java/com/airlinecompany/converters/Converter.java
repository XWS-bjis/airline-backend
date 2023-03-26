package com.airlinecompany.converters;

public interface Converter<Entity, Dto>  {

    Dto entityToDto(Entity entity);
    Entity dtoToEntity(Dto dto);
}
