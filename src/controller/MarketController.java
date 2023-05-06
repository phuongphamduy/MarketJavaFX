package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import main.Main;
import model.Fruit;

public class MarketController implements Initializable {

    @FXML
    private VBox chosenFruitCard;

    @FXML
    private ImageView fruitImg;

    @FXML
    private Label fruitNameLabel;

    @FXML
    private Label fruitPriceLabel;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    
    private List<Fruit> list = new ArrayList<>();
    
    private MyListener myListener;
    
    private List<Fruit> getData() {
    	List<Fruit> list = new ArrayList<>();
    	Fruit fruit;
    	
    	fruit = new Fruit();
        fruit.setName("Kiwi");
        fruit.setPrice(2.99);
        fruit.setImg("/image/kiwi.png");
        fruit.setColor("6A7324");
        list.add(fruit);

        fruit = new Fruit();
        fruit.setName("Coconut");
        fruit.setPrice(3.99);
        fruit.setImg("/image/coconut.png");
        fruit.setColor("A7745B");
        list.add(fruit);

        fruit = new Fruit();
        fruit.setName("Peach");
        fruit.setPrice(1.50);
        fruit.setImg("/image/peach.png");
        fruit.setColor("F16C31");
        list.add(fruit);

        fruit = new Fruit();
        fruit.setName("Grapes");
        fruit.setPrice(0.99);
        fruit.setImg("/image/grapes.png");
        fruit.setColor("291D36");
        list.add(fruit);

        fruit = new Fruit();
        fruit.setName("Watermelon");
        fruit.setPrice(4.99);
        fruit.setImg("/image/watermelon.png");
        fruit.setColor("22371D");
        list.add(fruit);

        fruit = new Fruit();
        fruit.setName("Orange");
        fruit.setPrice(2.99);
        fruit.setImg("/image/orange.png");
        fruit.setColor("FB5D03");
        list.add(fruit);

        fruit = new Fruit();
        fruit.setName("StrawBerry");
        fruit.setPrice(0.99);
        fruit.setImg("/image/strawberry.png");
        fruit.setColor("80080C");
        list.add(fruit);

        fruit = new Fruit();
        fruit.setName("Mango");
        fruit.setPrice(0.99);
        fruit.setImg("/image/mango.png");
        fruit.setColor("FFB605");
        list.add(fruit);

        fruit = new Fruit();
        fruit.setName("Cherry");
        fruit.setPrice(0.99);
        fruit.setImg("/image/cherry.png");
        fruit.setColor("5F060E");
        list.add(fruit);

        fruit = new Fruit();
        fruit.setName("Banana");
        fruit.setPrice(1.99);
        fruit.setImg("/image/banana.png");
        fruit.setColor("E7C00F");
        list.add(fruit);
    	
    	return list;
    }
    
    private void chosenFruit(Fruit fruit) {
    	fruitNameLabel.setText(fruit.getName());
    	fruitPriceLabel.setText(Main.currency + fruit.getPrice());
    	Image image = new Image(getClass().getResourceAsStream(fruit.getImg()));
    	fruitImg.setImage(image);
    	chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n"
    			+ "	-fx-background-radius: 30;");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		list.addAll(getData());
		if(list.size() > 0) {
			chosenFruit(list.get(0));
			myListener = new MyListener() {
				
				@Override
				public void onClickListener(Fruit fruit) {
					chosenFruit(fruit);
					
				}
			};
		}
		int column = 0;
		int row = 1;
		try {
			for(int i = 0; i < list.size();i++) {
				FXMLLoader fxmlloader = new FXMLLoader();
				fxmlloader.setLocation(getClass().getResource("/view/item.fxml"));
				AnchorPane anchorPane = fxmlloader.load();
				
				if(column == 3) {
					column = 0;
					row++;
				}
				ItemController itemController = fxmlloader.getController();
				itemController.setData(list.get(i), myListener);
				
				grid.add(anchorPane, column++, row);
				
				GridPane.setMargin(anchorPane, new Insets(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
