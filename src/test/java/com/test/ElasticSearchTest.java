package com.test;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Iterator;

/**
 * @auther xuxq
 * @date 2019/1/13 20:41
 */
public class ElasticSearchTest {

    @Test
    public void demo1() throws IOException {
        // 创建连接搜索服务器对象
        Client client = TransportClient
                .builder()
                .build()
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress
                                .getByName("127.0.0.1"), 9300));
        // 描述json 数据
        /*
         * {id:xxx, title:xxx, content:xxx}
         */
        XContentBuilder builder = XContentFactory
                .jsonBuilder()
                .startObject()
                .field("id", 1)
                .field("title", "ElasticSearch是一个基于Lucene的搜索服务器")
                .field("content",
                        "ElasticSearch提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码发布，是当前流行的企业级搜索引擎。设计用于云计算中，能够达到实时搜索，稳定，可靠，快速，安装使用方便。")
                .endObject();
        // 建立文档对象
        client.prepareIndex("blog1", "article", "1").setSource(builder).get();

        // 关闭连接
        client.close();
    }
    @Test
    // 搜索在elasticSearch中创建文档对象
    public void demo2() throws IOException {
        // 创建连接搜索服务器对象
        Client client = TransportClient
                .builder()
                .build()
                .addTransportAddress(
                        new InetSocketTransportAddress(InetAddress
                                .getByName("127.0.0.1"), 9300));
        // 搜索数据
        // get() === execute().actionGet()
        SearchResponse searchResponse = client.prepareSearch("blog1")
                .setTypes("article").setQuery(QueryBuilders.matchAllQuery())
                .get();
        SearchHits hits = searchResponse.getHits();
        System.out.println("查询结果：" + hits.getTotalHits() + "条");
        Iterator<SearchHit> iterator = hits.iterator();
        while (iterator.hasNext()){
            SearchHit next = iterator.next();
            System.out.println(next.getSourceAsString());//取字符串格式打印
            System.out.println("title:" +next.getSource().get("title"));
        }

        ///printSearchResponse(searchResponse);

        // 关闭连接
        client.close();
    }
}
