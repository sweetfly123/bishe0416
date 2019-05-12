package cn.lyf.hotelserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer siteId;
    private Integer hotelId;
    private Integer foodId;
    private String context;
    private Integer userId;
    private String userName;
    private Integer evaluate;
}
