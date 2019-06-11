package cn.edu.cczu.zxks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.edu.cczu.zxks.mapper")
public class ZxksApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZxksApplication.class, args);
    }

}
