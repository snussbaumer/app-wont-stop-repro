package com.example.repro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReproApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReproApplication.class, args);
    }

    @Bean
    public TestLifeCycle testLifeCycle() {
        return new TestLifeCycle();
    }

    public static class TestLifeCycle implements SmartLifecycle {

        @Override
        public boolean isAutoStartup() {
            return true;
        }

        @Override
        public void stop(Runnable callback) {
            callback.run();
        }

        @Override
        public void start() {
            throw new RuntimeException("Something went wrong");
        }

        @Override
        public void stop() {
        }

        @Override
        public boolean isRunning() {
            return false;
        }

        @Override
        public int getPhase() {
            return Integer.MIN_VALUE;
        }
    }

}
