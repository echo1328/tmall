import com.tmall.search.entity.Article;
import com.tmall.search.repositories.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: tmall-parent
 * @description: ESTest
 * @author: wenlongzhou
 * @create: 2019-08-03 10:32
 **/

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

}
