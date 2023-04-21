package co.istad.thymeleaf.webapp.repository;

import co.istad.thymeleaf.webapp.model.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository

public interface ArticleMapper {
    @Insert("""
            INSERT INTO articles (uuid, title, thumbnail, author)
            VALUES (#{a.uuid}, #{a.title}, #{a.thumbnail}, #{a.author})
            """)
    void insert (@Param("a") Article article);

    @Select("SELECT * FROM articles")
    List<Article> select();

    void deleteByUuid(String uuid);
}
