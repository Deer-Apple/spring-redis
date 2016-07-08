/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redis;

import com.github.deerapple.spring.redis.IUserDao;
import com.github.deerapple.spring.redis.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author SONY
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})  
public class RedisTest {
    
    @Autowired
    private IUserDao userDao;
    
//    @Test
//    public void testAdd(){
//        User user = new User("user1","小明");
//        boolean result = userDao.add(user);
//        Assert.assertTrue(result);
//    }
    
    @Test  
    public void testGet() {  
        String id = "user1";  
        User user = userDao.get(id);  
        Assert.assertNotNull(user);
        System.out.println(user.getKey());
        Assert.assertEquals("小明", user.getKey());  
    } 
}
