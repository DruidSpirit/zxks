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
@TableName("tb_exam")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 做完试卷ID
     */
    @TableId(value = "exam_id", type = IdType.AUTO)
    private Long examId;

    /**
     * 试卷外键
     */
    @TableField("exam_test")
    private Long examTest;

    /**
     * 问题外键
     */
    @TableField("exam_question")
    private Long examQuestion;

    /**
     * 学生外键
     */
    @TableField("exam_student")
    private Long examStudent;

    /**
     * 学生答案
     */
    @TableField("exam_answer")
    private String examAnswer;

    /**
     * 这道题的分数
     */
    @TableField("exam_score")
    private Integer examScore;


}
