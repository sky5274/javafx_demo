package com.fx.boot.view;

import java.net.URL;

import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.fx.boot.cache.SysCacheManager;
import com.fx.component.Dialog;
import com.fx.data.bundle.DataResourceBundle;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
@SuppressWarnings("restriction")
@Component
public class MainView extends BaseView {
	@FXML
	private Label userName;
	@FXML
	private Button loginOut;
	@FXML
	private HBox tabBox;
	@FXML
	private AnchorPane content;
	@FXML
	private ScrollPane btnTab;
	private Log log=LogFactory.getLog(getClass());
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
		userName.setText(((DataResourceBundle<String>)resources).get("user").toString());
		//初始化元素
		initEvn();
		loginOut.setOnMouseClicked((e)->{
			log.debug(e.toString());
			System.err.println((String)SysCacheManager.get("userpwd"));
			Dialog.alert("是否退出");
		});
	}
	private void initEvn() {
		int size=15;
		
		for(int i=0;i<size;i++) {
			Button btn=new Button(""+i);
			btn.setTooltip(new Tooltip("value="+i));
			btn.setPadding(new Insets(5, 15, 5, 15));
			btn.setOnMouseClicked(e->{
				content.getChildren().clear();
				content.getChildren().add(new Label("content value:"+btn.getText()));
			});
			tabBox.getChildren().add(btn);
		}
		btnTab.setHmax(size);
	}

}
