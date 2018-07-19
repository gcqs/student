package biz.zc.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import biz.zc.pojo.Student;
import redis.clients.jedis.Jedis;

public class addDao {

	public void addstudent(Student student) {
		
		
		Jedis jedis = new Jedis("47.104.218.152");
		Long llen = (Long)jedis.llen("student")-1;
		List<String> list = jedis.lrange("student", llen, -1);
		student.setId(list.get(0)+1);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", student.getName());
		map.put("avg", Integer.toString(student.getAvg()));
		map.put("birthday", student.getBirthday().toString());
		map.put("description", student.getDescription());
		//jedis.del(list.get(0));
		jedis.hmset(student.getId(), map);
		//System.out.println("name="+jedis.hget(student.getId(), "name")+"=====birthday="+jedis.hget(student.getId(), "birthday"));
		jedis.rpush("student", student.getId());
		
		
		
		jedis.close();
	}

}
