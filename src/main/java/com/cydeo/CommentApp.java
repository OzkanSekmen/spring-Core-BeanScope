package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {


        Comment comment = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);
        CommentService cs1 = context.getBean(CommentService.class);
        CommentService cs2 = context.getBean(CommentService.class);
// While @Scope("singleton") top on the CommentService:
 //       System.out.println(cs1);    //com.cydeo.service.CommentService@52719fb6
 //       System.out.println(cs2);    //com.cydeo.service.CommentService@52719fb6  (both of them same)
 //       System.out.println(cs1==cs2); // true ( an example for singleton)

// While @Scope("prototype") top on the CommentService:(both of them different object in the container)
        System.out.println(cs1);    //com.cydeo.service.CommentService@738dc9b
        System.out.println(cs2);    //com.cydeo.service.CommentService@3c77d488
        System.out.println(cs1==cs2); // false  ( an example for prototype)

    }
}
