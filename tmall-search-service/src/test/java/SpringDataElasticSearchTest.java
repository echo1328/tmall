import com.tmall.mapper.GoodsMapper;
import com.tmall.pojo.Goods;
import com.tmall.search.repositories.GoodsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @program: tmall-parent
 * @description: ESTest
 * @author: wenlongzhou
 * @create: 2019-08-03 10:32
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext*.xml")
public class SpringDataElasticSearchTest {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    public void test() {
        System.out.println("Hello World!");
    }

    @Test
    public void createIndex() throws Exception {
        //创建索引，并配置映射关系
        elasticsearchTemplate.createIndex(Goods.class);
        //配置映射关系
        //elasticsearchTemplate.putMapping(Goods.class);
    }

    @Test
    public void addDocument() throws Exception {
        //创建一个list集合
        List<Goods> list = goodsMapper.selectByExample(null);
        //把文档写入索引库
        for (Goods goods : list) {
            goodsRepository.save(goods);
        }
    }

    @Test
    public void findByName() throws Exception {
        List<Goods> list = goodsRepository.findByName("黑");
        System.out.println(list);
    }

}
