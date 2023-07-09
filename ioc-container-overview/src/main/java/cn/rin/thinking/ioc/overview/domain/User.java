package cn.rin.thinking.ioc.overview.domain;

import cn.rin.thinking.ioc.overview.annotation.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhongye
 * @since 2022.08.21
 */
@Data
@Root
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

    private String name;

    private Long id;

}
