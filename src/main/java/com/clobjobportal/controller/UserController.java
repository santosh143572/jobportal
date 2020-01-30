package com.clobjobportal.controller;



import com.clobjobportal.model.User;
import com.clobjobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/post",consumes = "application/json")
    @ResponseBody
    public String save(@RequestBody User user){

        try{
            userService.save(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "ok";
    }


}
