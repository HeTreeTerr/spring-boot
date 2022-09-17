package com.itcast.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

/**
 * SpringMvc的异步处理
 */
@RestController
public class AsyncController {

    @Qualifier(value = "myExecutorService")
    @Autowired
    private ExecutorService executorService;

    @GetMapping(value = "/business")
    public DeferredResult asyncBusiness(HttpServletRequest request, HttpServletResponse response){
        System.out.println(LocalDateTime.now().toString() + "--->主线程("+Thread.currentThread().getName()+")开始");
        /**
         * 主线程执行完直接结束，直到子线程执行完毕，才将结果返回
         */
        DeferredResult<String> deferredResult = new DeferredResult<>(5000L,"处理超时，返回列表重试！");
        CompletableFuture.supplyAsync(()-> doBusiness(request,response), executorService).whenCompleteAsync((result, throwable)->{
            if (throwable!=null) {
                deferredResult.setErrorResult(throwable.getMessage());
            }else {
                deferredResult.setResult(result);
            }
        });
        // 异步请求超时时调用
        deferredResult.onTimeout(()->{
            System.out.println(LocalDateTime.now().toString() + "--->onTimeout");
        });
        // 异步请求完成后调用
        deferredResult.onCompletion(()->{
            System.out.println(LocalDateTime.now().toString() + "--->onCompletion");
        });
        System.out.println(LocalDateTime.now().toString() + "--->主线程("+Thread.currentThread().getName()+")结束");
        return deferredResult;
    }

    /**
     * 执行业务逻辑
     * @param request
     * @param response
     * @return
     */
    private String doBusiness(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(LocalDateTime.now().toString() + "--->副线程("+Thread.currentThread().getName()+")开始");

        try {
            System.out.println("核心逻辑执行！！！");
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(LocalDateTime.now().toString() + "--->副线程("+Thread.currentThread().getName()+")结束");
        return "business handle success";
    }
}
