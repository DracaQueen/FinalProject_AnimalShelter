package com.careshelter.errorhandler;

import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {
  
  private enum LogStatus {
    STACK_TRACE, MESSAGE_ONLY
  }

  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public Map<String, Object> handleNoSuchElementException(
      NoSuchElementException e, WebRequest webRequest) {
    return createExceptionMessage(e, HttpStatus.NOT_FOUND, webRequest, 
        LogStatus.MESSAGE_ONLY);
  }

  private Map<String, Object> createExceptionMessage(NoSuchElementException e, HttpStatus notFound,
      WebRequest webRequest, LogStatus messageOnly) {
    // TODO Auto-generated method stub
    return null;
  }
}
