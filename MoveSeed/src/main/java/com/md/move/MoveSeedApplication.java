package com.md.move;

import com.md.move.config.YmlConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.md.move.dao")
//@EnableConfigurationProperties({YmlConfig.class})
public class MoveSeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoveSeedApplication.class, args);
	}
}
