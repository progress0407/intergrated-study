package skeleton.code.schedule;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class SchedulerConfig implements SchedulingConfigurer {

    /**
     *     private final int POOL_SIZE = 10;
     *
     *     @Override
     *     public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
     *         final ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
     *         threadPoolTaskScheduler.setPoolSize(POOL_SIZE);
     *         threadPoolTaskScheduler.setThreadNamePrefix("test-scheduled-task-pool-");
     *         threadPoolTaskScheduler.initialize();
     *
     *         taskRegistrar.setTaskScheduler(threadPoolTaskScheduler);
     *     }
     */

    @Override
    public void configureTasks(final ScheduledTaskRegistrar taskRegistrar) {
        final ThreadPoolTaskScheduler threadPoolScheduler = new ThreadPoolTaskScheduler();
        threadPoolScheduler.setPoolSize(1);
        threadPoolScheduler.setThreadNamePrefix("Philz's Schedule Thread");
        threadPoolScheduler.initialize();

        taskRegistrar.setTaskScheduler(threadPoolScheduler);
    }
}
