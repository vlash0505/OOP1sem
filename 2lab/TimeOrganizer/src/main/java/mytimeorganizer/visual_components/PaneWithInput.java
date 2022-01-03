package mytimeorganizer.visual_components;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PaneWithInput extends AnchorPane {

    public PaneWithInput() {
        super();
        JFXButton b = new JFXButton("Add");
        b.setOnAction(e -> onAddButton());
        this.getChildren().addAll(new TextField(), b);
    }

    public void onAddButton() {
        this.getChildren().removeAll();
        this.getChildren().add(new JFXCheckBox());
    }
}
