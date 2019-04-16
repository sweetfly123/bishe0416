package cn.lyf.hotelserver.dao;

import cn.lyf.hotelserver.entity.HotelDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Title:  HotelDao
 * @Param:  * @param null
 * @Description: hotelDao层接口
 * @author: DIC.sweetlfy
 * @date: 2018/11/19 9:43
 * @version: V1.0
 */
@Repository
public interface HotelDao {
    /**
     * 通过房间号查询
     * @param roomId
     * @return
     */
    HotelDO getHotelByHotelId(String roomId);
    /**
     *  查询所有房间信息
     * @return
     */
    List<HotelDO> findAllHotels();
    /**
     * 通过UserName查询该用户的房间
     * @param userName
     * @return
     */
    List<HotelDO> getHotelByUserName(String userName);
    /**
     * 增加房间
     * @param hotelDO
     * @return
     */
    int addHotel(HotelDO hotelDO);
    /**
     * 更新房间信息
     * @param hotelDO
     * @return
     */
    int updateHotel(HotelDO hotelDO);
    /**
     * 逻辑删除房间
     * @param roomId
     * @return
     */
    int deleteHotel(@Param("roomId") String roomId);
    /**
     * 通过房间号查询订房用户详情
     * @param roomId
     * @return
     */
    HotelDO getHotelOrderInfoByHotelId(String roomId);

}
