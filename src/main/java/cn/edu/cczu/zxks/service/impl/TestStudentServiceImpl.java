package cn.edu.cczu.zxks.service.impl;

import cn.edu.cczu.zxks.entity.TestStudent;
import cn.edu.cczu.zxks.mapper.TestStudentMapper;
import cn.edu.cczu.zxks.service.ITestStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjc
 * @since 2019-05-21
 */
@Service
public class TestStudentServiceImpl extends ServiceImpl<TestStudentMapper, TestStudent> implements ITestStudentService {

    @Resource
    private TestStudentMapper testStudentMapper;
    public int updateTesStu(@Param("studentId") Long studentId, @Param("testId") Long testId){
        return testStudentMapper.updateTesStu(studentId, testId);
    }
}
