package com.example.demo;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.cluster.ClusterOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;

import java.util.List;

@SpringBootTest
class ElasticsearchDemoApplicationTests {

//    @Autowired
//    private TestDao testDao;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {

        ClusterOperations cluster = elasticsearchRestTemplate.cluster();
        MatchQueryBuilder query = QueryBuilders.matchQuery("user", "kk");
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(query);

        SearchHits<TestBean> search = elasticsearchRestTemplate.search(nativeSearchQuery, TestBean.class);
        List<SearchHit<TestBean>> searchHits = search.getSearchHits();
        for (SearchHit<TestBean> searchHit : searchHits) {
            System.out.println(searchHit);
        }
    }

}
