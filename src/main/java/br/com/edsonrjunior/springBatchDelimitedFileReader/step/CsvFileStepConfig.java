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
public class CsvFileStepConfig {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Qualifier("itemReaderStep")
    @Bean
    public Step itemReaderStep(
            ItemReader<Cliente> delimitedFlatFileReader,
            ItemWriter<Cliente> delimitedFlatFileWriter) {

        return  stepBuilderFactory
                .get("itemReaderStep")
                .<Cliente, Cliente>chunk(5)
                .reader(delimitedFlatFileReader)
                .writer(delimitedFlatFileWriter)
                .build();
    }
}
