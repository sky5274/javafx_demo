package com.fx.boot.view;

import java.net.URL;
import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.fx.boot.stage.FlowStage;
import com.fx.data.bundle.DataResourceBundle;
import javafx.fxml.Initializable;

@SuppressWarnings("restriction")
public class BaseView implements Initializable{
	public Log log=LogFactory.getLog(getClass());
	public FlowStage stage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(resources !=null && resources instanceof DataResourceBundle) {
			stage=((DataResourceBundle<?>)resources).getStage();
		}
		if(stage==null) {
			stage=new FlowStage();
		}
	}
}
