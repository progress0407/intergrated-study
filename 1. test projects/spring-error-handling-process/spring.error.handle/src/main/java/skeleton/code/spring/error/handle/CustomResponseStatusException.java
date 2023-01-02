package skeleton.code.spring.error.handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PROXY_AUTHENTICATION_REQUIRED)
public class CustomResponseStatusException extends RuntimeException {
}
