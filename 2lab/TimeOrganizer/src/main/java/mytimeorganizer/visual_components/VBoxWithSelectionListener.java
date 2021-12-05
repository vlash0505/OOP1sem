package mytimeorganizer.visual_components;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.VBox;

public class VBoxWithSelectionListener extends VBox {
    ObjectProperty<JFXButton> selectedButton = new SimpleObjectProperty<>();

    public VBoxWithSelectionListener() {
        super();
        setOnMouseClicked(e->selectButton(null));
        selectedButton.addListener((obs, newButton, oldButton) -> {
            if (oldButton != null) {
                oldButton.setStyle("");
            }
            if (newButton != null) {
                newButton.setStyle("-fx-background-color: blue;");
            }
        });
    }

    public void selectButton(JFXButton button) {
        selectedButton.set(button);
    }
}
