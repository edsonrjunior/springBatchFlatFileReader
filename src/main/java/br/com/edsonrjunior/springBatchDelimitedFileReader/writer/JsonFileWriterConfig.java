package br.com.edsonrjunior.SpringBatchDelimitedFileReader.writer;

import br.com.edsonrjunior.SpringBatchDelimitedFileReader.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class JsonFileWriterConfig {

    @Qualifier("jsonFileItemWriter")
    @StepScope
    @Bean
   // @Primary
    public JsonFileItemWriter<Cliente> jsonFileItemWriter(
            @Value("#{jobParameters['arquivoClientesSaidaJson']}") Resource arquivoClientesSaidaJson
    ){
        return new JsonFileItemWriterBuilder<Cliente>()
                .name("jsonFileItemWriter")
                .jsonObjectMarshaller(new JacksonJsonObjectMarshaller<>())
                .resource(arquivoClientesSaidaJson)
                .build();
    }

}
