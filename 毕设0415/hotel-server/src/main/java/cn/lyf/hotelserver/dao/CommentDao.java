package cn.lyf.hotelserver.dao;

import cn.lyf.hotelserver.entity.Comment;
import cn.lyf.hotelserver.entity.HotelDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Title: HotelDao
 * @Param: * @param null
 * @Description: hotelDao层接口
 * @author: DIC.sweetlfy
 * @date: 2018/11/19 9:43
 * @version: V1.0
 */
@Repository
public interface CommentDao {
    int addComment(Comment comment);

    List<Comment> findAllComment(@Param("siteId") Integer siteId, @Param("hotelId") Integer hotelId, @Param("foodId") Integer foodId);
}
