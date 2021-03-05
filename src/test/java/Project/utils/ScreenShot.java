package Project.utils;

import Project.Base;
import org.apache.commons.lang3.SystemUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShot extends Base {

    public void takeFullScreenShot() throws IOException {

        Date d = new Date();

        String filename = d.toString().replace("", "_").replace(":", "_") + ".png";
        String screenshotPath = SystemUtils.getUserDir() + " /target/screenshot/" + filename;

        //take screenshot image
        Screenshot screenshot =
                new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);

        //write to location

            ImageIO.write(screenshot.getImage(), "PNG", new File(screenshotPath));


    }

}
