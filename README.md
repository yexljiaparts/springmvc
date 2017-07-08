1.用户发送请求到DispatherServlet前端控制器
2.DispatherServlet调用HandlerMapping（处理器映射器）根据url查找Handler
3.DispatherServlet调用HandlerAdapter(处理器适配器)对HandlerMapping找到Handler进行包装、执行。HandlerAdapter执行Handler完成后，返回了一个ModleAndView(springmvc封装对象)

		DispatherServlet 找一个合适的适配器：
		适配器执行Hanlder
		
4.DispatherServlet拿着ModelAndView调用ViewResolver（视图解析器）进行视图解析，解析完成后返回一个View（很多不同视图类型的View）


5.DispatcherServlet进行视图渲染，将Model中数据放到request域，在页面展示

将model数据放在request域：



