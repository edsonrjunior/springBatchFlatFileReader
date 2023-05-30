package br.com.edsonrjunior.springBatchDelimitedFileReader.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class FileJobConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Qualifier("jobConfig")
    @Bean
    public Job jobConfig(
            @Qualifier("itemReaderStep") Step itemReaderStep,
            @Qualifier("jsonItemReaderStep") Step jsonReaderStep) {

        return jobBuilderFactory
                .get("jobConfig")
                .start(itemReaderStep)
                .next(jsonReaderStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

}
