package mytimeorganizer.view_logic;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestSwitcher {
    private static Pane node;

    /**
     * Setter for pane.
     *
     * @param node scene to be set as one to
     *              which user will be moved.
     */

    public static void setPane(Pane node) {
        TestSwitcher.node = node;
    }

    /**
     * Method that switches scene to one given as a parameter
     * so that user now has requested view.
     *
     * @param view - scene to which user wants to switch.
     */

    public static void switchTo(View view) {
        Parent root = BaseSwitcher.getRoot(view);
        if(node.getChildren().contains(root)) return;
        node.getChildren().clear();
        node.getChildren().addAll(root);
    }
}
