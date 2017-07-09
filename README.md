1.用户发送请求到DispatherServlet前端控制器

2.DispatherServlet调用HandlerMapping（处理器映射器）根据url查找Handler

3.DispatherServlet调用HandlerAdapter(处理器适配器)对HandlerMapping找到Handler进行包装、执行。HandlerAdapter执行Handler完成后，返回了一个ModleAndView(springmvc封装对象)

		DispatherServlet 找一个合适的适配器：
		适配器执行Hanlder
		
4.DispatherServlet拿着ModelAndView调用ViewResolver（视图解析器）进行视图解析，解析完成后返回一个View（很多不同视图类型的View）


5.DispatcherServlet进行视图渲染，将Model中数据放到request域，在页面展示

将model数据放在request域





与struts2不同
1、springmvc的入口是一个servlet即前端控制器，而struts2入口是一个filter过虑器。
2、springmvc是基于方法开发(一个url对应一个方法)，请求参数传递到方法的形参，可以设计为单例或多例(建议单例)，struts2是基于类开发，传递参数是通过类的属性，只能设计为多例。
3、Struts采用值栈存储请求和响应的数据，通过OGNL存取数据， springmvc通过参数解析器是将request请求内容解析，并给方法形参赋值，将数据和视图封装成ModelAndView对象，最后又将ModelAndView中的模型数据通过reques域传输到页面。Jsp视图解析器默认使用jstl。




AbstractDetectingUrlHandlerMapping 中的 detectHandlers方法,这个方法取出了所有的bean，然后循环查找带有Controller的bean，并提取其中的RequestMapping信息




protected void detectHandlers() throws BeansException {

    if (logger.isDebugEnabled()) {
        logger.debug("Looking for URL mappings in application context: " + getApplicationContext());
    }
    
    String[] beanNames = (this.detectHandlersInAncestorContexts ?
            BeanFactoryUtils.beanNamesForTypeIncludingAncestors(getApplicationContext(), Object.class) :
            getApplicationContext().getBeanNamesForType(Object.class));
	    
    // Take any bean name that we can determine URLs for.
    
    for (String beanName : beanNames) {
        String[] urls = determineUrlsForHandler(beanName);
        if (!ObjectUtils.isEmpty(urls)) {
            // URL paths found: Let's consider it a handler.
            registerHandler(urls, beanName);
        }
        else {
            if (logger.isDebugEnabled()) {
                logger.debug("Rejected bean name '" + beanName + "': no URL paths identified");
            }
        }
    }
}


