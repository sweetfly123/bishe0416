package cn.lyf.hotelserver.service.Impl;

import cn.lyf.hotelserver.dao.HouseDao;
import cn.lyf.hotelserver.entity.HouseDO;
import cn.lyf.hotelserver.entity.SiteDO;
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
public class HouseServiceImpl implements HouseService {

    @Resource
    private HouseDao houseDao;

    @Override
    public HouseDO getHouseById(Integer Id) {
        HouseDO house = houseDao.getHouseById(Id);
        String housePicturePath = house.getHotelPicturePath();
        if (housePicturePath != null && !("".equals(housePicturePath))) {
            housePicturePath = housePicturePath.substring(0, housePicturePath.length() - 2);
            house.setPictures(Arrays.asList(housePicturePath.split("!!")));
        }
        return house;
    }

    @Override
    public List<HouseDO> findAllHouses() {
        List<HouseDO> houses = houseDao.findAllHouses();
        if (houses.size() > 0) {
            for (HouseDO house : houses) {
                String housePicturePath = house.getHotelPicturePath(); //house !=""
                if (housePicturePath != null && !("".equals(housePicturePath))) {
                    housePicturePath = housePicturePath.substring(0, housePicturePath.length() - 2);
                    house.setPictures(Arrays.asList(housePicturePath.split("!!")));
                }
            }
        }
        return houses;
    }

    @Override
    public List<HouseDO> findAllHousesBySiteId(Integer siteId) {
        List<HouseDO> houses = houseDao.findAllHousesBySiteId(siteId);
        if (houses.size() > 0) {
            for (HouseDO house : houses) {
                String housePicturePath = house.getHotelPicturePath(); //house !=""
                if (housePicturePath != null && !("".equals(housePicturePath))) {
                    housePicturePath = housePicturePath.substring(0, housePicturePath.length() - 2);
                    house.setPictures(Arrays.asList(housePicturePath.split("!!")));
                }
            }
        }
        return houses;
    }

    @Override
    public int addHouse(HouseDO houseDO) {
        return houseDao.addHouse(houseDO);
    }

    @Override
    public int updateHouse(HouseDO houseDO) {
        return houseDao.updateHouse(houseDO);
    }

    @Override
    public int deleteHouse(Integer Id) {
        return houseDao.deleteHouse(Id);
    }
}
