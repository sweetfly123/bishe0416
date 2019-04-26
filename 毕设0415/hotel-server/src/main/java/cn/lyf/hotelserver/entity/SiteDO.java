package cn.lyf.hotelserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 景点实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteDO {
    private Integer id;
    private String siteName;
    private String siteDescribe;
    private String siteAddress;
    private String visitTimes;
    private String sitePicturePath;
    private String status;
    private List<String> pictures;
}
