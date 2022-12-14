/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
/**
 *
 * @author ad
 */
@SpringBootApplication(scanBasePackages = "Controller")
@EntityScan("Entities")
@EnableJpaRepositories("Repository")
public class SpringbootApplication {

	public static void main(String[] args) {
            SpringApplication.run(SpringbootApplication.class, args);  
	}

}
