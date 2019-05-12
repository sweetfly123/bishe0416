package cn.lyf.hotelserver.service.Impl;

import cn.lyf.hotelserver.dao.FoodDao;
import cn.lyf.hotelserver.dao.HouseDao;
import cn.lyf.hotelserver.entity.FoodDO;
import cn.lyf.hotelserver.entity.HouseDO;
import cn.lyf.hotelserver.service.FoodService;
import cn.lyf.hotelserver.service.HouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @method: HotelServiceImpl
 * @Description: 酒店业务实现类
 * @author: DIC.lyf
 * @date: 2018/12/7 11:52
 * @Return:
 * @version: V1.0
 */
@Service
public class FoodServiceImpl implements FoodService {

    @Resource
    private FoodDao foodDao;


    @Override
    public FoodDO getFoodById(Integer Id) {
        FoodDO food = foodDao.getFoodById(Id);
        String housePicturePath = food.getFoodPicturePath();
        if (housePicturePath != null && !("".equals(housePicturePath))) {
            housePicturePath = housePicturePath.substring(0, housePicturePath.length() - 2);
            food.setPictures(Arrays.asList(housePicturePath.split("!!")));
        }
        return food;
    }

    @Override
    public List<FoodDO> findAllFoods() {
        List<FoodDO> foods = foodDao.findAllFoods();
        if (foods.size() > 0) {
            for (FoodDO food : foods) {
                String housePicturePath = food.getFoodPicturePath(); //house !=""
                if (housePicturePath != null && !("".equals(housePicturePath))) {
                    housePicturePath = housePicturePath.substring(0, housePicturePath.length() - 2);
                    food.setPictures(Arrays.asList(housePicturePath.split("!!")));
                }
            }
        }
        return foods;
    }

    @Override
    public List<FoodDO> findAllFoodsBySiteId(Integer siteId) {
        List<FoodDO> foods = foodDao.findAllFoodsBySiteId(siteId);
        if (foods.size() > 0) {
            for (FoodDO food : foods) {
                String housePicturePath = food.getFoodPicturePath(); //house !=""
                if (housePicturePath != null && !("".equals(housePicturePath))) {
                    housePicturePath = housePicturePath.substring(0, housePicturePath.length() - 2);
                    food.setPictures(Arrays.asList(housePicturePath.split("!!")));
                }
            }
        }
        return foods;
    }

    @Override
    public int addFood(FoodDO foodDO) {
        return foodDao.addFood(foodDO);
    }

    @Override
    public int updateFood(FoodDO foodDO) {
        return foodDao.updateFood(foodDO);
    }

    @Override
    public int deleteFood(Integer Id) {
        return foodDao.deleteFood(Id);
    }

    @Override
    public List<FoodDO> findAllFoodsBySearch(String word) {
        List<FoodDO> foods = foodDao.findAllFoodsBySearch(word);
        if (foods.size() > 0) {
            for (FoodDO food : foods) {
                String housePicturePath = food.getFoodPicturePath(); //house !=""
                if (housePicturePath != null && !("".equals(housePicturePath))) {
                    housePicturePath = housePicturePath.substring(0, housePicturePath.length() - 2);
                    food.setPictures(Arrays.asList(housePicturePath.split("!!")));
                }
            }
        }
        return foods;
    }
}
