package cn.lyf.hotelserver.dao;

import cn.lyf.hotelserver.entity.FoodDO;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FoodDao {

    FoodDO getFoodById(Integer Id);

    List<FoodDO> findAllFoods();

    List<FoodDO> findAllFoodsBySiteId(Integer siteId);

    int addFood(FoodDO foodDO);

    int updateFood(FoodDO foodDO);

    int deleteFood(Integer Id);

    List<FoodDO> findAllFoodsBySearch(String word);
}
