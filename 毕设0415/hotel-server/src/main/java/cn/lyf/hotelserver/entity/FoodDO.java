package cn.lyf.hotelserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDO {
    private Integer Id;
    private String foodName;
    private String foodDescribe;
    private String foodPrice;
    private String foodPicturePath;
    private String foodAddress;
    private Integer siteId;
    private String siteName;
    private List<String> pictures;
}
