package br.com.edsonrjunior.springBatchDelimitedFileReader.reader;

import br.com.edsonrjunior.springBatchDelimitedFileReader.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class JsonFileReaderConfig {

    @Qualifier("jsonFileItemWriter")
    @StepScope
    @Bean
   // @Primary
    public JsonItemReader<Cliente> jsonItemReader(

            @Value("#{jobParameters['arquivoClientesJson']}") Resource arquivoClientes

    ) {
        return new JsonItemReaderBuilder<Cliente>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(Cliente.class))
                .resource(arquivoClientes)
                .name("jsonItemReader")
                .build();
    }

}
