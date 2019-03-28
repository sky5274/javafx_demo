package com.fx.boot.view;

import java.net.URL;
import java.util.ResourceBundle;
import org.springframework.stereotype.Component;
import com.fx.boot.cache.SysCacheManager;
import com.fx.component.Dialog;
import com.fx.data.bundle.DataResourceBundle;
import com.fx.url.UrlManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@SuppressWarnings("restriction")
@Component
public class LoginView extends BaseView{
	@FXML
	private TextField userName;
	@FXML
	private PasswordField passwd;
	@FXML
	private Button comfrim;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location,resources);
	}
	
	public void checkContent() {
		log.debug("user:"+userName.getText());
		log.debug("passwd:"+passwd.getText());
		if(userName.getText().equals("")) {
			Dialog.alert("用户名不能为空");
		}else if(passwd.getText().equals("")) {
			Dialog.alert("密码不能为空");
		}else {
			DataResourceBundle<String> data=new DataResourceBundle<String>(stage);
			data.put("user", userName.getText());
			data.put("passwd", passwd.getText());
			SysCacheManager.put("userName", userName.getText());
			SysCacheManager.put("userpwd", passwd.getText());
			stage.navgicateTo(UrlManager.MAIN,data);
		}
		
	}

}
