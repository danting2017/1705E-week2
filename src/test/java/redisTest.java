import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liudan.senior2.week2.domain.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class redisTest {
	
	@Autowired
	RedisTemplate redisTemplate;
	
	@Test
	public void redisTestList() {
		for (int i = 1; i <= 106; i++) {
			List<Goods> list = new ArrayList<Goods>();
			Goods g = new Goods();
			g.setId(i);
			g.setName("手机");
			g.setPrice(2500);
			g.setBaifenbi("35%");
			list.add(g);
			//向里面存元素
			redisTemplate.opsForList().leftPush("goods_list", list);
			
			List<Goods> leftPop = (List<Goods>) redisTemplate.opsForList().leftPop("goods_list");
			for (Goods goods : leftPop) {
				System.out.println(goods);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void redisTestZSet() {
		for (int i = 1; i <= 106; i++) {
			List<Goods> list = new ArrayList<Goods>();
			Goods g = new Goods();
			g.setId(i);
			g.setName("手机");
			g.setPrice(2500);
			g.setBaifenbi("35%");
			list.add(g);
			//向里面存元素
			redisTemplate.opsForZSet().add("ZSet", list, i);
			/*
			 * Set range = redisTemplate.opsForZSet().range("ZSet", 0,-1); for (Object
			 * object : range) { System.out.println(object); }
			 */
		}
	}
	
}
