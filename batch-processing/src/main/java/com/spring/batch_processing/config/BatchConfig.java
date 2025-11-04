package com.spring.batch_processing.config;


import com.spring.batch_processing.model.Person;
import com.spring.batch_processing.repository.PersonRepository;
import com.spring.batch_processing.util.TextItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private TextItemProcessor processor;

    @Autowired
    private PersonRepository personRepository;



    @Bean
    public FlatFileItemReader<Person> reader(){
        return new FlatFileItemReaderBuilder<Person>()
                .resource(new ClassPathResource("people-1000.csv"))
                .name("csv-reader")
                .lineMapper(lineMapper())
                .linesToSkip(1)
                .targetType(Person.class)
                .build();
    }

    private LineMapper<Person> lineMapper() {
        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("indexValue","userID", "firstName", "lastName", "gender", "email", "phone", "dateOfBirth", "jobTitle");

        BeanWrapperFieldSetMapper<Person> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Person.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    public RepositoryItemWriter<Person> writer(){
        RepositoryItemWriter<Person> writer = new RepositoryItemWriter<>();
        writer.setRepository(personRepository);
        writer.setMethodName("save");
            return writer;
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("step",jobRepository)
                .<Person,Person>chunk(10,transactionManager)
                .reader(reader())
                .processor(processor)
                .writer(writer())
                .build();

    }

    @Bean
    public Job job(JobRepository jobRepository, Step step){
        return new JobBuilder("person-import-job",jobRepository)
                .start(step)
                .build();

    }


}
