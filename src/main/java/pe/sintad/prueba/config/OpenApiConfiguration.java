package pe.sintad.prueba.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(//
        title = "API Prueba técnica", //
        description = "Contiene las API REST para de la prueba técnica de SINTAD", contact = @Contact(//
                email = "amd11dot4@gmail.com", //
                name = "Arthur Mauricio"//
        )), //
        servers = { //
                @Server(url = "http://localhost:8080", description = "Local"),
                @Server(url = "http://api.algo.com", description = "Production"),
        })
public class OpenApiConfiguration {

}
