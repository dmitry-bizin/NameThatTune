package controller;

import dao.CategoryDAO;
import dao.DAO;
import entity.Category;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import util.UIUtil;

import java.util.List;
import java.util.stream.Collectors;

abstract class AbstractSettingsRoundController {

    private static final DAO<Category> CATEGORY_DAO = new CategoryDAO();

    void initialize(Label category1Label, Label category2Label, Label category3Label,
                    Label category4Label, Label backLabel, int roundNumber) {

        List<Category> categoryList = CATEGORY_DAO.readAll().stream()
                .filter(category -> category.getRoundId() == roundNumber)
                .collect(Collectors.toList());

        category1Label.setText(categoryList.get(0).getTitle());
        category1Label.setLayoutX(UIUtil.getWidth() * 0.01);
        category1Label.setLayoutY(UIUtil.getHeight() * 0.1);

        category2Label.setText(categoryList.get(1).getTitle());
        category2Label.setLayoutX(UIUtil.getWidth() * 0.01);
        category2Label.setLayoutY(UIUtil.getHeight() * 0.2);

        category3Label.setText(categoryList.get(2).getTitle());
        category3Label.setLayoutX(UIUtil.getWidth() * 0.01);
        category3Label.setLayoutY(UIUtil.getHeight() * 0.3);

        category4Label.setText(categoryList.get(3).getTitle());
        category4Label.setLayoutX(UIUtil.getWidth() * 0.01);
        category4Label.setLayoutY(UIUtil.getHeight() * 0.4);

        backLabel.setLayoutX(UIUtil.getWidth() * 0.01);
        backLabel.setLayoutY(UIUtil.getHeight() * 0.5);
    }

    // todo: обновлять названия лейблов после изменения в настройках (проверить, что работает)
    /*public void update() {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("settings/categories1.xml"), "UTF-8")) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Categories.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            categories = (Categories) unmarshaller.unmarshal(inputStreamReader);
            category1Label.setText(categories.getCategory1());
            category2Label.setText(categories.getCategory2());
            category3Label.setText(categories.getCategory3());
            category4Label.setText(categories.getCategory4());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }*/

    void handleBackLabelClick(Pane pane) {
        UIUtil.changeSceneToSettings(pane);
    }

}
