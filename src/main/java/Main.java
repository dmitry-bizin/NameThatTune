import com.sun.javafx.application.LauncherImpl;
import util.UncaughtExceptionHandler;

public class Main {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler());
        LauncherImpl.launchApplication(App.class, SplashScreen.class, args);
    }

}
