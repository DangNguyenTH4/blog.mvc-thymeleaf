package dangnt.thymeleaf;

import dangnt.thymeleaf.repository.PostRepository;
import dangnt.thymeleaf.repository.SubjectPostRepository;
import dangnt.thymeleaf.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DangntApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(DangntApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}

}
