package cn.edu.cczu.zxks.service.impl;

import cn.edu.cczu.zxks.entity.Question;
import cn.edu.cczu.zxks.entity.TestQuestion;
import cn.edu.cczu.zxks.mapper.TestQuestionMapper;
import cn.edu.cczu.zxks.service.ITestQuestionService;
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
 * @since 2019-05-15
 */
@Service
public class TestQuestionServiceImpl extends ServiceImpl<TestQuestionMapper, TestQuestion> implements ITestQuestionService {
    @Resource
    private TestQuestionMapper testQuestionMapper;


    public List<Question> selectoptList(@Param("testId") Long testId){
        return testQuestionMapper.selectoptList(testId);

    }
    public List<Question> selecttianList(@Param("testId") Long testId){
        return testQuestionMapper.selecttianList(testId);
    }

}
