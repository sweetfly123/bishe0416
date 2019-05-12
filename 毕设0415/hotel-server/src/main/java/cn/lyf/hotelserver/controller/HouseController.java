package cn.lyf.hotelserver.controller;

import cn.lyf.hotelserver.entity.HotelDO;
import cn.lyf.hotelserver.entity.HouseDO;
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
@RequestMapping("/house")
public class HouseController {

    @Value("${web.upload-path}")
    private String path;
    @Resource
    private HouseService houseService;

    @RequestMapping(value = "/{Id}", method = RequestMethod.GET)
    public HouseDO getHouseById(@PathVariable("Id") Integer Id) {
        HouseDO houseDO = houseService.getHouseById(Id);
        return houseDO;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<HouseDO> findAllHouses() {
        List<HouseDO> list = houseService.findAllHouses();
        return list;
    }

    @RequestMapping(value = "/site/{siteId}", method = RequestMethod.GET)
    public List<HouseDO> findAllHousesBySiteId(@PathVariable("siteId") Integer siteId) {
        List<HouseDO> list = houseService.findAllHousesBySiteId(siteId);
        return list;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public String addHouse(MultipartFile[] files, HouseDO houseDO) {
        String msg = "";
        String realPath = path + "house/";
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
        houseDO.setHotelPicturePath(picturePaths);
        houseService.addHouse(houseDO);
        return msg;
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public String updateHouse(MultipartFile[] files,HouseDO houseDO) {
        String msg = "";
        String realPath = path + "house/";
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
        houseDO.setHotelPicturePath(picturePaths);
        houseService.updateHouse(houseDO);
        return msg;
    }

    @RequestMapping(value = "/{Id}", method = RequestMethod.DELETE)
    public int deleteHouse(@PathVariable("Id") Integer Id) {
        int result = houseService.deleteHouse(Id);
        return result;
    }

}
