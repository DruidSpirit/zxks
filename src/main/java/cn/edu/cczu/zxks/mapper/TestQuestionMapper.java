package cn.edu.cczu.zxks.mapper;

import cn.edu.cczu.zxks.entity.Question;
import cn.edu.cczu.zxks.entity.TestQuestion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jjc
 * @since 2019-05-15
 */
public interface TestQuestionMapper extends BaseMapper<TestQuestion> {
    public List<Question> selectoptList(@Param("testId") Long testId);
    public List<Question> selecttianList(@Param("testId") Long testId);

}
