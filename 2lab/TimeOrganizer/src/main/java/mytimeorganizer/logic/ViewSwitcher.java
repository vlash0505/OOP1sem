package mytimeorganizer.logic;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class that implements scene-switching
 * in order for user to switch between
 * different views.
 */

public class ViewSwitcher {
    private static Scene scene;
    //cache mechanism
    private static final Map<View, Parent> cache = new HashMap<>();

    /**
     * Setter for scene.
     *
     * @param scene scene to be set as one to
     *              which user will be moved.
     */

    public static void setScene(Scene scene) {
        ViewSwitcher.scene = scene;
    }

    /**
     * Method that switches scene to one given as a parameter
     * so that user now has requested view.
     *
     * @param view - scene to which user wants to switch.
     */

    public static void switchTo(View view) {
        try {
            Parent root;
            //if we already loaded the fxml file before,
            //pick it from cache.
            if(cache.containsKey(view)) {
                root = cache.get(view);
            } else {
                root = FXMLLoader.load(
                        Objects.requireNonNull(ViewSwitcher.class.getResource(view.getFilename()))
                );
                cache.put(view, root);
            }
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
