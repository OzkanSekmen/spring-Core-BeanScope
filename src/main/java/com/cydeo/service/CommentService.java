package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository;                  //always will be final (for don't mistake)
    private final CommentNotificationProxy commentNotificationProxy;    //always will be final


    //we have to Constructor for the @Autowired (that way it will be automatically)
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){

        //save  in the DB
        commentRepository.storeComment(comment);

        //send email
        commentNotificationProxy.sendComment(comment);


    }
}
