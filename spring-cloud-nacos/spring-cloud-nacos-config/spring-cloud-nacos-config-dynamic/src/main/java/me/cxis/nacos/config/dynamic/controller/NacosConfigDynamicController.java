package me.cxis.nacos.config.dynamic.controller;

import me.cxis.nacos.config.dynamic.json.Json;
import me.cxis.nacos.config.dynamic.nacos.DefaultConfig;
import me.cxis.nacos.config.dynamic.nacos.NacosConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos/config/dynamic")
public class NacosConfigDynamicController {

    @GetMapping("/query")
    public String query() {
        return "result from nacos discovery server";
    }

    @GetMapping("/query/config/default")
    public String queryDefaultConfig() {
        DefaultConfig config = NacosConfig.defaultConfig();
        return Json.toJsonString(config);
    }
}
