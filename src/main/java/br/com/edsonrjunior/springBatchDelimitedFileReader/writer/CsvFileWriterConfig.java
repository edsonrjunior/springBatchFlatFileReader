package br.com.edsonrjunior.SpringBatchDelimitedFileReader.writer;

import br.com.edsonrjunior.SpringBatchDelimitedFileReader.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

@Configuration
public class CsvFileWriterConfig {

    @Primary
    @StepScope
    @Bean
    public FlatFileItemWriter<Cliente> delimitedFlatFileWriter(
            @Value("#{jobParameters['arquivoClientesSaida']}") Resource arquivoClientesSaida
    ){
        return new FlatFileItemWriterBuilder<Cliente>()
                .name("delimitedFlatFileWriter")
                .resource(arquivoClientesSaida)
//                .resource(new ClassPathResource("files/saida.csv"))
                .delimited()
                .delimiter(";")
                .names("id", "agencia", "conta", "dac")
                .build();
    }

}
