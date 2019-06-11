package cn.edu.cczu.zxks.mapper;

import cn.edu.cczu.zxks.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jjc
 * @since 2019-05-09
 */
public interface QuestionMapper extends BaseMapper<Question> {

    public IPage<Question> selectList(Page<Question> page, @Param("question") Question question);

    public List<Question> selectXuanZe(@Param("pageSize1") Integer pageSize1,@Param("subjectId")Long subjectId);

    public List<Question> selectTianKong(@Param("pageSize2") Integer pageSize2,@Param("subjectId")Long subjectId);

    public List<Question> selectoptList(@Param("testId") Long testId);

}
