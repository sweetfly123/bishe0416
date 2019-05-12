package cn.lyf.hotelserver.service;

import cn.lyf.hotelserver.entity.Comment;

import java.util.List;

public interface CommentService {
    int addComment(Comment comment);
    List<Comment> findAllComment(Integer Id,String type);
}
