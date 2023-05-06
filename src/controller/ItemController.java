package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import model.Fruit;

public class ItemController {
	@FXML
    private ImageView Img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;
    
    
    public void click(MouseEvent event) {
    	myListener.onClickListener(fruit);
    }
    
    private MyListener myListener;
    
    private Fruit fruit;
    
    public void setData(Fruit fruit, MyListener myListener) {
    	this.fruit = fruit;
    	this.myListener = myListener;
    	nameLabel.setText(fruit.getName());
    	priceLabel.setText(Main.currency + fruit.getPrice());
    	Image image = new Image(getClass().getResourceAsStream(fruit.getImg()));
    	Img.setImage(image);
    	
    }
}
