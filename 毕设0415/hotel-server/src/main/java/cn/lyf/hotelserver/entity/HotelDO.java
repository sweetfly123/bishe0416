package cn.lyf.hotelserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title: HotelDO
 * @Description: 酒店实体类
 * @author: DIC.lyf
 * @date: 2018/12/7 11:43
 * @Return:
 * @version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDO {
    /**
     房间号
     */
    private String roomId;
    /**
     类型
     */
    private int roomType;
    /**
     价格
     */
    private double roomPrice;
    /**
     图片路径
     */
    private String roomPicturePath;
    /**
     房间描述
     */
    private String roomDescribe;
    /**
     是否预订
     */
    private boolean booked;
    /**
     订房用户id
     */
    private String userId;
    /**
     住宿人数
     */
    private String guests;
    /**
     订房用户名
     */
    private String userName;
    /**
     起始时间
     */
    private String startDate;
    /**
     到期时间
     */
    private String endDate;
}
