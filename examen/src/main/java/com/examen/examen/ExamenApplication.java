package com.examen.examen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class ExamenApplication {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
	}
	
	public void run(String...args) {
		
		String sql = "create table users (id int auto_increment primary key, "
				+ "nombre varchar(55) not null, "
				+ "email varchar(55) unique)";
				
		int result = jdbcTemplate.update(sql, "1", "usuario1", "usuario1@gmail.com");
		
		System.out.println(result);
		
	}

}
