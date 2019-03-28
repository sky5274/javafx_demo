package com.fx.boot.view;

import java.net.URL;
import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.fx.boot.stage.FlowStage;
import com.fx.data.bundle.DataResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class BaseView implements Initializable{
	public Log log=LogFactory.getLog(getClass());
	public FlowStage stage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(resources !=null && resources instanceof DataResourceBundle) {
			Stage tempstage = ((DataResourceBundle<?>)resources).getStage();
			if(tempstage instanceof FlowStage) {
				stage=(FlowStage)tempstage;
			}else {
				stage=new FlowStage(tempstage);
			}
		}
		if(stage==null) {
			stage=new FlowStage();
		}
	}
}
