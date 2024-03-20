package de.telran.deliveryproject.repository;

import de.telran.deliveryproject.entity.CategoryFood;
import de.telran.deliveryproject.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodCategoryRepository extends JpaRepository<CategoryFood, UUID> {
}
