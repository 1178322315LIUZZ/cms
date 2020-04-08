package text;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuzhenzhen.cms.dao.ArticleLight;
import com.liuzhenzhen.cms.entity.Article;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:es.xml")
public class Text {
	@Autowired
	private ArticleLight articleLight;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	/**
	 * 
	 * @Title: test 
	 * @Description: 测试es添加
	 * @return: void
	 */
	@Test
	public void test() {
		Article article = new Article();
		article.setId(1);
		article.setTitle("你好，我是一个大好人");
		article.setContent("大海任主题");
		articleLight.save(article);
	}
	/**
	 * 
	 * @Title: test1 
	 * @Description: 测试es修改
	 * @return: void
	 */
	@Test
	public void test1() {
		Article article = new Article();
		article.setId(1);
		article.setTitle("你好，我是一个大好人");
		article.setContent("大好人主题");
		articleLight.save(article);
	}
	/**
	 * 
	 * @Title: test2 
	 * @Description: 测试es删除
	 * @return: void
	 */
	@Test
	public void test2() {
		articleLight.deleteById(1);
	}
	/**
	 * 
	 * @Title: test3 
	 * @Description: 测试es查询
	 * @return: void
	 */
	@Test
	public void test3() {
		Article article = articleLight.findByContent("大好人");
		System.out.println(article);
	}
}
