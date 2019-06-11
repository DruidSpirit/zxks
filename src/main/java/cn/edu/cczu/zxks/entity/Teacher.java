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
 * @since 2019-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Long teacherId;

    /**
     * 账号
     */
    @TableField("teacher_account")
    private String teacherAccount;

    /**
     * 密码
     */
    @TableField("teacher_password")
    private String teacherPassword;

    /**
     * 真实姓名
     */
    @TableField("teacher_realname")
    private String teacherRealname;

    /**
     * 电话
     */
    @TableField("teacher_phone")
    private String teacherPhone;

    /**
     * 状态
     */
    @TableField("teacher_state")
    private Integer teacherState;

    /**
     * 学科外键
     */
    @TableField("teacher_subject")
    private Long teacherSubject;


}
