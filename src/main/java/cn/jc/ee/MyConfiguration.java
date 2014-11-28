package cn.jc.ee;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class MyConfiguration {

	@Value("${batch.jdbc.driver}")
	private String driverClassName;

	@Value("${batch.jdbc.url}")
	private String driverUrl;

	@Value("${batch.jdbc.user}")
	private String driverUsername;

	@Value("${batch.jdbc.password}")
	private String driverPassword;

	@Autowired
	@Qualifier("jobRepository")
	private JobRepository jobRepository;

	@Bean
	public DataSource dataSource4batch() {
		BasicDataSource dataSource4batch = new BasicDataSource();
		dataSource4batch.setDriverClassName(driverClassName);
		dataSource4batch.setUrl(driverUrl);
		dataSource4batch.setUsername(driverUsername);
		dataSource4batch.setPassword(driverPassword);
		return dataSource4batch;
	}

	@Bean
	public SimpleJobLauncher jobLauncher() {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository);
		return jobLauncher;
	}

	@Bean
	public PlatformTransactionManager transactionManager4batch() {
		return new DataSourceTransactionManager(dataSource4batch());
	}

}
