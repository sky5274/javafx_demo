package com.fx;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.fx.boot.stage.FlowStage;
import com.fx.boot.view.LoadingProgessView;
import com.fx.component.ActionBuild;
import com.fx.component.AlertObjecAction;
import com.fx.component.AlertStringAction;
import com.fx.component.Dialog;
import com.fx.url.UrlManager;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;

/**
 * 项目启动
 *<p>Title: StartAppliction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月28日
 */
public class StartAppliction extends Application {
	public static FlowStage stage;
	private Log log=LogFactory.getLog(getClass());

	@Override
	public void start(Stage primaryStage) {
		stage= new FlowStage(primaryStage);
		log.debug("stage start");
		try {
			stage.navgicateTo(UrlManager.LOGIN);
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
		}
		//设置标题栏图标
		stage.getIcons().add(new Image("/img/bg_1.png"));
		stage.show();
//		try {
//			new Notice().show("exte");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Dialog.comfrim(new AlertStringAction("提示") {

			@Override
			public void success(ButtonType btnType) {
				log.debug(btnType);

			}
		});
		log.debug("load the progress");
		LoadingProgessView.load(stage);
		AlertObjecAction<String> alert = new ActionBuild<String>()
		.title("控制").content("是否关闭loadding")
		.before(()->{
			stage.getHeight();
		})
		.success((btn)->{
			log.debug("load progress closed");
			log.debug(btn.getText());
			LoadingProgessView.close(stage);
		})
		.build();
		Dialog.comfrim(alert);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
}
