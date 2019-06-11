package cn.edu.cczu.zxks.controller;


import cn.edu.cczu.zxks.entity.Admin;
import cn.edu.cczu.zxks.entity.Student;
import cn.edu.cczu.zxks.service.IAdminService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2019-05-09
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @RequestMapping("/goIndex")
    public String index(){
        return "index";
    }

    @RequestMapping("/gowelcome")
    public String gowelcome(){
        return "welcome";
    }

    @RequestMapping("/selectList")
    public  String selectList(Model model){
        List list =adminService.list(new QueryWrapper<Admin>().eq("admin_state","0"));
        model.addAttribute("admList",list);
        return "admin";
    }

    @RequestMapping("/insert")
    public String insert(){
        return "addadmin";
    }

    @RequestMapping("/insertload")
    public  String insertload(Admin admin){
        admin.setAdminPassword("123456");
        admin.setAdminState("0");
        adminService.save(admin);
        return "redirect:/admin/selectList";
    }
    @RequestMapping("/deleteAdm")
    public String deleteAdm(@RequestParam("id") String id){
        Admin admin=new Admin();
        admin.setAdminState("1");
        admin.setAdminId(Long.parseLong(id));
        adminService.updateById(admin);
        return "redirect:/admin/selectList";
    }
    @RequestMapping("/updateAdm")
    public String updateAdm(String id,Model model){
        Admin admin=adminService.getById(Long.parseLong(id));
        model.addAttribute("adm",admin);
        return "updateadmin";
    }
    @RequestMapping("/updateStuBefor")
    public String updateStuBefor(Admin admin){
        adminService.updateById(admin);
        return "redirect:/admin/selectList";
    }

    @RequestMapping("/updatePwd")
    public String updatePwd(HttpSession session ,Model model){
        Admin admin=(Admin) session.getAttribute("admin");
        model.addAttribute("admin",admin);
        return "updatepwdadm";
    }
    @RequestMapping("/updatePwdAfter")
    public String updatePwdAfter(Admin admin,Model model){
        adminService.updateById(admin);

        return "redirect:/login/logout";
    }






}
