package com.tmall.search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @program: tmall-parent
 * @description: Article
 * @author: wenlongzhou
 * @create: 2019-08-02 17:32
 **/

@Document(indexName = "index_article", type = "article")
public class Article {

    @Id
    @Field(type = FieldType.Integer, store = true)
    private int id;

    @Field(type = FieldType.text, store = true, analyzer = "ik_smart")
    private String title;

    @Field(type = FieldType.text, store = true, analyzer = "ik_smart")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
