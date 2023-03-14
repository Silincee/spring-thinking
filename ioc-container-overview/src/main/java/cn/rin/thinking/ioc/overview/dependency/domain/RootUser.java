package cn.rin.thinking.ioc.overview.dependency.domain;

import lombok.Data;
import org.springframework.context.annotation.Bean;

/**
 * root用户
 *
 * @author rin
 * @since 2023.03.14
 */
@Data
public class RootUser extends User{

    private String address;

}
