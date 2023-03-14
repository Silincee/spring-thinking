package cn.rin.thinking.ioc.overview.dependency.domain;

import cn.rin.thinking.ioc.overview.annotation.Root;
import com.oracle.tools.packager.IOUtils;
import lombok.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author zhongye
 * @since 2022.08.21
 */
@Data
@Root
public class User {

    private String name;

    private Long id;

}
