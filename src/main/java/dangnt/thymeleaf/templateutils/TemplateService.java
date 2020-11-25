package dangnt.thymeleaf.templateutils;

import org.thymeleaf.context.Context;

public interface TemplateService {
  String merge(String template, Context context);
}