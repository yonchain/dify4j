package com.dify4j.web.exception;

import com.dify4j.api.exception.Dify4jException;
import com.dify4j.api.exception.Dify4jForbiddenException;
import com.dify4j.api.exception.Dify4jIllegalStateException;
import com.dify4j.api.exception.Dify4jResourceNotFoundException;
import com.dify4j.api.web.ApiErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.stream.Collectors;

/**
 * 全局异常处理器
 *
 * @author Cgy
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 处理资源没找到异常
     */
    @ExceptionHandler(Dify4jResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFoundException(
            Dify4jResourceNotFoundException ex, WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getCode(),
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * 处理禁止访问异常
     */
    @ExceptionHandler(Dify4jForbiddenException.class)
    public ResponseEntity<ApiErrorResponse> handleForbiddenException(
            Dify4jForbiddenException ex, WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.FORBIDDEN.value(),
                ex.getCode(),
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
    }

    /**
     * 非法状态异常类处理
     */
    @ExceptionHandler(Dify4jIllegalStateException.class)
    public ResponseEntity<ApiErrorResponse> handleDify4jIllegalStateException(
            Dify4jIllegalStateException ex, WebRequest request) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getCode(),
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * 处理系统异常
     */
    @ExceptionHandler(Dify4jException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handleDify4jException(Dify4jException ex, WebRequest request) {
        log.info("业务异常: {}", ex.getMessage(), ex);
        return new ApiErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "500",
                ex.getMessage()
        );
    }

    /**
     * 处理参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
        // 获取所有字段校验错误
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> String.format("%s",
                        fieldError.getDefaultMessage()))
                .collect(Collectors.joining("; "));

        log.info("参数校验失败: {}", errorMessage);

        return new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "invalid_parameter",
                errorMessage
        );
    }

    /**
     * 资源未找到异常处理
     */
    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleNoResourceFoundException(
            NoResourceFoundException ex,
            WebRequest request) {
        log.error("资源未找到: {} {}", ex.getHttpMethod(), ex.getResourcePath(), ex.getMessage());

        return new ApiErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "resource_not_found",
                String.format("请求的资源 %s 不存在", ex.getResourcePath())
        );
    }

    /**
     * 处理其他未捕获的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handleGlobalException(Exception ex, WebRequest request) {
        log.error("系统异常: {}", ex.getMessage(), ex);
        return new ApiErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "internal_error",
                "系统内部错误"
        );
    }
}
