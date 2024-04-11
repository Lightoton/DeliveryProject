package de.telran.deliveryproject.mapper;

import de.telran.deliveryproject.dto.FoodDto;
import de.telran.deliveryproject.entity.Food;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    FoodDto toDto(Food food);

}
