package cn.edu.cczu.zxks.service;

import cn.edu.cczu.zxks.entity.Question;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jjc
 * @since 2019-05-09
 */
public interface IQuestionService extends IService<Question> {
    public IPage<Question> selectList(Page<Question> page, @Param("question") Question question);
    public List<Question> selectXuanZe(@Param("pageSize1") Integer pageSize1, @Param("subjectId")Long subjectId);
    public List<Question> selectTianKong(@Param("pageSize2") Integer pageSize2,@Param("subjectId")Long subjectId);
    public List<Question> selectoptList(@Param("testId") Long testId);

}
