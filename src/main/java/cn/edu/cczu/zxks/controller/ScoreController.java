package cn.edu.cczu.zxks.controller;


import cn.edu.cczu.zxks.entity.Score;
import cn.edu.cczu.zxks.entity.ScorePram;
import cn.edu.cczu.zxks.entity.Student;
import cn.edu.cczu.zxks.entity.Teacher;
import cn.edu.cczu.zxks.service.IClassTeacherService;
import cn.edu.cczu.zxks.service.IScoreService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    private IScoreService scoreService;
    @Autowired
    private IClassTeacherService classTeacherService;

    @RequestMapping("/selectScore")
    public String selectScore(HttpSession session, Model model){
        Student student=(Student) session.getAttribute("student");
        List<Score> stuscoreList= scoreService.selectScore(student.getStudentId());
        model.addAttribute("stuscoreList", stuscoreList);

        return "studentscore";
    }

    /**
     * 老师查询score
     * */
    @RequestMapping("/selectList")
    public String selectList(@RequestParam(value = "current",defaultValue = "1",required = false)Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "2",required = false)Integer pageSize,
                             ScorePram scorePram, Model model,HttpSession session){
        Teacher teacher=(Teacher) session.getAttribute("teacher");
        scorePram.setTeacherSubject(teacher.getTeacherSubject());
        scorePram.setTeacherId(teacher.getTeacherId());


        if("null".equals(scorePram.getStudentRealname())){
            scorePram.setStudentRealname(null);
        }
        if("null".equals(scorePram.getStudentClass())){
            scorePram.setStudentClass(0L);
        }if("null".equals(scorePram.getStudentAccount())){
            scorePram.setStudentAccount(null);
        }

        List classList=classTeacherService.selecClassByteacher(teacher.getTeacherId());

        Page page=new Page<>(current,pageSize);
        IPage scoList= scoreService.selectList(page,scorePram);
        model.addAttribute("scoList",scoList);
        model.addAttribute("current",current);

        model.addAttribute("scorePram",scorePram);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("classList",classList);

        return "teacherclassscore";
    }

}
