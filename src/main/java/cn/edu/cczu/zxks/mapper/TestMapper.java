package cn.edu.cczu.zxks.mapper;

import cn.edu.cczu.zxks.entity.Student;
import cn.edu.cczu.zxks.entity.Test;
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
public interface TestMapper extends BaseMapper<Test> {

    public IPage<Test> selectList(Page<Test> page, @Param("test") Test test);

    public Test selectById(@Param("id") Long id);

    public List<Test> selectTestList(@Param("studentId")Long studentId,@Param("time")String time);

}
