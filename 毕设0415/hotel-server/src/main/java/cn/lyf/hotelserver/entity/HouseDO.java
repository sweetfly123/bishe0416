package cn.lyf.hotelserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDO {
    private Integer Id;
    private String hotelName;
    private String hotelDescribe;
    private String hotelProvide;
    private String hotelPicturePath;
    private String hotelAddress;
    private Integer siteId;
    private String siteName;
    private String evaluate;
    private List<String> pictures;
}
