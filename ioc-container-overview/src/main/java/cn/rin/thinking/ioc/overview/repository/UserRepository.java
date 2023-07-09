package cn.rin.thinking.ioc.overview.repository;

import cn.rin.thinking.ioc.overview.domain.User;
import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.util.Collection;

/**
 * 用户信息仓库
 *
 * @author rin
 * @since 2023.03.19
 */
@Data
public class UserRepository{

    /** 
    * 定义 bean 
    */ 
    private Collection<User> users;

    /**
    * 内建非 Bean对象(依赖)
    */
    private BeanFactory beanFactory;
    
    /** 
    * 延时注入
    */ 
    private ObjectFactory<User> userObjectFactory;
}

