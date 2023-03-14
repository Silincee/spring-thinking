package cn.rin.thinking.ioc.overview.dependency.lookup;

import cn.rin.thinking.ioc.overview.annotation.Root;
import cn.rin.thinking.ioc.overview.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * 1 通过名称的反思来查找
 *
 * @author zhongye
 * @since 2022.08.21
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/denpency-lookup-context.xml");
        // 实时查找
        lookupInRealTime(beanFactory);
        // 延时查找
        lookupInLazy(beanFactory);
        // 根据类型查找
        lookupByType(beanFactory);
        // 按照类型查找集合对象
        lookupCollectionByType(beanFactory);
        // 根据注解查找集合对象
        lookupCollectionByAnnotationType(beanFactory);
    }

    /**
     * 根据注解查找集合对象
     */
    private static void lookupCollectionByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = ((ListableBeanFactory) beanFactory);
            Map<String, User> userList = (Map) listableBeanFactory.getBeansWithAnnotation(Root.class);
            System.out.println("查找到的所有标注 @Root 的User的集合对象: " + userList);
        }
    }

    /**
     * 按照类型查找集合对象
     */
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, User> userList = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);
            System.out.println("查找到的所有类型为User的集合对象: " + userList);
        }
    }

    /**
     * 根据类型查找
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("根据类型查找: " + user);
    }

    /**
     * 实时查找
     */
    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找: " + user);
    }

    /**
     * 延时查找
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找: " + user);
    }

}
