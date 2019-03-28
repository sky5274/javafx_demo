package com.fx;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.fx.boot.stage.FlowStage;
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
 * 主页面内容
 *<p>Title: IndexMainAppliction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月26日
 */
@SuppressWarnings("restriction")
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
		//添加页面图标
		stage.getIcons().add(new Image("resources/img/bg_1.png"));
		stage.show();
//		try {
//			new Notice().show("exte");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Dialog.comfrim(new AlertStringAction("是否删除？") {

			@Override
			public void success(ButtonType btnType) {
				log.debug(btnType);

			}
		});
		
		AlertObjecAction<String> alert = new ActionBuild<String>()
		.title("ceshi").content("lai ba ceshi yixia")
		.before(()->{
			stage.getHeight();
		})
		.success((btn)->{
			log.debug(btn.getText());
		})
		.build();
		Dialog.comfrim(alert);
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
}
