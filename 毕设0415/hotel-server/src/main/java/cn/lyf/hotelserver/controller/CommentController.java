package cn.lyf.hotelserver.controller;

import cn.lyf.hotelserver.entity.Comment;
import cn.lyf.hotelserver.entity.SiteDO;
import cn.lyf.hotelserver.service.CommentService;
import cn.lyf.hotelserver.service.SiteService;
import cn.lyf.hotelserver.util.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/{type}/{Id}",method = RequestMethod.GET)
    public List<Comment> listCommentBySite(@PathVariable("Id") Integer Id,@PathVariable("type") String type){
        return commentService.findAllComment(Id,type);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addComment( String context,Integer Id,String type,Integer userId,Integer grade){
        Comment comment = new Comment();
        comment.setContext(context);
        comment.setUserId(userId);
        comment.setEvaluate(grade);
        switch (type){
            case "site": comment.setSiteId(Id);
                break;
            case "hotel": comment.setHotelId(Id);
                break;
            case "food": comment.setFoodId(Id);
                break;
        }
        commentService.addComment(comment);
        return "评论成功";
    }
}
