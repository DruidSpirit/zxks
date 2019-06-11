package cn.edu.cczu.zxks.service;

import cn.edu.cczu.zxks.entity.Question;
import cn.edu.cczu.zxks.entity.TestQuestion;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jjc
 * @since 2019-05-15
 */
public interface ITestQuestionService extends IService<TestQuestion> {
    public List<Question> selectoptList(@Param("testId") Long testId);
    public List<Question> selecttianList(@Param("testId") Long testId);

}
