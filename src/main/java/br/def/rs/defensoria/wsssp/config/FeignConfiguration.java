package br.def.rs.defensoria.wsssp.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "br.def.rs.defensoria.wsssp")
public class FeignConfiguration {

}
