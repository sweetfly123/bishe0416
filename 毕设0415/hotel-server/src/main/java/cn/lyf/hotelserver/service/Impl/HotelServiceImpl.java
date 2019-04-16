package cn.lyf.hotelserver.service.Impl;

import cn.lyf.hotelserver.dao.HotelDao;
import cn.lyf.hotelserver.entity.HotelDO;
import cn.lyf.hotelserver.service.HotelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public HotelDO getHotelByHotelId(String roomId) {
        return hotelDao.getHotelByHotelId(roomId);
    }

    @Override
    public List<HotelDO> findAllHotels() {
        return hotelDao.findAllHotels();
    }

    @Override
    public List<HotelDO> getHotelByUserName(String userName) {
        return hotelDao.getHotelByUserName(userName);
    }

    @Override
    public int addHotel(HotelDO hotelDO) {
        return hotelDao.addHotel(hotelDO);
    }

    @Override
    public int updateHotel(HotelDO hotelDO) {
        return hotelDao.updateHotel(hotelDO);
    }

    @Override
    public int deleteHotel(String roomId) {
        return hotelDao.deleteHotel(roomId);
    }

    @Override
    public HotelDO getHotelOrderInfoByHotelId(String roomId) {
        return hotelDao.getHotelOrderInfoByHotelId(roomId);
    }

}
