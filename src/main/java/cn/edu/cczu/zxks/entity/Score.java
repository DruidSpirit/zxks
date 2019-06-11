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
@TableName("tb_score")
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 成绩ID
     */
    @TableId(value = "score_id", type = IdType.AUTO)
    private Long scoreId;

    /**
     * 学生外键
     */
    @TableField("score_student")
    private Long scoreStudent;

    /**
     * 学科外键
     */
    @TableField("score_subject")
    private Long scoreSubject;

    /**
     * 分数
     */
    @TableField("score_score")
    private Integer scoreScore;

    @TableField("score_test")
    private Long score_test;

    private String testTitle;
    private String subjectName;
    private String studentName;
    private String className;


}
