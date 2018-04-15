package ru.pearx.carbide.javafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Created by mrAppleXZ on 15.04.18 11:39.
 */
public final class FXUtils
{
    private FXUtils() {}

    public static HBox createHalign(Node node, Pos align)
    {
        HBox box = new HBox();
        box.setAlignment(align);
        box.getChildren().add(node);
        return box;
    }

    public static void setSpacingAndPadding(VBox box, double value)
    {
        box.setSpacing(value);
        box.setPadding(new Insets(value, value, value, value));
    }

    public static void setMinSize(Stage stage, double width, double height)
    {
        stage.setMinWidth(width);
        stage.setMinHeight(height);
    }

    public static void setSize(Stage stage, double width, double height)
    {
        stage.setWidth(width);
        stage.setHeight(height);
    }
}
