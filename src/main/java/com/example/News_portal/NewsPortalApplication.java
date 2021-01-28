package com.example.News_portal;

import com.example.News_portal.models.Admin;
import com.example.News_portal.repositories.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class NewsPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsPortalApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}


	@Component
	public class CommandLineAppStartupRunner implements CommandLineRunner {
		@Autowired
		AdminRepository adminRepository;

		@Override
		public void run(String...args) throws Exception {
			Admin admin = new Admin("admin","admin");
			adminRepository.save(admin);
		}
	}



}
