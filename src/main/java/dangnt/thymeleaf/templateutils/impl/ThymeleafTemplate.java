package dangnt.thymeleaf.templateutils.impl;

import dangnt.thymeleaf.templateutils.TemplateService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

public abstract class ThymeleafTemplate implements TemplateService {
  public abstract TemplateEngine getTemplateEngine();
  @Override
  public String merge(String template, Context context){
    return getTemplateEngine().process(template, context);
  }

}
