package cn.edu.cczu.zxks.service.impl;

import cn.edu.cczu.zxks.entity.Question;
import cn.edu.cczu.zxks.mapper.QuestionMapper;
import cn.edu.cczu.zxks.service.IQuestionService;
import cn.edu.cczu.zxks.service.ITestQuestionService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjc
 * @since 2019-05-09
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {
    @Resource
    private QuestionMapper questionMapper;





    public IPage<Question> selectList(Page<Question> page, @Param("question") Question question){
       return questionMapper.selectList(page,question);
    }

    public List<Question> selectXuanZe(@Param("pageSize1") Integer pageSize1, @Param("subjectId")Long subjectId){
        return  questionMapper.selectXuanZe(pageSize1,subjectId);
    }
    public List<Question> selectTianKong(Integer pageSize2,Long subjectId){
        return questionMapper.selectTianKong(pageSize2,subjectId);
    }
    public List<Question> selectoptList(@Param("testId") Long testId){
        return questionMapper.selectoptList(testId);

    }

}
