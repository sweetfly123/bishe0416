package cn.lyf.hotelserver.service.Impl;

import cn.lyf.hotelserver.dao.HotelDao;
import cn.lyf.hotelserver.entity.HotelDO;
import cn.lyf.hotelserver.service.HotelService;
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
public class HotelServiceImpl implements HotelService {

    @Resource
    private HotelDao hotelDao;

    @Override
    public HotelDO getHotelByHotelId(String roomId,String houseId) {
        HotelDO room = hotelDao.getHotelByHotelId(roomId,houseId);
        String housePicturePath = room.getRoomPicturePath();
        if (housePicturePath != null && !("".equals(housePicturePath))) {
            housePicturePath = housePicturePath.substring(0, housePicturePath.length() - 2);
            room.setPictures(Arrays.asList(housePicturePath.split("!!")));
        }
        return room;
    }

    @Override
    public List<HotelDO> findAllHotels() {
        List<HotelDO> rooms = hotelDao.findAllHotels();
        if (rooms.size() > 0) {
            for (HotelDO house : rooms) {
                String path = house.getRoomPicturePath(); //house !=""
                if (path != null && !("".equals(path))) {
                    path = path.substring(0, path.length() - 2);
                    house.setPictures(Arrays.asList(path.split("!!")));
                }
            }
        }
        return rooms;
    }

    @Override
    public List<HotelDO> findAllHotelsByCondition(Integer houseId) {
        List<HotelDO> rooms = hotelDao.findAllHotelsByCondition(houseId);
        if (rooms.size() > 0) {
            for (HotelDO house : rooms) {
                String path = house.getRoomPicturePath(); //house !=""
                if (path != null && !("".equals(path))) {
                    path = path.substring(0, path.length() - 2);
                    house.setPictures(Arrays.asList(path.split("!!")));
                }
            }
        }
        return rooms;
    }

    @Override
    public List<HotelDO> getHotelByUserName(String userName) {
        List<HotelDO> rooms = hotelDao.getHotelByUserName(userName);
        if (rooms.size() > 0) {
            for (HotelDO house : rooms) {
                String path = house.getRoomPicturePath(); //house !=""
                if (path != null && !("".equals(path))) {
                    path = path.substring(0, path.length() - 2);
                    house.setPictures(Arrays.asList(path.split("!!")));
                }
            }
        }
        return rooms;
    }

    @Override
    public int addHotel(HotelDO hotelDO) {
        return hotelDao.addHotel(hotelDO);
    }

    @Override
    public int updateRoom(HotelDO hotelDO) {
        return hotelDao.updateRoom(hotelDO);
    }

    @Override
    public int deleteHotel(String roomId) {
        return hotelDao.deleteHotel(roomId);
    }

    @Override
    public HotelDO getHotelOrderInfoByHotelId(String roomId) {
        return hotelDao.getHotelOrderInfoByHotelId(roomId);
    }

    @Override
    public HotelDO getHotelByRoomId(String roomId) {
        HotelDO room = hotelDao.getHotelByRoomId(roomId);
        String housePicturePath = room.getRoomPicturePath();
        if (housePicturePath != null && !("".equals(housePicturePath))) {
            housePicturePath = housePicturePath.substring(0, housePicturePath.length() - 2);
            room.setPictures(Arrays.asList(housePicturePath.split("!!")));
        }
        return room;
    }

}
