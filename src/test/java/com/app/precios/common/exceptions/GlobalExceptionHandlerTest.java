package com.app.precios.common.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class GlobalExceptionHandlerTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  void testGlobalExceptionHandlerIsLoaded() {
    // Verifica que el ControllerAdvice esté presente en el contexto de Spring
    assertThat(applicationContext.getBean(GlobalExceptionHandler.class)).isNotNull();
  }
}
