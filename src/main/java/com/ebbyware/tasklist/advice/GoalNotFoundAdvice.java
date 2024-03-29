package com.ebbyware.tasklist.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ebbyware.tasklist.error.GoalNotFoundException;

@ControllerAdvice
class GoalNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(GoalNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String goalNotFoundHandler(GoalNotFoundException ex) {
    return ex.getMessage();
  }
}