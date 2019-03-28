package com.fx.component;

import java.util.Optional;

import org.springframework.util.StringUtils;

import com.fx.component.AlertAction;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

/**
 * 提示\操作框调用方法
 *<p>Title: Dialog.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年3月28日
 */
public class Dialog {
	public static void alert(String cont) {
		Alert alert = new Alert(AlertType.NONE,cont,new ButtonType("确定",ButtonData.YES));
		alert.setTitle("提示");
		alert.show();
	}
	
	public static <T> void comfrim(AlertAction<T> con) {
		Alert alert = new Alert(AlertType.CONFIRMATION,null,new ButtonType("确认",ButtonData.YES),new ButtonType("关闭",ButtonData.CANCEL_CLOSE));
		alert.setTitle(StringUtils.isEmpty(con.getTitle())?"提示":con.getTitle());
		if (con.getContent() instanceof String) {
			alert.setContentText(con.getContent().toString());
		}else if(con.getContent() instanceof DialogPane) {
			alert.setDialogPane((DialogPane)con.getContent());
		}
		Optional<ButtonType> opt = alert.showAndWait();
		con.success(opt.get());
	}
}
