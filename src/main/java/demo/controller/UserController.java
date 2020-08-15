package demo.controller;

import demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    /**
     * 身份认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/admin")
    public String admin(ModelMap map, HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        return "success";
    }

    /**
     * 角色认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/student")
    public String student(HttpServletRequest request) {
        return "success";
    }

    /**
     * 权限认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/teacher")
    public String teacher(HttpServletRequest request) {
        return "success";
    }

    /**
     * 用户登录接口
     * @param user user
     * @param request request
     * @return string
     */
    @ResponseBody
    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpServletRequest request) {

        // 根据用户名和密码创建token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 获取subject认证主体
        Subject subject = SecurityUtils.getSubject();
        try{
            // 开始认证，这一步会跳到我们自定义的realm中
            subject.login(token);
            return "login successfully" + user.toString();
            //request.getSession().setAttribute("user", user);
            //return "index";
        }catch(Exception e){
            e.printStackTrace();
            //request.getSession().setAttribute("user", user);
            //request.setAttribute("error", "用户名或密码错误！");
            //return "login";
            return "login failed";
        }
    }

    /*@ResponseBody
    @RequestMapping(value="/submit",method= RequestMethod.POST)
    public String add(@ModelAttribute User user){
        String username = user.getUsername();
        String password = user.getPassword();
        return username+"__"+password;
    }*/
}
