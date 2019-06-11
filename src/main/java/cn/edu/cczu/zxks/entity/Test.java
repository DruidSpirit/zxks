package cn.edu.cczu.zxks.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jjc
 * @since 2019-05-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_test")
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 试卷ID
     */
    @TableId(value = "test_id", type = IdType.AUTO)
    private Long testId;

    /**
     * 试卷大标题
     */
    @TableField("test_title")
    private String testTitle;

    /**
     * 试卷开始时间
     */
    @TableField("test_starttime")
    private String testStarttime;

    /**
     * 试卷结束时间
     */
    @TableField("test_endtime")
    private String testEndtime;

    /**
     * 试卷学科外键
     */
    @TableField("test_subject")
    private Long testSubject;

    /**
     * 试卷老师外键
     */
    @TableField("test_teacher")
    private Long testTeacher;

    /**
     * 试卷班级
     */
    @TableField("test_class")
    private Long testClass;

    /**
     * 试卷状态
     */
    @TableField("test_state")
    private Integer testState;

    private String testTeacher1;
    private String testSubject1;
    private String testClass1;




}
