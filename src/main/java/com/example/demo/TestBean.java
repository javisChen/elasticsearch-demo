package com.example.demo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Document(indexName = "school")
public class TestBean implements Serializable {

    // 必须指定一个id，
//    @Id
    private String id;
//    @Field
    private String user;
}
