package spring.argument.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
@Slf4j
class ArgumentResolverErrorHandler {

    @ExceptionHandler(Exception.class)
    public void handleEx(Exception exception) {
        log.error("exception, ", exception);
    }
}
