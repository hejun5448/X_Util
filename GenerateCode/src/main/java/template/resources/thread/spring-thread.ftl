<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
		http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/aop
		http://www.springframework.org/schema/aop/spring-aop-3.1.xsd">

    <bean id="taskExecutor" class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
        <!-- 线程池维护线程的最少数量 -->
        <property name="corePoolSize" value="20" />
        <!-- 允许的空闲时间 -->
        <property name="keepAliveSeconds" value="200" />
        <!-- 线程池维护线程的最大数量 -->
        <property name="maxPoolSize" value="1000" />
        <!-- 缓存队列 -->
        <property name="queueCapacity" value="500" />

        <property name="waitForTasksToCompleteOnShutdown" value="true" />
        <!-- 对拒绝task的处理策略 -->
        <property name="rejectedExecutionHandler">
            <bean class="java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy" />
        </property>
    </bean>


</beans>