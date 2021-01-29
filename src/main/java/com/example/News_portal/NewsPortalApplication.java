package com.example.News_portal;

import com.example.News_portal.models.News;
import com.example.News_portal.models.dto.AdminDTO;
import com.example.News_portal.services.AdminService;
import com.example.News_portal.services.DTOConverterService;
import com.example.News_portal.services.NewsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

		@Override
		public void run(String...args) throws Exception {

		}
	}
	@Bean
	AdminService adminServic(){return new AdminService();}
	@Bean
	@Primary
	DTOConverterService dtoConverterServic(){return new DTOConverterService();}
    @Bean
	NewsService newsServic(){return new NewsService();}
	@Bean
	ApplicationRunner applicationRunner(NewsService newsService, AdminService adminService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			try {
				AdminDTO admin = new AdminDTO("admin","admin1234");
				adminService.save(admin);
				InputStream inputStream = TypeReference.class.getResourceAsStream("/json/news.json");
				List<News> news = mapper.readValue(inputStream,new TypeReference<List<News>>(){});
				newsService.saveAll(news);
			} catch (IOException e){
				e.printStackTrace();
			}
		};
	}



}
