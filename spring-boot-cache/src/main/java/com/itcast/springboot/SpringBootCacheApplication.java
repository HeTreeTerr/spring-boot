package com.itcast.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 搭建基本环境
 * 1.导入数据库文件 创建department和employee表
 * 2.创建javabean
 * 3.整合mybatis操作数据库
 *      1.配置数据源
 *      2.使用mybatis（注解）
 *          1）@MapperScan指定需要扫描的mapper接口所在的包
 * 4.快速体验缓存
 *      1.开启基于注解的缓存(@EnableCaching)
 * 		2.标注缓存注解即可
 *
 * 	==@EnableCaching原理：==
 * 	1、进入@EnableCaching注解中可得
 * 	    注解导入了CachingConfigurationSelector类(依据：@Import(CachingConfigurationSelector.class))
 * 	    mode属性得默认值等于AdviceMode.PROXY(依据：AdviceMode mode() default AdviceMode.PROXY)
 * 	2、进入CachingConfigurationSelector类中
 * 	   CachingConfigurationSelector类 继承>> AdviceModeImportSelector类 实现>> ImportSelector接口
 * 	   ImportSelector 定义 selectImports 方法
 * 	   AdviceModeImportSelector 实现 selectImports，selectImports调用了重载方法 selectImports(AdviceMode adviceMode)
 * 	   CachingConfigurationSelector 实现 selectImports(AdviceMode adviceMode)，同时由1可知 adviceMode=PROXY
 * 	   所以 selectImports(AdviceMode adviceMode)去执行 getProxyImports()
 *     最终，向容器中注入下面两个类：
 * 	   org.springframework.context.annotation.AutoProxyRegistrar
 * 	   org.springframework.cache.annotation.ProxyCachingConfiguration
 *  3、ProxyCachingConfiguration 解析
 *     通过 @Bean 注入 BeanFactoryCacheOperationSourceAdvisor
 *  4、AutoProxyRegistrar 解析
 *     AutoProxyRegistrar.registerBeanDefinitions() -> AopConfigUtils.registerAutoProxyCreatorIfNecessary(registry);
 *      这两个类满足if要求(com.itcast.springboot.SpringBootCacheApplication
 *      org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration$EnableTransactionManagementConfiguration$CglibAutoProxyConfiguration)
 *      执行：AopConfigUtils.registerAutoProxyCreatorIfNecessary(registry)
 *
 *      register BeanDefinition
 *      beanName:org.springframework.aop.config.internalAutoProxyCreator
 *      class:org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator
 *  5、InfrastructureAdvisorAutoProxyCreator 解析
 *      InfrastructureAdvisorAutoProxyCreator
 *       继承AbstractAutoProxyCreator
 *        继承ProxyProcessorSupport
 *        实现SmartInstantiationAwareBeanPostProcessor ->extends InstantiationAwareBeanPostProcessor-> extends BeanPostProcessor
 *        实现BeanFactoryAware
 *
 *      核心方法（排除法）：
 *      org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.postProcessAfterInitialization 正+
 *      org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.postProcessBeforeInstantiation 正+
 *      org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.predictBeanType 正+
 *      org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.getEarlyBeanReference 正+
 *
 *      通过postProcessAfterInitialization方法确认了使用动态代理（cglib）
 *  6、执行方法
 *      CacheInterceptor
 *       继承CacheAspectSupport
 *       实现MethodInterceptor(方法拦截器，链式调用落地)
 *
 *  Object cacheValue;
 * 	Object returnValue;
 *
 * 	if (cacheHit != null && cachePutRequests.isEmpty() && !hasCachePut(contexts)) {
 * 		// If there are no put requests, just use the cache hit（从缓存中拿）
 * 		cacheValue = cacheHit.get();
 * 		returnValue = wrapCacheValue(method, cacheValue);
 * 	}
 * 	else {
 * 		// Invoke the method if we don't have a cache hit（执行目标方法获取）
 * 		returnValue = invokeOperation(invoker);
 * 		cacheValue = unwrapReturnValue(returnValue);
 * 	}
 *  7、使用 spring aop 环绕通知+自定义注解，可以实现简单的类似功能。
 */
@SpringBootApplication
@MapperScan(value = "com.itcast.springboot.mapper")
@EnableCaching
public class SpringBootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheApplication.class, args);
    }
}
