package com.controller;

import com.bean.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * ${DESCRIPTION}
 * Created by Administrator on 2017/7/8.
 */

@Controller
@RequestMapping(value="/mvc")
public class TestMvc {
    @RequestMapping(value="/test")
    @ResponseBody
    public String testConversion(@RequestParam(value="product")Product product){
        return product.getName();
    }

/*
    @RequestMapping(value="/test2")
    public ModelAndView test2(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("");
        return mv;
    }*/
}
