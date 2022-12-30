package test.spring.nio.controller;

import static java.util.stream.Collectors.toList;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/nio")
@RestController
public class NioController {

    @GetMapping("/req")
    public String nio() throws Exception {
        Thread.sleep(1_000L);

        final Method method = Thread.class.getDeclaredMethod("getThreads");
        method.setAccessible(true);
        final Thread[] threads = (Thread[]) method.invoke(null);

        final List<String> threadNames = Stream.of(threads)
                .map(Thread::getName)
                .filter(name -> name.contains("nio") && name.contains("exec"))
                .collect(toList());

        return threadNames.toString();
    }
}
