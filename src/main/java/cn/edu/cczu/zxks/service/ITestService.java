package cn.edu.cczu.zxks.service;

import cn.edu.cczu.zxks.entity.Test;
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
public interface ITestService extends IService<Test> {
    public IPage<Test> selectList(Page<Test> page, @Param("test") Test test);
    public Test selectById(@Param("id") Long id);
    public List<Test> selectTestList(@Param("id")Long studentId,@Param("time")String time);

}
