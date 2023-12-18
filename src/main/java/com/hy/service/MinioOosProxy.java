package com.hy.service;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.AttachmentProxy;
import xyz.erupt.core.util.MimeUtil;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class MinioOosProxy implements AttachmentProxy {

    @Value("${minio.endpoint}")
    private String endpoint; // MinIO服务器的地址

    @Value("${minio.access_key}")
    private String accessKey; // MinIO的访问密钥

    @Value("${minio.secret_key}")
    private String secretKey; // MinIO的秘密密钥

    @Value("${minio.bucket}")
    private String bucket; // MinIO的存储桶名称

    @Value("${minio.file_download_point}")
    private String file_download_point;

    @Override
    public String upLoad(InputStream inputStream, String path) {
        try {
            // 创建Minio客户端
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endpoint)
                    .credentials(accessKey, secretKey)
                    .build();

            // 检查存储桶是否存在，不存在则创建
            if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build())) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            }
            path = path.startsWith("/") ? path.substring(1) : path;

            // 上传文件到MinIO
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucket)
                    .object(path)
                    .stream(inputStream, inputStream.available(), -1)
                    .contentType(getContentType(path))
                    .build());

            // 返回MinIO中的访问路径
            return getMinioObjectUrl(path);
        } catch (MinioException | IOException e) {
            throw new RuntimeException("上传到MinIO失败", e);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String fileDomain() {
        return endpoint;
    }

    @Override
    public boolean isLocalSave() {
        return false;
    }

    private String getMinioObjectUrl(String path) {
        return file_download_point
                + "/buckets/" + bucket + "/" + path;
    }

    private String getContentType(String path) {
        // 这里可以根据文件扩展名设置合适的ContentType
        // 例如："image/jpeg"、"application/pdf" 等
        // 如果无法确定，可以使用默认的 "application/octet-stream"
        return "application/octet-stream";
    }
}
