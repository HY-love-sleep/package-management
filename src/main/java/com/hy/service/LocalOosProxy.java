package com.hy.service;

import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.AttachmentProxy;

import java.io.InputStream;

/**
 * Description: 本地文件存储
 * Author: yhong
 * Date: 2023/12/18
 */
@Service
public class LocalOosProxy implements AttachmentProxy {

    @Override
    public String upLoad(InputStream inputStream, String path) {
        return null;
    }

    @Override
    public String fileDomain() {
        return null;
    }

    @Override
    public boolean isLocalSave() {
        return true;
    }
}
