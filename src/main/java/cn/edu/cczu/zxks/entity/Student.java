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
@TableName("tb_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 学生ID
     */
    @TableId(value = "student_id", type = IdType.AUTO)
    private Long studentId;

    /**
     * 学生账号
     */
    @TableField("student_account")
    private String studentAccount;

    /**
     * 学生密码
     */
    @TableField("student_password")
    private String studentPassword;

    /**
     * 学生真实姓名
     */
    @TableField("student_realname")
    private String studentRealname;

    /**
     * 学生年龄
     */
    @TableField("student_age")
    private Integer studentAge;

    /**
     * 学生班级外键
     */
    @TableField("student_class")
    private Long studentClass;

    /**
     * 学生状态
     */
    @TableField("student_state")
    private Integer studentState;


}
