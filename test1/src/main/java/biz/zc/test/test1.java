package biz.zc.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import biz.zc.pojo.Student;
import redis.clients.jedis.Jedis;

class Mythread extends Thread{

	public void run() {
		test1 ts = new test1();
		ts.uuid();
		System.out.println("xxx");
	}
	
	
}

public class test1 {
	public int k = 0;
	public static void main(String[] args) {
		
		//Jedis jedis = new Jedis("47.104.218.152",6379,5000);
		
		//System.out.println(jedis.ping());
		Jedis jedis = new Jedis("47.104.218.152");
		System.out.println(jedis.keys("student"));
		jedis.close();
		
//		jedis.rpush("student", "1");
//		Long llen = (Long)jedis.llen("student")-1;
//		System.out.println(llen);
//		List<String> list = jedis.lrange("student", llen, -1);
//		System.out.println(list);
//		
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("name", "wangwu");
		//jedis.hmset("1", map);
	    //System.out.println(jedis.hgetAll("myhash"));
		//System.out.println(jedis.hget("myhash", "1"));
		
			//System.out.println(string);
//		 for (int i = 0; i < 3; i++) {  
//	            Thread thread = new Mythread();  
//	            thread.start();  
//	            System.out.println("kaishi"+i);
//	            
//	        
//		 
//		
//		}
		
		

	}
	public  void uuid() {
		String uuid = UUID.randomUUID().toString();
		 int p = 9;
		 System.out.println(p);
		 synchronized (test1.class) {
		 Date date = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 String format = sdf.format(date);
	     String id = uuid + format;
	     k++;
	     System.out.println(id);
	    // System.out.println(k);
		 
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 System.out.println("jiesu");
        
		
	}
	
	}

