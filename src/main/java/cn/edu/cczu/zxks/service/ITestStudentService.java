package cn.edu.cczu.zxks.service;

import cn.edu.cczu.zxks.entity.TestStudent;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jjc
 * @since 2019-05-21
 */
public interface ITestStudentService extends IService<TestStudent> {
    public int updateTesStu(@Param("studentId") Long studentId, @Param("testId") Long testId);

}
