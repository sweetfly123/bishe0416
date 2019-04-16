package cn.lyf.hotelserver.service;


import cn.lyf.hotelserver.entity.HotelDO;

import java.util.List;
/**
 * @Title: HotelService
 * @Description: 酒店房间业务逻辑
 * @author: DIC.lyf
 * @date: 2018/12/7 11:51
 * @Return:
 * @version: V1.0
 */
public interface HotelService {
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
    int deleteHotel(String roomId);
    /**
     * 通过房间号查询订房用户详情
     * @param roomId
     * @return
     */
    HotelDO getHotelOrderInfoByHotelId(String roomId);
}
