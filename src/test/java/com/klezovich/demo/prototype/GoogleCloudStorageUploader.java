package com.klezovich.demo.prototype;


import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

@Slf4j
public class GoogleCloudStorageUploader {

    public static void main(String[] args) throws FileNotFoundException {

        log.info("Are you logged in as klezovich@gmail.com in Google Cloud ?");
        System.exit(0);

        // List all buckets
        log.info("## Listing all buckets in project\n");
        var storage = StorageOptions.getDefaultInstance().getService();
        var buckets = storage.list(Storage.BucketListOption.pageSize(100));
        buckets.iterateAll().forEach( b-> log.info("Bucket:"+b.getName()));


        // List contents of a bucket
        log.info("");
        log.info("## Listing bucket contents\n");
        var bucket = storage.get("demo-bucket-ak");
        log.info("{} {}",bucket.getName(),bucket.requesterPays());
        bucket.list().iterateAll().forEach( i -> log.info("Bucket item:"+i.getName()));


        //Upload a file to a bucket
        var r = new Random();
        var suffix = r.nextInt();

        var folderName = "arthurs_folder";
        var blobId = BlobId.of("demo-bucket-ak", folderName+"/"+"greetings"+suffix );
        var blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();

        var file = ResourceUtils.getFile("classpath:greetings.txt");
        log.info("");
        log.info("## Uploading file {} to bucket {}", file.getAbsolutePath(), bucket.getName() );
        var blob = storage.create(blobInfo, new FileInputStream(file));
        log.info("## File (blob) {} created. Size {} bytes", blob.getName(), blob.getSize() );
    }
}
