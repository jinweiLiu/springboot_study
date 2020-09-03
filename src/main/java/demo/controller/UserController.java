package demo.controller;

import demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@Controller
public class UserController {
    /**
     * 身份认证测试接口
     * @param request
     * @return
     */
    @RequestMapping("/admin")
    public String admin(Model model, HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        //System.out.println(user.toString());
        model.addAttribute("user",user);
        return "user";
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
     * 手动配置logout
     */
    @RequestMapping("/logout")
    public String logout() {
        //同样是通过实例化subject,进行权限与登录登出的逻辑操作
        //SecurityUtils 是一个抽象类。并且没有任何子类。在其中声明了一个静态属性，三个静态方法。
        //静态属性 securityManager-->用来存储当前应用中全局唯一的一个SecurityManager。
        // getSubject 静态方法-->这个是 Shiro 中最核心的方法了，用来获取 Subject.
        //Subject是Shiro的核心对象，基本所有身份验证、授权都是通过Subject完成
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "redirect:/form";
    }
    /**
     * 用户登录接口
     * @param user user
     * @param request request
     * @return string
     */
    @RequestMapping("/submit")
    public String login(@ModelAttribute User user, HttpServletRequest request) {
        // 根据用户名和密码创建token
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 获取subject认证主体
        Subject subject = SecurityUtils.getSubject();
        try{
            // 开始认证，这一步会跳到我们自定义的realm中
            subject.login(token);
            request.getSession().setAttribute("user", user);
            return "user";
        }catch(Exception e){
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("error", "用户名或密码错误！");
            return "login";
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
