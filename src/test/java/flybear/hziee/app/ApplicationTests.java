package flybear.hziee.app;

import flybear.hziee.app.service.CommunityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private CommunityService communityService;

    @Test
    public void test() {
        communityService.list().forEach(System.out::println);
    }

}
