
package com.idb.evedience.mvc.controller;


import com.idb.evedience.entity.Users;
import com.idb.evedience.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String loginCheck(ModelMap modelMap, HttpServletRequest request){
        
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        Users u = userService.get(userName, password);
        HttpSession session = request.getSession();
        if(u != null){
            session.setAttribute("user_id", u.getUserId());
        }else{
            modelMap.addAttribute("em", "User Not Found, try again");
        }
        
        return "redirect:/";
        
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("user_id") != null){
            session.setAttribute("user_id", null);
        }
        return "index";
    }
    
}
