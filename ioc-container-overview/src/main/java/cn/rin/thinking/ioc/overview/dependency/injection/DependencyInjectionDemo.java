package cn.rin.thinking.ioc.overview.dependency.injection;

import cn.rin.thinking.ioc.overview.annotation.Root;
import cn.rin.thinking.ioc.overview.domain.User;
import cn.rin.thinking.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖注入示例
 *
 * @author rin
 * @since 2023.03.19
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        // System.out.println(userRepository.getUsers());

        // 依赖注入 DefaultListableBeanFactory 不是同一个factory
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        // 依赖查找 err 并没有这个bean 【依赖查找和依赖注入并不同源】
        // System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory<User> userFactory = userRepository.getUserObjectFactory();
        System.out.println(userFactory.getObject());
    }

}
