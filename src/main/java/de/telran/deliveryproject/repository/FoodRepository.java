package de.telran.deliveryproject.repository;

import de.telran.deliveryproject.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface FoodRepository extends JpaRepository<Food, UUID> {
    @Query("SELECT f FROM Menu m JOIN m.categoryFoods cf JOIN cf.foods f WHERE m.menuId = :menuId")
    Set<Food> findAllFoodsByMenuId(@Param("menuId") UUID menuId);
}
