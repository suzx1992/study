package com.example.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class StudyApplication {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext application = SpringApplication.run(StudyApplication.class, args);
        Environment env = application.getEnvironment();
        // 启动成功后打印日志
        String ip= InetAddress.getLocalHost().getHostAddress();
        String port=env.getProperty("server.port");
        String path=env.getProperty("server.servlet.context-path");
        if(path==null){
            path="";
        }
           log.info("-------------------------\n\t" +
                "Application is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "swagger-ui: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n\t" +
                "Doc: \thttp://" + ip + ":" + port + path + "/doc.html\n\t" +
                "-------------------------");

    }



}
