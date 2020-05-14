package com.alibaba.nacos.example;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;

public class NacosConfigDemo {

    public static void main(String[] args) throws Exception {

        String tenant = Util.TENANT;
        String dataId = "db.password";
        String group = "test";

        // 其实就是调用 ConfigFactory.createConfigService(properties)
        ConfigService configService = NacosFactory.createConfigService(Util.getProperties(tenant));
        // Actively get the configuration.
        String content = configService.getConfig(dataId, group, 5000*1000); //为了调试
        System.out.println(content);


    }

}
