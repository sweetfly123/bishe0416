package cn.lyf.hotelserver.controller;

import cn.lyf.hotelserver.entity.HotelDO;
import cn.lyf.hotelserver.service.HotelService;
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
@RequestMapping("/hotels")
public class HotelController {

    @Value("${web.upload-path}")
    private String path;
    @Resource
    private HotelService hotelService;

    /**
     * 通过房间号查询
     *
     * @param roomId
     * @return
     */
    @RequestMapping(value = "/hotel/{roomId}", method = RequestMethod.GET)
    public HotelDO getHotelByHotelId(@PathVariable("roomId") String roomId) {
        HotelDO hotelDO = hotelService.getHotelByHotelId(roomId);
        return hotelDO;
    }

    /**
     * 查询所有房间信息
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/hotel", method = RequestMethod.GET)
    public List<HotelDO> findAllHotels() {
        List<HotelDO> list = hotelService.findAllHotels();
        return list;
    }

    /**
     * 根据用户名查询房间
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/hotel/userName/{userName}", method = RequestMethod.GET)
    public List<HotelDO> getHotelByUserName(@PathVariable("userName") String userName) {
        return hotelService.getHotelByUserName(userName);
    }

    /**
     * 增加房间
     *
     * @param file
     * @param hotelDO
     * @return
     */
    @RequestMapping(value = "/hotel", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public int addHotel(MultipartFile file, HotelDO hotelDO) {
        //String localPath =getRequest().getServletContext().getRealPath("/static");
        // 要上传的目标文件存放路径
//        File filedir = new File(path);
//        if (!filedir.exists()) {
//            filedir.mkdirs();
//        }
        //String localPath = "D:/DevelopPhotos";
        // 上传成功或者失败的提示
        String msg = "";
        if (FileUtils.upload(file, path, file.getOriginalFilename())) {
            // 上传成功，给出页面提示
            msg = "上传成功！";
        } else {
            msg = "上传失败！";
        }
        String fileName = file.getOriginalFilename();
        hotelDO.setRoomPicturePath(fileName);
        // hotelDO.setRoomPicturePath(resourceLoader.getResource("file:" + path + fileName));
        hotelService.addHotel(hotelDO);
        return 1;
    }

    /**
     * 修改房间
     *
     * @param file
     * @param hotelDO
     * @return
     */
    @RequestMapping(value = "/hotel/modify", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public int updateHotel(MultipartFile file, HotelDO hotelDO) {
        String msg = "";
        if (file != null) {
            if (FileUtils.upload(file, path, file.getOriginalFilename())) {
                msg = "上传成功！";
            } else {
                msg = "上传失败！";
            }
            String fileName = file.getOriginalFilename();
            hotelDO.setRoomPicturePath(fileName);
        }
        hotelService.updateHotel(hotelDO);
        return 1;
    }

    /**
     * @param userId
     * @method: bookHotel
     * @Param: * @param roomId
     * @Description: 用户订购房间
     * @author: DIC.lyf
     * @date: 2018/12/10 15:52
     * @Return: int
     * @version: V1.0
     */
    @RequestMapping(value = "/hotel/room/{roomId}/user/{userId}", method = RequestMethod.PUT)
    public int bookHotel(@PathVariable("roomId") String roomId, @PathVariable("userId") String userId, String startDate, String endDate, String guestNumber) {
        HotelDO hotelDO = new HotelDO();
        hotelDO.setUserId(userId);
        hotelDO.setRoomId(roomId);
        hotelDO.setBooked(true);
        hotelDO.setGuests(guestNumber);
        hotelDO.setStartDate(startDate);
        hotelDO.setEndDate(endDate);
        int result = hotelService.updateHotel(hotelDO);
        return result;
    }

    /**
     * @method: deleteHotel
     * @Param: * @param roomId
     * @Description: 逻辑删除房间
     * @author: DIC.lyf
     * @date: 2018/12/12 17:37
     * @Return: int
     * @version: V1.0
     */
    @RequestMapping(value = "/hotel/room/{roomId}", method = RequestMethod.PUT)
    public int deleteHotel(@PathVariable("roomId") String roomId) {
        int result = hotelService.deleteHotel(roomId);
        return result;
    }

    /**
     * 通过房间号查询预订详情
     *
     * @param roomId
     * @return
     */
    @RequestMapping(value = "/hotel/order/{roomId}", method = RequestMethod.GET)
    public HotelDO getHotelOrderInfoByHotelId(@PathVariable("roomId") String roomId) {
        HotelDO hotelDO = hotelService.getHotelOrderInfoByHotelId(roomId);
        return hotelDO;
    }
}
