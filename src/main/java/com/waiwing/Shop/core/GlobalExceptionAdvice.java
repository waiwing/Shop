package com.waiwing.Shop.core;

import com.waiwing.Shop.core.configuration.ExceptionCodeConfiguration;
import com.waiwing.Shop.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 *
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration exceptionCodeConfiguration;

    /**
     * 处理未知异常
     *
     * @param httpServletRequest
     * @param e
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest httpServletRequest, Exception e) {
        System.out.println(e);
        UnifyResponse message = new UnifyResponse(9999, "服务器异常请联系管理员", httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());
        return message;
    }


    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest httpServletRequest, HttpException e) {
        UnifyResponse message = new UnifyResponse(e.getCode(), exceptionCodeConfiguration.getMessage(e.getCode()), httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURI());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> responseResponseEntity = new ResponseEntity<UnifyResponse>(message, httpHeaders, httpStatus);

        return responseResponseEntity;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleBeanValidationException(HttpServletRequest httpServletRequest, MethodArgumentNotValidException e) {
        String request = httpServletRequest.getRequestURI();
        String method = httpServletRequest.getMethod();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String message = formatAllErrorsMessage(errors);

        UnifyResponse unifyResponse = new UnifyResponse(10001, message, method + " " + request);

        return unifyResponse;
    }

    private String formatAllErrorsMessage(List<ObjectError> errors) {
        StringBuilder sb = new StringBuilder();
        errors.forEach(error -> {
            sb.append(error.getDefaultMessage()).append(";");
        });
        return sb.toString();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public UnifyResponse handleConstrainException(HttpServletRequest req, ConstraintViolationException e) {
        String request = req.getRequestURI();
        String method = req.getMethod();
//        e.getConstraintViolations().
     return new UnifyResponse(10001,e.getMessage(),request+" "+method);
    }




}
