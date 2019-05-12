package cn.lyf.hotelserver.service.Impl;

import cn.lyf.hotelserver.dao.CommentDao;
import cn.lyf.hotelserver.entity.Comment;
import cn.lyf.hotelserver.entity.SiteDO;
import cn.lyf.hotelserver.service.CommentService;
import cn.lyf.hotelserver.service.SiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Resource
    private SiteService siteService;


    @Override
    public int addComment(Comment comment) {
        SiteDO site = siteService.getSiteById(comment.getSiteId());
        DecimalFormat df = new DecimalFormat("######0.0");
        double tmp = (Double.parseDouble(site.getSiteGrade()) + comment.getEvaluate()) / 2;
        String grade = String.valueOf(df.format(tmp));
        site.setSiteGrade(grade);
        siteService.updateSite(site);
        return commentDao.addComment(comment);
    }

    @Override
    public List<Comment> findAllComment(Integer Id, String type) {
        List<Comment> list = new ArrayList<>();
        switch (type) {
            case "site":
                list = commentDao.findAllComment(Id, 0, 0);
                break;
            case "hotel":
                list = commentDao.findAllComment(0, Id, 0);
                break;
            case "food":
                list = commentDao.findAllComment(0, 0, Id);
                break;
        }
        return list;
    }
}
