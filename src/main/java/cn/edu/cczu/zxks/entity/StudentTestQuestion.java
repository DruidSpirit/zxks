package cn.edu.cczu.zxks.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2019-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_student_test_question")
public class StudentTestQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private Long id;

    @TableField("test_id")
    private Long testId;

    @TableField("question_id")
    private Long questionId;

    @TableField("answer")
    private String answer;

    @TableField("question_sorce")
    private Integer questionSorce;

    @TableField("student_id")
    private Long studentId;

    @TableField("student_test_question_state")
    private Integer studentTestQuestionState;


}
