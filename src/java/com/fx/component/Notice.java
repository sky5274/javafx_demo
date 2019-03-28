package com.fx.component;

import java.awt.Toolkit;
import java.io.IOException;

import com.fx.boot.load.BootView;
import com.fx.url.UrlManager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Notice {
	
	public void show(String content) throws IOException {
		Stage stage=new Stage(StageStyle.TRANSPARENT);
		int width=300;
		int heigth=100;
		stage.setWidth(width);
		stage.setHeight(heigth);
		stage.setY(Toolkit.getDefaultToolkit().getScreenSize().getHeight()-heigth-50);
		stage.setX(Toolkit.getDefaultToolkit().getScreenSize().getWidth()-width);
		FXMLLoader fxml=BootView.getViewLoad(UrlManager.Notify);
		Scene scence=new Scene((Parent)fxml.load());
		stage.setScene(scence);
		stage.show();
	}
}
