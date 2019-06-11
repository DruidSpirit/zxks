package cn.edu.cczu.zxks.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ScorePram {
    private Long teacherId;
    private Long teacherSubject;
    private Long studentClass;
    private String studentRealname;
    private String studentAccount;


}
