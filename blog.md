# 前言
随着Spring Boot2.0正式发布，Spring WebFlux正式来到了Spring Boot大家族里面。由于Spring WebFlux可以通过更少的线程去实现更高的并发和使用更少的硬件资源去实现扩展，我对此很感兴趣。同时Angular6也发布了，也想试试自己Angular的功底，便基于Angular和Spring WebFlux做个一个简单礼品管理系统的demo。

# 响应式编程
响应式编程是一种面向数据流和变化传播的编程范式。这意味着可以在编程语言中很方便地表达静态或动态的数据流，而相关的计算模型会自动将变化的值通过数据流进行传播。个人通俗的理解为产生数据的行为放在一个数据流内，通过一些运算符将流中的数据进行适当的转化，最终获取该数据流中的数据并处理数据。我最早接触响应式编程是在学习Angular2的时候了解到rxjs,这是ReactiveXz在js上的实现版本，其java版本为rxjava。

# 学习建议
1. 由于Spring WebFlux是基于Reactor库，因此建议先学习一下Reactor，了解响应式编程的概念，能区分Mono和Flux之间的区别。其[官网](http://projectreactor.io/)。
2. 如果能有余力，可以考虑学一下RxJava2。
3. 尽可能使用基于事件的编程思维，少写同步的代码。

# 对Spring WebFlux的看法
1. 实际开发中如果Spring MVC已经能够满足需求，还是不要使用Spring WebFlux，除非你仅仅是在Controller层中将Service的返回接口包装成Mono或者Flux，
2. 如果使用Spring WebFlux，尽量还是使用基于 Java 注解的方式，尤其是当请求参数比较复杂的时候，基于 Java 8 的 lambda 表达式的函数式编程模型的方式是真的不好用！！！

# 代码分享
代码已经放在[github](https://github.com/damingerdai/inventory)和[码云](https://gitee.com/damingerdai/inventory),希望大家能多多指点。
![主页面](https://raw.githubusercontent.com/damingerdai/inventory/master/screenshots/home.PNG)

