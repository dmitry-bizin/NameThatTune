import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import xml.Categories;
import xml.Melody;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dmitriy on 26.12.2015.
 */
public class Main extends Application {
    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static ClassLoader classLoader = Main.class.getClassLoader();

    static {
        try {
            createDirectories();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }

    //возвращает абсолютный путь ресурса
    public static String getResource(String fileName) {
        return classLoader.getResource(fileName).toString();
    }

    public static void createDirectories() throws IOException, JAXBException {
        File musics = new File("musics");
        if (!musics.exists()) {
            musics.mkdir();
        }
        File tour1 = new File("musics/tour1");
        if (!tour1.exists()) {
            tour1.mkdir();
        }
        File category1 = new File("musics/tour1/category1");
        if (!category1.exists()) {
            category1.mkdir();
        }
        File points10 = new File("musics/tour1/category1/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        JAXBContext jс = JAXBContext.newInstance(Melody.class);
        Marshaller m = jс.createMarshaller();
        m.setProperty("jaxb.formatted.output", Boolean.TRUE);//отступы
        File melody10 = new File("musics/tour1/category1/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        File points20 = new File("musics/tour1/category1/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        File melody20 = new File("musics/tour1/category1/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        File points30 = new File("musics/tour1/category1/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        File melody30 = new File("musics/tour1/category1/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        File points40 = new File("musics/tour1/category1/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        File melody40 = new File("musics/tour1/category1/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        File category2 = new File("musics/tour1/category2");
        if (!category2.exists()) {
            category2.mkdir();
        }
        points10 = new File("musics/tour1/category2/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour1/category2/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour1/category2/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour1/category2/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour1/category2/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour1/category2/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour1/category2/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour1/category2/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        File category3 = new File("musics/tour1/category3");
        if (!category3.exists()) {
            category3.mkdir();
        }
        points10 = new File("musics/tour1/category3/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour1/category3/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour1/category3/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour1/category3/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour1/category3/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour1/category3/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour1/category3/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour1/category3/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        File category4 = new File("musics/tour1/category4");
        if (!category4.exists()) {
            category4.mkdir();
        }
        points10 = new File("musics/tour1/category4/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour1/category4/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour1/category4/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour1/category4/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour1/category4/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour1/category4/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour1/category4/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour1/category4/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        File tour2 = new File("musics/tour2");
        if (!tour2.exists()) {
            tour2.mkdir();
        }
        category1 = new File("musics/tour2/category1");
        if (!category1.exists()) {
            category1.mkdir();
        }
        points10 = new File("musics/tour2/category1/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour2/category1/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour2/category1/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour2/category1/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour2/category1/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour2/category1/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour2/category1/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour2/category1/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        category2 = new File("musics/tour2/category2");
        if (!category2.exists()) {
            category2.mkdir();
        }
        points10 = new File("musics/tour2/category2/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour2/category2/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour2/category2/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour2/category2/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour2/category2/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour2/category2/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour2/category2/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour2/category2/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        category3 = new File("musics/tour2/category3");
        if (!category3.exists()) {
            category3.mkdir();
        }
        points10 = new File("musics/tour2/category3/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour2/category3/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour2/category3/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour2/category3/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour2/category3/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour2/category3/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour2/category3/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour2/category3/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        category4 = new File("musics/tour2/category4");
        if (!category4.exists()) {
            category4.mkdir();
        }
        points10 = new File("musics/tour2/category4/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour2/category4/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour2/category4/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour2/category4/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour2/category4/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour2/category4/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour2/category4/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour2/category4/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        File tour3 = new File("musics/tour3");
        if (!tour3.exists()) {
            tour3.mkdir();
        }
        category1 = new File("musics/tour3/category1");
        if (!category1.exists()) {
            category1.mkdir();
        }
        points10 = new File("musics/tour3/category1/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour3/category1/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour3/category1/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour3/category1/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour3/category1/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour3/category1/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour3/category1/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour3/category1/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        category2 = new File("musics/tour3/category2");
        if (!category2.exists()) {
            category2.mkdir();
        }
        points10 = new File("musics/tour3/category2/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour3/category2/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour3/category2/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour3/category2/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour3/category2/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour3/category2/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour3/category2/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour3/category2/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        category3 = new File("musics/tour3/category3");
        if (!category3.exists()) {
            category3.mkdir();
        }
        points10 = new File("musics/tour3/category3/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour3/category3/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour3/category3/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour3/category3/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour3/category3/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour3/category3/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour3/category3/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour3/category3/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        category4 = new File("musics/tour3/category4");
        if (!category4.exists()) {
            category4.mkdir();
        }
        points10 = new File("musics/tour3/category4/points10");
        if (!points10.exists()) {
            points10.mkdir();
        }
        melody10 = new File("musics/tour3/category4/points10/10.xml");
        if (!melody10.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody10);
        }
        points20 = new File("musics/tour3/category4/points20");
        if (!points20.exists()) {
            points20.mkdir();
        }
        melody20 = new File("musics/tour3/category4/points20/20.xml");
        if (!melody20.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody20);
        }
        points30 = new File("musics/tour3/category4/points30");
        if (!points30.exists()) {
            points30.mkdir();
        }
        melody30 = new File("musics/tour3/category4/points30/30.xml");
        if (!melody30.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody30);
        }
        points40 = new File("musics/tour3/category4/points40");
        if (!points40.exists()) {
            points40.mkdir();
        }
        melody40 = new File("musics/tour3/category4/points40/40.xml");
        if (!melody40.exists()) {
            m.marshal(new Melody("Название", "Автор"), melody40);
        }
        File supergame = new File("musics/supergame");
        if (!supergame.exists()) {
            supergame.mkdir();
        }
        File settings = new File("settings");
        if (!settings.exists()) {
            settings.mkdir();
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);//отступы
        File categories1 = new File("settings/categories1.xml");
        if (!categories1.exists()) {
            marshaller.marshal(new Categories("Категория 1", "Категория 2", "Категория 3", "Категория 4"), categories1);
        }
        File categories2 = new File("settings/categories2.xml");
        if (!categories2.exists()) {
            marshaller.marshal(new Categories("Категория 1", "Категория 2", "Категория 3", "Категория 4"), categories2);
        }
        File categories3 = new File("settings/categories3.xml");
        if (!categories3.exists()) {
            marshaller.marshal(new Categories("Категория 1", "Категория 2", "Категория 3", "Категория 4"), categories3);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.UNDECORATED);
        MainPane mainPane = new MainPane();
        GamePane gamePane = new GamePane();
        Tour1Pane tour1Pane = new Tour1Pane();
        SettingsPane settingsPane = new SettingsPane();
        SettingsTour1Pane settingsTour1Pane = new SettingsTour1Pane();
        SettingsTour1Category1Pane settingsTour1Category1Pane = new SettingsTour1Category1Pane();
        SettingsTour1Category2Pane settingsTour1Category2Pane = new SettingsTour1Category2Pane();
        SettingsTour1Category3Pane settingsTour1Category3Pane = new SettingsTour1Category3Pane();
        SettingsTour1Category4Pane settingsTour1Category4Pane = new SettingsTour1Category4Pane();
        SettingsTour2Pane settingsTour2Pane = new SettingsTour2Pane();
        SettingsTour2Category1Pane settingsTour2Category1Pane = new SettingsTour2Category1Pane();
        SettingsTour2Category2Pane settingsTour2Category2Pane = new SettingsTour2Category2Pane();
        SettingsTour2Category3Pane settingsTour2Category3Pane = new SettingsTour2Category3Pane();
        SettingsTour2Category4Pane settingsTour2Category4Pane = new SettingsTour2Category4Pane();
        SettingsTour3Pane settingsTour3Pane = new SettingsTour3Pane();
        SettingsTour3Category1Pane settingsTour3Category1Pane = new SettingsTour3Category1Pane();
        SettingsTour3Category2Pane settingsTour3Category2Pane = new SettingsTour3Category2Pane();
        SettingsTour3Category3Pane settingsTour3Category3Pane = new SettingsTour3Category3Pane();
        SettingsTour3Category4Pane settingsTour3Category4Pane = new SettingsTour3Category4Pane();
        //SettingsSuperGamePane settingsSuperGamePane = new SettingsSuperGamePane();
        primaryStage.setTitle("Угадай мелодию!");
        primaryStage.getIcons().add(new Image(getResource("images/16.png")));
        primaryStage.setScene(mainPane.getMainScene());
        primaryStage.setWidth(SCREEN_SIZE.getWidth());
        primaryStage.setHeight(SCREEN_SIZE.getHeight());
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
        primaryStage.show();
        mainPane.getGameLabel().setOnMouseClicked(event -> {
            primaryStage.setScene(gamePane.getGameScene());
            primaryStage.setTitle("Игра");
        });
        mainPane.getSettingsLabel().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsPane.getSettingsScene());
            primaryStage.setTitle("Настройки");
        });
        gamePane.getBackLabel().setOnMouseClicked(event -> {
            primaryStage.setScene(mainPane.getMainScene());
            primaryStage.setTitle("Угадай мелодию!");
        });
        gamePane.getTour1Label().setOnMouseClicked(event -> {
            primaryStage.setScene(tour1Pane.getTour1Scene());
            primaryStage.setTitle("1 тур");
        });
        mainPane.getExitLabel().setOnMouseClicked(event -> primaryStage.close());
        mainPane.getMainScene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        gamePane.getGameScene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        tour1Pane.getTour1Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsPane.getBackLabel().setOnMouseClicked(event -> {
            primaryStage.setScene(mainPane.getMainScene());
            primaryStage.setTitle("Угадай мелодию!");
        });
        settingsPane.getSettingsScene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsPane.getSettingsTour1Label().setOnMouseClicked(event -> {
            settingsTour1Pane.update();
            primaryStage.setScene(settingsTour1Pane.getSettingsTour1Scene());
            primaryStage.setTitle("Настройки 1го тура");
        });
        settingsPane.getSettingsTour2Label().setOnMouseClicked(event -> {
            settingsTour2Pane.update();
            primaryStage.setScene(settingsTour2Pane.getSettingsTour2Scene());
            primaryStage.setTitle("Настройки 2го тура");
        });
        settingsPane.getSettingsTour3Label().setOnMouseClicked(event -> {
            settingsTour3Pane.update();
            primaryStage.setScene(settingsTour3Pane.getSettingsTour3Scene());
            primaryStage.setTitle("Настройки 3го тура");
        });
        /*settingsPane.getSettingsSuperGameLabel().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsSuperGamePane.getSettingsSuperGameScene());
            primaryStage.setTitle("Настройки супер-игры");
        });*/
        settingsTour1Pane.getSettingsTour1Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour2Pane.getSettingsTour2Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour3Pane.getSettingsTour3Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        /*settingsSuperGamePane.getSettingsSuperGameScene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });*/
        settingsTour1Pane.getCategory1Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour1Category1Pane.getSettingsTour1Category1Scene());
            settingsTour1Category1Pane.start();
        });
        settingsTour1Pane.getCategory2Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour1Category2Pane.getSettingsTour1Category2Scene());
        });
        settingsTour1Pane.getCategory3Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour1Category3Pane.getSettingsTour1Category3Scene());
        });
        settingsTour1Pane.getCategory4Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour1Category4Pane.getSettingsTour1Category4Scene());
        });
        settingsTour1Pane.getBackLabel().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsPane.getSettingsScene());
            primaryStage.setTitle("Настройки");
        });
        settingsTour1Category1Pane.getSettingsTour1Category1Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour1Category2Pane.getSettingsTour1Category2Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour1Category3Pane.getSettingsTour1Category3Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour1Category4Pane.getSettingsTour1Category4Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour2Pane.getCategory1Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour2Category1Pane.getSettingsTour2Category1Scene());
        });
        settingsTour2Pane.getCategory2Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour2Category2Pane.getSettingsTour2Category2Scene());
        });
        settingsTour2Pane.getCategory3Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour2Category3Pane.getSettingsTour2Category3Scene());
        });
        settingsTour2Pane.getCategory4Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour2Category4Pane.getSettingsTour2Category4Scene());
        });
        settingsTour2Pane.getBackLabel().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsPane.getSettingsScene());
            primaryStage.setTitle("Настройки");
        });
        settingsTour2Category1Pane.getSettingsTour2Category1Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour2Category2Pane.getSettingsTour2Category2Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour2Category3Pane.getSettingsTour2Category3Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour2Category4Pane.getSettingsTour2Category4Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour3Pane.getCategory1Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour3Category1Pane.getSettingsTour3Category1Scene());
        });
        settingsTour3Pane.getCategory2Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour3Category2Pane.getSettingsTour3Category2Scene());
        });
        settingsTour3Pane.getCategory3Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour3Category3Pane.getSettingsTour3Category3Scene());
        });
        settingsTour3Pane.getCategory4Label().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsTour3Category4Pane.getSettingsTour3Category4Scene());
        });
        settingsTour3Pane.getBackLabel().setOnMouseClicked(event -> {
            primaryStage.setScene(settingsPane.getSettingsScene());
            primaryStage.setTitle("Настройки");
        });
        settingsTour3Category1Pane.getSettingsTour3Category1Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour3Category2Pane.getSettingsTour3Category2Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour3Category3Pane.getSettingsTour3Category3Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour3Category4Pane.getSettingsTour3Category4Scene().setOnKeyPressed(event -> {
            if (event.getCode().getName().equals("Esc")) {
                primaryStage.close();
            }
            if (event.getCode().getName().equals("Windows")) {
                primaryStage.setIconified(true);
            }
        });
        settingsTour1Category1Pane.getBackLabel().setOnMouseClicked(event -> {
            settingsTour1Category1Pane.back();
            settingsTour1Pane.update();
            primaryStage.setScene(settingsTour1Pane.getSettingsTour1Scene());
            primaryStage.setTitle("Настройки 1го тура");
        });
    }
}
