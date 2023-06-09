package br.com.edsonrjunior.SpringBatchDelimitedFileReader.step;

import br.com.edsonrjunior.SpringBatchDelimitedFileReader.domain.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JsonFileStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Qualifier("jsonItemReaderStep")
    @Bean
    public Step jsonItemReaderStep(
            ItemReader<Cliente> jsonFileReader,
            ItemWriter<Cliente> jsonFileWriter) {

        return stepBuilderFactory
                .get("jsonItemReaderStep")
                .<Cliente, Cliente>chunk(5)
                .reader(jsonFileReader)
                .writer(jsonFileWriter)
                .build();
    }
}
