package cn.rin.thinking.ioc.overview.dependency.injection;

import cn.rin.thinking.ioc.overview.annotation.Root;
import cn.rin.thinking.ioc.overview.domain.User;
import cn.rin.thinking.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * 依赖注入示例
 *
 * @author rin
 * @since 2023.03.19
 */
public class DependencyInjectionDemo {

    /**
     * 依赖注入示例
     */
    private static void dependencyInjectionDemo(){
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");

        // 自定义Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        // System.out.println(userRepository.getUsers());

        // 依赖注入(容器内建依赖) DefaultListableBeanFactory 不是同一个factory
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        // 依赖查找 err 并没有这个bean 【依赖查找和依赖注入并不同源】
        // System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory<User> userFactory = userRepository.getUserObjectFactory();
        System.out.println(userFactory.getObject());

        // 容器内建Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment 类型的Bean: " + environment);
    }


    /**
     * 谁是真正的IoC容器
     */
    private static void whoIsIocContainer() {
        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory
        // ConfigurableApplicationContext#getBeanFactory()

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
        // 自定义Bean
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
        // false 为什么这个表达式不会成立
        System.out.println(userRepository.getBeanFactory() == applicationContext);


    }

    public static void main(String[] args) {
        DependencyInjectionDemo.whoIsIocContainer();
    }

}
