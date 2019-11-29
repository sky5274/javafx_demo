package com.fx.boot.view;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 加载状态视图方法
 *<p>Title: LoadingProgessView.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: </p>
 * @author sky
 * @date 2019年11月29日
 */
public class LoadingProgessView {
	private static ProgressIndicator progressIndicator;
	private static String LOAD_PANE_ID="load_panel";
	private static String LOAD_PROGRESS_ID="load_progress";

	private static Pane getPane(Node node) {
		Pane pane = null;
		if(node instanceof Pane) {
			pane=(Pane) node;
		}else if(node.getParent() instanceof Pane) {
			pane=(Pane) node.getParent();
		}
		return pane;
	}
	private static Pane getPane(Stage stage) {
		Pane pane = null;
		try {
			Parent root = stage.getScene().getRoot();
			if(root instanceof Pane) {
				pane=(Pane)root;
			}
		}catch (Exception e) {
		}
		return pane;
	}

	public static void close(Node node) {
		Pane pane = getPane(node);
		if(pane !=null) {
			pane.getChildren().removeIf(n-> LOAD_PANE_ID.equals(n.getId()) || LOAD_PROGRESS_ID.equals(n.getId()));
		}
	}
	public static void close(Stage stage) {
		Pane pane = getPane(stage);
		if(pane !=null) {
			pane.getChildren().removeIf(n-> LOAD_PANE_ID.equals(n.getId()) || LOAD_PROGRESS_ID.equals(n.getId()));
		}
	}

	public static void load(Node node) {
		progressIndicator=loadProgress();
		node.getParent().getChildrenUnmodifiable().add(progressIndicator);
	}

	public static void load(Stage stage) {
		Pane root = getPane(stage);
		if(root !=null) {
			Pane pane=new Pane();
			progressIndicator=loadProgress();
			pane.setBackground(new Background(new BackgroundFill(Color.GRAY,null,null)));
			pane.setId(LOAD_PANE_ID);
			pane.setOpacity(0.7);
			pane.setPrefWidth(root.getWidth());
			pane.setPrefHeight(root.getHeight());
			progressIndicator.setLayoutX(pane.getPrefWidth()/2-progressIndicator.getPrefWidth()/2-progressIndicator.getPadding().getLeft());
			progressIndicator.setLayoutY(pane.getPrefHeight()/2-progressIndicator.getPrefHeight()/2-progressIndicator.getPadding().getTop());
			pane.getChildren().add(progressIndicator);
			root.getChildren().add(pane);
			if(!stage.isShowing()) {
				stage.show();
			}
			
		}
	}

	public static void load(Stage stage,String tips) {
		Pane root = getPane(stage);
		if(root !=null) {
			Pane pane=new Pane();
			VBox box = loadByTips(tips);
			pane.setBackground(new Background(new BackgroundFill(Color.GRAY,null,null)));
			pane.setId(LOAD_PANE_ID);
			pane.setPrefWidth(stage.getWidth());
			pane.setPrefHeight(stage.getHeight());
			box.setLayoutX(pane.getPrefWidth()/2-box.getPrefWidth()/2);
			box.setLayoutY(pane.getPrefHeight()/2-box.getPrefHeight()/2);
			pane.getChildren().add(box);
			root.getChildren().add(pane);
		}
	}

	public static ProgressIndicator loadProgress() {
		ProgressIndicator progressIndicator=new ProgressIndicator();
		progressIndicator.setId(LOAD_PROGRESS_ID);
		progressIndicator.setProgress(-1F);
		return progressIndicator;
	}

	public static VBox loadByTips(String tips) {
		Label label = new Label(tips);
		label.setTextFill(Color.BLUE);
		ProgressIndicator progressIndicator=loadProgress();
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setBackground(Background.EMPTY);
		vBox.getChildren().addAll(progressIndicator,label);
		return vBox;
	}
}
