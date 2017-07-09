package converter;

import com.bean.Product;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 暂无使用
 * Created by Administrator on 2017/7/8.
 */
public class CustomMessageConverter extends AbstractHttpMessageConverter<Product>{

//映射model
    protected boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }
//输入
    protected Product readInternal(Class<? extends Product> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
       //数据拆分
        String temp= StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String []tempArr=temp.split("-");

        return new Product(tempArr[0],tempArr[1]);
    }
    //输出
    protected void writeInternal(Product Product, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
String outString="out"+Product.getId()+Product.getName();
        outputMessage.getBody().write(outString.getBytes());
    }
}
