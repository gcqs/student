package biz.zc.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import biz.zc.pojo.Page;
import biz.zc.pojo.Student;
import redis.clients.jedis.Jedis;

public class studentDao {

	//添加
	public void addstudent(Student student) {
		
		
		Jedis jedis = new Jedis("47.104.218.152");
		//Long llen = (Long)jedis.llen("student")-1;
		if(jedis.exists("student")) {
			Set<String> set = jedis.zrange("student", -1, -1);
			for(String id : set) {
				int i = Integer.parseInt(id)+1;
				student.setId(String.valueOf(i));
			}
			
		}else {
			student.setId("1");
			
		}
		
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", student.getName());
		map.put("avg", Integer.toString(student.getAvg()));
		map.put("birthday", student.getBirthday().toString());
		map.put("description", student.getDescription());
		//jedis.del(list.get(0));
		jedis.hmset(student.getId(), map);
		//System.out.println("name="+jedis.hget(student.getId(), "name")+"=====birthday="+jedis.hget(student.getId(), "birthday"));
		jedis.zadd("student", student.getAvg(), student.getId());
		
		
		
		jedis.close();
	}
	//查找学生信息
	public Page findstudent(Page page) {
		List<Student> list = new ArrayList<Student>();
		
		Jedis jedis = new Jedis("47.104.218.152");
		
		if(jedis.exists("student")) {
			Long zcount = jedis.zcount("student", 0, 1000);
			if(zcount!=null && zcount!= 0) {
				page.setTote(zcount);
				System.out.println("++++"+zcount);
				page.setStart(page.getTote()-page.getPage()*page.getSizi());

				long end = page.getStart()+4;
				if(page.getStart()<0) {
					page.setStart(0);
					
				}
				//取出id
				Set<String> set = jedis.zrange("student", page.getStart(), end);
				

		        SimpleDateFormat sdf = new SimpleDateFormat();
				
		        //遍历id取出数据
				for(String id : set) {
					Student student = new Student();
					Map<String, String> hgetAll = jedis.hgetAll(id);
					student.setName(hgetAll.get("name"));
					System.out.println(student.getName());
					student.setAvg(Integer.parseInt(hgetAll.get("avg")));
					Date birthday;
					
//						birthday = sdf.parse(hgetAll.get("birthday"));
						birthday = new Date(hgetAll.get("birthday"));
						student.setBirthday(birthday);
					
					student.setDescription(hgetAll.get("description"));
					student.setId(id);
					list.add(student);
					
					
					
				}
				
				//降序排
				List<Student> list1 = new ArrayList<Student>();
				for(int i=list.size()-1;i>=0;i--) {
					list1.add(list.get(i));
					
				}
				page.setStudents(list1);
				
			}
		}
		
		
		jedis.close();
		
		return page;
	}

	public void deleteDao(String id) {
		Jedis jedis = new Jedis("47.104.218.152");
	    jedis.del(id);
	    jedis.zrem("student", id);
	    jedis.close();
	    
		
	}
	//修改
	public void alterDao(Student student) {
		Jedis jedis = new Jedis("47.104.218.152");
		jedis.del(student.getId());
		
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", student.getName());
		map.put("avg", Integer.toString(student.getAvg()));
		map.put("birthday", student.getBirthday().toString());
		map.put("description", student.getDescription());
		
		jedis.hmset(student.getId(), map);
		
		
		
	}
	

}
