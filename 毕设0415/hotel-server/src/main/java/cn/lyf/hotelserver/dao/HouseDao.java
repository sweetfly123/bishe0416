package cn.lyf.hotelserver.dao;

import cn.lyf.hotelserver.entity.HouseDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HouseDao {

    HouseDO getHouseById(Integer Id);

    List<HouseDO> findAllHouses();

    List<HouseDO> findAllHousesBySiteId(Integer siteId);

    int addHouse(HouseDO houseDO);

    int updateHouse(HouseDO houseDO);

    int deleteHouse(Integer Id);

}
