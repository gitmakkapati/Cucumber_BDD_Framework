package Project;

import Project.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.FileNotFoundException;

public class Hooks {

    Base base_obj = new Base();

    @Before

    public void initialization() throws FileNotFoundException, InterruptedException {
        base_obj.initialization();
    }

    @After
    public void tearDown(){

        base_obj.closeBrowser();
    }


}
