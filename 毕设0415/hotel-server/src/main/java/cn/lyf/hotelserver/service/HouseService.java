package cn.lyf.hotelserver.service;


import cn.lyf.hotelserver.entity.HouseDO;

import java.util.List;

public interface HouseService {

    HouseDO getHouseById(Integer Id);

    List<HouseDO> findAllHouses();

    List<HouseDO> findAllHousesBySiteId(Integer siteId);

    int addHouse(HouseDO houseDO);

    int updateHouse(HouseDO houseDO);

    int deleteHouse(Integer Id);
}
