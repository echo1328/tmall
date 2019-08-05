import com.tmall.search.entity.Article;
import com.tmall.search.repositories.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

/**
 * @program: tmall-parent
 * @description: ESTest
 * @author: wenlongzhou
 * @create: 2019-08-03 10:32
 **/

//@ContextConfiguration(locations="classpath*:spring/applicationContext-es.xml")

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-es.xml")
public class ESTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void test() {
        System.out.println("Hello World!");
    }

    @Test
    public void createIndex() throws Exception {
        //创建索引，并配置映射关系
        elasticsearchTemplate.createIndex(Article.class);
        //配置映射关系
        //elasticsearchTemplate.putMapping(Article.class);
    }

    @Test
    public void addDocument() throws Exception {
        //创建一个Article对象
        Article article = new Article();
        article.setId(29);
        article.setTitle("Maven2222");
        article.setContent("Maven项目对象模型(POM)，可以通过一小段描述信息来管理项目的构建，报告和文档的项目管理工具软件。");
        //把文档写入索引库
        articleRepository.save(article);
    }

    @Test
    public void addDocuments() throws Exception {
        for (int i = 15; i <= 20; i++) {
            //创建一个Article对象
            Article article = new Article();
            article.setId(i);
            article.setTitle("哈哈哈哈" + i);
            article.setContent("新闻联播五连发:捍卫自身利益 一切后果美方承担。");
            //把文档写入索引库
            articleRepository.save(article);
        }
    }

    @Test
    public void deleteDocumentById() throws Exception {
        articleRepository.deleteById(1);
        //全部删除
        //articleRepository.deleteAll();
    }

    @Test
    public void findALl() throws Exception {
        Iterable<Article> articles = articleRepository.findAll();
        articles.forEach(a -> System.out.println(a));
    }

    @Test
    public void findById() throws Exception {
        Optional<Article> optional = articleRepository.findById(1);
        Article article = optional.get();
        System.out.println(article);
    }

    @Test
    public void findByTitle() throws Exception {
        List<Article> list = articleRepository.findByTitleLike("吉首哈大学");
        list.stream().forEach(a -> System.out.println(a));
    }

    @Test
    public void findByTitleOrContent() throws Exception {
        Pageable pageable = PageRequest.of(0,15);
        List<Article> list = articleRepository.findByTitleOrContent("哈哈哈哈19","hhh",pageable);
        list.stream().forEach(a -> System.out.println(a));
    }

    @Test
    public void nativeSearchQuery() throws Exception {
        //创建一个查询对象
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery("哈吉首大学").defaultField("title"))
                .withPageable(PageRequest.of(0,15))
                .build();
        //执行查询
        List<Article> articleList = elasticsearchTemplate.queryForList(query, Article.class);
        articleList.forEach(a -> System.out.println(a));
    }

}
