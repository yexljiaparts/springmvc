package com.component;

import com.bean.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * 自定义转换器
 * Created by yexl on 2017/7/9.
 */
@Component
public class ProcuctConverter implements Converter<String, Product> {


    public Product convert(String source) {
        if (source != null) {
            //解析
            Product product = new Product();
            //java-javabase-12.0-2011.12.12
            String[] values = source.split("-");
      /*      if (values != null && values.length == 4) {*/
                product.setName(values[0]);
                product.setId(values[1]);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
               /* product.setProductionDate(new Date());*/
                System.out.println(source + "--converter" + product);
                return product;
            }


     /*   }*/
        return null;
    }
}
