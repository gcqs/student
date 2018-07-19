package biz.zc.dao;

import java.util.ArrayList;
import java.util.List;

import biz.zc.pojo.Student;
import redis.clients.jedis.Jedis;

public class findDao {

	public List<Student> findstudent() {
		List<Student> list = new ArrayList<Student>();
		Jedis jedis = new Jedis("47.104.218.152");
		return list;
	}
	
	

}
