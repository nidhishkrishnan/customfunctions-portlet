package com.test;
import java.util.List;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.colors.themes.service.ColorsLocalService;
import com.colors.themes.service.ColorsLocalServiceUtil;
import com.liferay.portal.kernel.test.TestCase;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceUtil;

public class JunitTableLocalServiceImplTest extends TestCase {
	ColorsLocalServiceUtil ss;
    /*private ColorsLocalService jts;
    private UserLocalService userService;
    
    @Before
    protected void setUp() {
        try{
            System.out.println(">>>SET UP");
            //init the application context and beans for Spring.
            InitUtil.initWithSpring();
            //Get the service for testing
            jts = ColorsLocalServiceUtil.getService();
            //Test LR services
            userService = UserLocalServiceUtil.getService();
            super.setUp();
        }catch(Exception ex){
            ex.printStackTrace();
            fail("Init failed...");
        }
    }

    @After
    protected void tearDown() throws Exception {
        System.out.println(">>>TEAR DOWN");
        jts = null;
        userService = null;
        super.tearDown();
    }
    
    @Test
    public void testFindById(){
        long id = 1001l;
        try {
            //Test own portlets
            String userName = jts.getColors(id).getColorName();
            System.out.println(">>>>>my own username: " + userName);
           // assertEquals("jack", userName);
            
            //Reading LR objects
            List<User> users = userService.getUsers(-1, -1);
            System.out.println("Number of User:"+ users.size());

            for(User user : users){
                System.out.println("User: " + user.getFullName());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            fail("Junit Find By Id failed --- ID: " + id);
        }
    }*/
}