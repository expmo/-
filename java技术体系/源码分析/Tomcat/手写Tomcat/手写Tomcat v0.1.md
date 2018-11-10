# 手写Tomcat v0.1

## 探究原理的作用：知其然，知其所以然

### 智者境界

> 聪明者知其然，精明者知其然知其所以然，高明者知其所以然知其所必然

- 聪明

  知道结果

- 精明

  不但知道结果，还知道发生的原因

- 高明

  知道结果，知道如何发生，知道为何如此、如何预防

### 架构师能力

1. 代码熟练度（与工作年限有关）
2. 思维能力、全局把控能力（好奇心是最好的老师）
3. 排错能力、工作效率（阅历与经验）
4. 预见能力（总结、判断力）

## 带着问题学习

### 关于 Java Web 应用的基础（ Servlet ）的疑问

1. 为什么要配置一个 web.xml ？
2. 为什么一定要继承 servlet 接口？
3. 为什么要重写 doGet、doPost 方法？
4. HttpRequest和HttpResponse是哪里出来的，自己从没new过它？
5. 在浏览器输入的url是如何被转换为调用Java方法的？

### 解答

```mermaid
graph LR
subgraph 问题
q1[<br>web.xml<br><br>]
q2[<br>为什么要继承Serlet<br>]
q3[为什么要重写doGet/doPost]
q4[HttpRequest和HttpResponse]
q5[<br><br>url如何转成调用Java方法的<br><br>]
end
subgraph 原因
r1["告诉Web容器需要处理哪些内容；<br>告诉Web容器需要注册的业务对象是哪些；<br>告诉Web容器需要将什么样的url和业务对象进行关联。"]
r2["通过接口定义契约，解决类型转换问题；<br>使用模版模式解耦业务逻辑。"]
r3[通过填空的方式来实现自己的核心业务]
r4["实际上Socket的封装；<br>HTTP协议是基于TCP/IP之上的:<br>InputStream->Request<br>OutputStream->Response"]
r5["通过SerletMapping实现：<br>启动时通过web.xml或注解取到url和servlet对象,<br>然后将key（ url ）和value（ Servlet 对象）设置到Map中;<br>收到请求后，解析出url，通过url取map中的servlet对象进行调用"]
end
q1 --- r1
q2---r2
q3---r3
q4---r4
q5---r5
```

### 实现过程

1. 定义Servlet模版，约定doGet方法、doPost方法，在service方法中根据请求方法类型调用doGet/doPost

2. 实现Servlet容器，启动时加载配置文件，初始化ServletMapping

   1. 等待用户请求

   2. 获取Scoket对象

      将socket.getInputStream()封装成Request

      将socket.getOutPutStream()封装成Response

   3. 解析请求url

   4. 通过url取ServletMapping中的Servlet对象，调用Servlet对象的对service()方法来实现doGet/doPost的动态调用

3. 应用程序继承Servlet模版类，重写doGet或doPost方法实现业务逻辑