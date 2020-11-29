package dangnt.thymeleaf;

import dangnt.thymeleaf.object.model.PostEntity;
import dangnt.thymeleaf.object.model.SubjectEntity;
import dangnt.thymeleaf.object.model.SubjectPostEntity;
import dangnt.thymeleaf.object.model.SubjectPostKey;
import dangnt.thymeleaf.repository.PostRepository;
import dangnt.thymeleaf.repository.SubjectPostRepository;
import dangnt.thymeleaf.repository.SubjectRepository;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.CollectionUtils;

@SpringBootApplication
@EnableScheduling
public class DangntApplication implements CommandLineRunner {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private SubjectPostRepository subjectPostRepository;

	public static void main(String[] args) {
		SpringApplication.run(DangntApplication.class, args);
	}

	@Value("${domainName}")
	private String domainName;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(domainName);
//		PostEntity entity = new PostEntity();
//		entity.setContent("Hello me");
//		entity.setLanguage("Viet name");
//		entity.setTitle("Hello");
////		entity.setSubjectPost(Arrays.asList(new SubjectPostEntity()));
//
//		postRepository.save(entity);
//
//		List<SubjectEntity> list = subjectRepository.findAll();
//
//		SubjectEntity subjectEntity = new SubjectEntity();
////		subjectEntity.setArticles(Collections.singletonList(entity));
//		subjectEntity.setName("TEST");
//		subjectRepository.save(subjectEntity);
//
//		SubjectPostEntity subjectPostEntity = new SubjectPostEntity(
//				new SubjectPostKey(subjectEntity.getId(), entity.getId()), subjectEntity, entity);
////		SubjectPostEntity subjectPostEntity = new SubjectPostEntity(
////				new SubjectPostKey(subjectEntity.getId(), entity.getId()));
//		subjectPostRepository.save(subjectPostEntity);
//		return;
	}
}
