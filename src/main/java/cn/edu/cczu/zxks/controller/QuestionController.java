package cn.edu.cczu.zxks.controller;


import cn.edu.cczu.zxks.entity.Question;
import cn.edu.cczu.zxks.entity.Student;
import cn.edu.cczu.zxks.service.IQuestionService;
import cn.edu.cczu.zxks.service.ISubjectService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;
    @Autowired
    private ISubjectService subjectService;


    @RequestMapping("/selectList")
    public String selectList(@RequestParam(value = "current",defaultValue = "1",required = false)Integer current,
                             @RequestParam(value = "pageSize",defaultValue = "4",required = false)Integer pageSize,
                             Question question, Model model){
        if("null".equals(question.getQuestionName())){
            question.setQuestionName(null);
        }
        if("null".equals(question.getQuestionSubject())){
            question.setQuestionSubject(0L);
        }if("null".equals(question.getQuestionType())){
            question.setQuestionType(0);
        }

        List subList=subjectService.list();

        Page page=new Page<>(current,pageSize);
        IPage queList= questionService.selectList(page,question);
        model.addAttribute("queList",queList);
        model.addAttribute("current",current);

        model.addAttribute("question",question);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("subList",subList);

        return "question";
    }

    /**
     * 删除by Id
     * @param id
     * */
    @RequestMapping("/deleteQue")
    public String deleteById(@RequestParam("id") String id,Question question,Integer current,RedirectAttributes model){
        Question que=new Question();
        que.setQuestionState(1);
        que.setQuestionId(Long.parseLong(id));
        questionService.updateById(que);
        model.addAttribute("current",current);
        model.addAttribute("questionName",question.getQuestionRealanswer());
        model.addAttribute("questionType",question.getQuestionType());
        model.addAttribute("questionSubject",question.getQuestionSubject());
        return "redirect:/question/selectList";
    }

    @RequestMapping("/updateQue")
    public String updateStu(@RequestParam("id") String id,Question question,Integer current,Model model){
        List subjectList=subjectService.list();
        Question question1=questionService.getById(Long.parseLong(id));
        model.addAttribute("que",question1);
        model.addAttribute("subList",subjectList);
        System.out.println(current+"updateStu...............................................");

        model.addAttribute("current",current);
        model.addAttribute("questionName",question.getQuestionRealanswer());
        model.addAttribute("questionType",question.getQuestionType());
        model.addAttribute("questionSubject",question.getQuestionSubject());
        return "updatequestion";
    }

    @RequestMapping("/updateStuBefor")
    public String updateStuBefor(Question question,Integer current,RedirectAttributes model,String Name,String Type,String Subject){
        /*Long subjectId=0L;
        if(!"null".equals(questionSubject)&&null!=questionSubject){
            subjectId=Long.parseLong(questionSubject);
        }*/

        questionService.updateById(question);
        model.addAttribute("current",current);
        model.addAttribute("questionName",Name);
        model.addAttribute("questionType",Type);
        model.addAttribute("questionSubject",Subject);
        return "redirect:/question/selectList";
    }


    @RequestMapping("/insert")
    public String insert(Model model){
        List list=subjectService.list();
        model.addAttribute("subList",list);

        return "addquestion";
    }

    @RequestMapping("/insertload")
    public String insertload(Question question){
        questionService.save(question);

        return "redirect:/question/insert";
    }

}
