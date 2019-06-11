package cn.edu.cczu.zxks.mapper;

import cn.edu.cczu.zxks.entity.TestStudent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jjc
 * @since 2019-05-21
 */
public interface TestStudentMapper extends BaseMapper<TestStudent> {
    public int updateTesStu(@Param("studentId") Long studentId,@Param("testId") Long testId);


}
