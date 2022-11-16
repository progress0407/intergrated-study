package test.spring.controller;

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
    public String nio() throws InterruptedException {
//        Thread.sleep(2_000L);
        return "ok";
    }

    @GetMapping("/setting-info")
    public String nio_current_setting_info() throws Exception {

        final Method method = Thread.class.getDeclaredMethod("getThreads");
        method.setAccessible(true);
        final Thread[] ths = (Thread[]) method.invoke(null);

        final List<String> thStrs = Stream.of(ths)
                .map(th -> th.getName())
                .filter(name -> name.contains("nio") && name.contains("exec"))
                .collect(toList());

        return thStrs.toString();
    }
}
