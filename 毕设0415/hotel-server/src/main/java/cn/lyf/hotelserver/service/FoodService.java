package cn.lyf.hotelserver.service;


import cn.lyf.hotelserver.entity.FoodDO;

import java.util.List;

public interface FoodService {

    FoodDO getFoodById(Integer Id);

    List<FoodDO> findAllFoods();

    List<FoodDO> findAllFoodsBySiteId(Integer siteId);

    int addFood(FoodDO foodDO);

    int updateFood(FoodDO foodDO);

    int deleteFood(Integer Id);

    List<FoodDO> findAllFoodsBySearch(String word);
}
