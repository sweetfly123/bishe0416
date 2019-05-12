package cn.lyf.hotelserver.controller;

import cn.lyf.hotelserver.entity.FoodDO;
import cn.lyf.hotelserver.entity.HouseDO;
import cn.lyf.hotelserver.service.FoodService;
import cn.lyf.hotelserver.service.HouseService;
import cn.lyf.hotelserver.util.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: HotelController
 * @Description: 酒店房间接口
 * @author: DIC.lyf
 * @date: 2018/12/7 11:31
 * @Return:
 * @version: V1.0
 */
@RestController
@RequestMapping("/food")
public class FoodController {

    @Value("${web.upload-path}")
    private String path;
    @Resource
    private FoodService foodService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public FoodDO getFoodById(@PathVariable("Id") Integer Id) {
        FoodDO FoodDO = foodService.getFoodById(Id);
        return FoodDO;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<FoodDO> findAllFoods() {
        List<FoodDO> list = foodService.findAllFoods();
        return list;
    }

    @RequestMapping(value = "/search/{word}", method = RequestMethod.GET)
    public List<FoodDO> findAllFoodsBySearch(@PathVariable("word") String word) {
        if (word.equals("nothing")){
            word ="";
        }
        List<FoodDO> list = foodService.findAllFoodsBySearch(word);
        return list;
    }

    @RequestMapping(value = "/site/{siteId}", method = RequestMethod.GET)
    public List<FoodDO> findAllFoodsBySiteId(@PathVariable("siteId") Integer siteId) {
        List<FoodDO> list = foodService.findAllFoodsBySiteId(siteId);
        return list;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public String addFood(MultipartFile[] files, FoodDO foodDO) {
        String msg = "";
        String realPath = path + "food/";
        String picturePaths = "";
        if(files != null){
            for (MultipartFile file : files) {
                if (FileUtils.upload(file, realPath, file.getOriginalFilename())) {
                    msg = "上传成功！";
                } else {
                    msg = "上传失败！";
                }
                picturePaths += file.getOriginalFilename() + "!!";
            }
        }
        foodDO.setFoodPicturePath(picturePaths);
        foodService.addFood(foodDO);
        return msg;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public String updateFood(MultipartFile[] files,FoodDO foodDO) {
        String msg = "";
        String realPath = path + "food/";
        String picturePaths = "";
        if(files != null){
            for (MultipartFile file : files) {
                if (FileUtils.upload(file, realPath, file.getOriginalFilename())) {
                    msg = "上传成功！";
                } else {
                    msg = "上传失败！";
                }
                picturePaths += file.getOriginalFilename() + "!!";
            }
        }
        foodDO.setFoodPicturePath(picturePaths);
        foodService.updateFood(foodDO);
        return msg;
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.DELETE)
    public int deleteFood(@PathVariable("Id") Integer Id) {
        int result = foodService.deleteFood(Id);
        return result;
    }

}
