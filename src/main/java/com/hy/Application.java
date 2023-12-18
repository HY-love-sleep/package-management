package com.hy;

import com.hy.service.LocalOosProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import xyz.erupt.core.annotation.EruptAttachmentUpload;
import xyz.erupt.core.annotation.EruptScan;

/**
 * Description: erupt启动类
 * Author: yhong
 * Date: 2023/10/18
 */
@SpringBootApplication
@EntityScan
@EruptScan
@EruptAttachmentUpload(LocalOosProxy.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
