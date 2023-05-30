package br.com.edsonrjunior.springBatchDelimitedFileReader.reader;

import br.com.edsonrjunior.springBatchDelimitedFileReader.domain.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;

@Configuration
public class CsvFileReaderConfig {

    @Primary
    @StepScope
    @Bean
    public FlatFileItemReader<Cliente> delimitedFlatFileReader(

            @Value("#{jobParameters['arquivoClientes']}") Resource arquivoClientes

    ) {
        return new FlatFileItemReaderBuilder<Cliente>()
                .name("delimitedFlatFileReader")
               // .resource(new ClassPathResource("files/clientes.csv"))
                .resource(arquivoClientes)
                .encoding("UTF-8")
                .delimited()
                .delimiter(";")
                //  .names(new Cliente().getClienteAttributes())
                .names("id", "agencia", "conta", "dac")
                .targetType(Cliente.class)
                .build();
    }

}
