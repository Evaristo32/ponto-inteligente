package br.com.pontointeligente.config;

import br.com.pontointeligente.util.ConstantSwagger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
   private Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);

    @Bean
    public Docket api() {
        this.logger.info("Iniciando Swagger");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(ConstantSwagger.PACOTE_DAS_CONTROLES))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        this.logger.info("Configurando documentação do Swagger");
        return new ApiInfo(
                ConstantSwagger.NOME_DA_APLICACAO,
                ConstantSwagger.DESCRICAO_DA_APLICACAO,
                ConstantSwagger.VERSAO_DA_APLICACAO,
                ConstantSwagger.TERMOS_DE_SERVICO,
                new Contact(ConstantSwagger.NOME_DA_APLICACAO, ConstantSwagger.EMAIL_DE_EXEMPLO, ConstantSwagger.EMAIL_DA_APLICACAO),
                ConstantSwagger.LICENSE_OF_API, ConstantSwagger.URL_DA_API, Collections.emptyList());
    }
}
