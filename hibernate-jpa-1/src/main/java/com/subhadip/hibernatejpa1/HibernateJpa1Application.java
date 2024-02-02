package com.subhadip.hibernatejpa1;

import com.subhadip.hibernatejpa1.models.Author;
import com.subhadip.hibernatejpa1.models.Course;
import com.subhadip.hibernatejpa1.models.Section;
import com.subhadip.hibernatejpa1.repository.AuthorRepository;
import com.subhadip.hibernatejpa1.repository.CourseRepository;
import com.subhadip.hibernatejpa1.repository.SectionRepositiory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateJpa1Application {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpa1Application.class, args);
	}

//  // Many-To-Many example
//	@Bean
//	public CommandLineRunner commandLineRunner (AuthorRepository authorRepository, CourseRepository courseRepository){
//		return args -> {
//			var author1 = Author.builder()
//					.name("subhadip")
//					.email("sbhadip@gmail.com")
//					.age(30)
//					.build();
//
//			var course1 = Course.builder()
//					.courseName("course")
//					.description("course description")
//					.build();
//
//			course1.getAuthors().add(author1);
//			author1.getCourses().add(course1);
//
//
//			authorRepository.save(author1);
//			courseRepository.save(course1);
//		};
//	}

	@Bean
	public CommandLineRunner commandLineRunner (SectionRepositiory sectionRepositiory, CourseRepository courseRepository){
		return args -> {

			var course1 = Course.builder()
					.courseName("course")
					.description("course description")
					.build();


			var section1 = Section.builder()
					.sectionNane("section 1")
					.course(course1)
					.build();


			var section2 = Section.builder()
					.sectionNane("section 2")
					.course(course1)
					.build();

			// save course first, so that the id will be available for
			// section1 and section 2
			courseRepository.save(course1);
			sectionRepositiory.save(section1);
			sectionRepositiory.save(section2);



		};
	}

}
