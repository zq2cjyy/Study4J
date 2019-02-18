package luzq.std.jstd.spbt.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ErrorAdvice {
    @ExceptionHandler()
    @ResponseBody
    public String procError(HttpServletRequest request, HttpServletResponse response, Exception e) {
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        System.out.println(e.getMessage());
        return e.getMessage();
    }
}
