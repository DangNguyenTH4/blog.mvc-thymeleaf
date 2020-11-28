package dangnt.thymeleaf;

import dangnt.thymeleaf.object.model.PostEntity;
import dangnt.thymeleaf.repository.PostRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DangntApplication implements CommandLineRunner {
	@Autowired
	private PostRepository postRepository;
	public static void main(String[] args) {
		SpringApplication.run(DangntApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		PostEntity entity = new PostEntity();
//		entity.setContent("Hello me");
//		entity.setLanguage("Viet name");
//		entity.setTitle("Hello");
////		entity.setId(1111L);
//		postRepository.save(entity);
//		Optional<PostEntity> e = postRepository.findById(10L);
//		entity = e.get();
//		entity.setTitle("Changed");
//		postRepository.save(entity);
	}
}
