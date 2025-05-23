package com.jar100.mssproduct.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {
    @Bean(name = "summaryTaskExecutor")
    public Executor summaryTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 최소  core 스레드 수
        executor.setCorePoolSize(5);
        // 최대 스레드 수
        executor.setMaxPoolSize(20);
        // 대기 큐(capacity) 크기
        executor.setQueueCapacity(500);
        // 스레드 이름 접두어
        executor.setThreadNamePrefix("SummaryExec-");
        executor.initialize();
        return executor;
    }
}
