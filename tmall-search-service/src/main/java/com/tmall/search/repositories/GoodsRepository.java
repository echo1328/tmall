package com.tmall.search.repositories;

import com.tmall.pojo.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface GoodsRepository extends ElasticsearchRepository<Goods, Integer> {

    List<Goods> findByName(String name);

    List<Goods> findByNameLike(String name);

    List<Goods> findByNameLikeOrCaptionLikeOrIntroductionLikeOrActivityLike(
            String name,String caption,String introduction,String activity
    );
}
