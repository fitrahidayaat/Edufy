package com.kelompok7;





import com.kelompok7.Model.Student;
import com.kelompok7.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EdufyApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EdufyApplication.class, args);
	}
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("mail","mail@gmail.com","1234",5);
//		studentRepository.save(student1);
	}
}
