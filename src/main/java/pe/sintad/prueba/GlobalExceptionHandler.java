package pe.sintad.prueba;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.security.AuthenticationAdviceTrait;

import lombok.AllArgsConstructor;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler implements AuthenticationAdviceTrait {
    final MessageSource messageSource;

    // @ExceptionHandler(OuracademyException.class)
    // public ResponseEntity<Problem> handleIllegalArgument(OuracademyException ex, Locale locale) {
    //     var problem = Problem.builder()
    //         .withDetail(ex.getCode())
    //         .withTitle(ex.getTitle())
    //         .withType(ex.getType())
    //         .withStatus(ex.getStatus())
    //         .with("args", ex.getArgs())
    //         .build();

    //     return new ResponseEntity<>(problem, HttpStatus.valueOf(ex.getStatus().getStatusCode()));
    // }
}
