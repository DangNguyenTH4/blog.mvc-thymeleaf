package dangnt.thymeleaf.templateutils.impl;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.StringTemplateResolver;

//@Component(value = "ThymeleafStringTemplateService")
public class ThymeleafStringTemplateService extends ThymeleafTemplate {
  private TemplateEngine templateEngine;
  public ThymeleafStringTemplateService(){
    templateEngine = buildTemplateEngine();
  }
  private TemplateEngine buildTemplateEngine() {
    final SpringTemplateEngine initTemplateEngine = new SpringTemplateEngine();
    initTemplateEngine.addTemplateResolver(stringTemplateResolver());
    return initTemplateEngine;
  }
  private ITemplateResolver stringTemplateResolver() {
    final StringTemplateResolver templateResolver = new StringTemplateResolver();
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setCacheable(false);
    return templateResolver;
  }
  @Override
  public TemplateEngine getTemplateEngine() {
    return this.templateEngine;
  }
}
