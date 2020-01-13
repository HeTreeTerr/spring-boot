package com.itcast.springboot;

import com.itcast.springboot.bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootElasticApplicationTests {
    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() {
        //给ES中索引（保存）一个文档
        Article article = new Article();
        article.setId(1);
        article.setAutor("hss");
        article.setTitle("fffff");
        article.setContent("小甜甜。。。。");
        System.out.println(article);

        Index index = new Index.Builder(article).index("hss").type("books").build();

        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //测试搜索
    @Test
    public void search(){
        String json = "{\n" +
                "\"query\":{\n" +
                "       \"match\":{\n" +
                "           \"content\":\"小\"\n" +
                "          }\n" +
                "      }\n" +
                "}";
        Search builder = new Search.Builder(json).addIndex("hss").addType("books").build();
        //执行
        try {
            SearchResult result = jestClient.execute(builder);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
