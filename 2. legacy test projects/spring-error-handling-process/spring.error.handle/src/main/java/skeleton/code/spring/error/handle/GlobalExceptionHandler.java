package skeleton.code.spring.error.handle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGlobalEx(Exception ex) {
//        log.info("#error ! ", ex);
        log.error("#error ! ", ex);
        throw new RuntimeException();
//        return new ErrorResponse(ex.getMessage());
    }

    @RequiredArgsConstructor
    @Getter
    public static class ErrorResponse {
        private final String field;
    }
}
