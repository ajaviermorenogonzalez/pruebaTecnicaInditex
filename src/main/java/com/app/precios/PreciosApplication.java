package com.app.precios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación para iniciar la ejecución de Spring Boot.
 *
 * <p>La anotación {@link SpringBootApplication} marca esta clase como el punto de entrada de la
 * aplicación Spring Boot, habilitando la configuración automática, el escaneo de componentes y
 * otras funcionalidades proporcionadas por Spring Boot.</p>
 */
@SpringBootApplication
public class PreciosApplication {

  public static void main(String[] args) {
    SpringApplication.run(PreciosApplication.class, args);
  }

}
