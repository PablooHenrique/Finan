package br.com.fornow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fornow.domain.DemoDomain;

@SpringBootApplication
@RestController
public class Demo {
	
	@GetMapping("/")
	public String home(){
		return new DemoDomain().getNome();
	}
	
	public static void main(String[] args) {
        SpringApplication.run(Demo.class, args);
    }
}
