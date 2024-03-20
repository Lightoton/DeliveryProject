package de.telran.deliveryproject.repository;

import de.telran.deliveryproject.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

//@Repository
//public interface MenuRepository extends JpaRepository<Menu, UUID> {
//    @Query("SELECT m.menuId, m.title, m.averagePrice, m.createdAt, m.categoryFoods FROM Menu m JOIN Restaurant r on r.")
//    Set<Menu> findMenusByRestaurantTitle(@Param("restaurantTitle") String restaurantTitle);
//}
