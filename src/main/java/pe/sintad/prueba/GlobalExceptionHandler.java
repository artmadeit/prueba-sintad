package pe.sintad.prueba;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Problem> handleIllegalArgument(IllegalArgumentException ex) {
        var problem = Problem.builder()
            .withDetail(ex.getMessage())
            .withTitle("Error argumento invalido")
            .withStatus(Status.BAD_REQUEST)
            .build();

        return new ResponseEntity<>(problem, HttpStatus.valueOf(Status.BAD_REQUEST.getStatusCode()));
    }
}
