package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import model.Album;
import model.User;

import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by XBBL7MK on 4/8/2017.
 */
public class userController {


    @FXML private Button renameButton;
    @FXML private Button deleteButton;
    @FXML private Button openButton;
    @FXML private Button searchButton;

    @FXML private Button AddAlbumButton;
    @FXML private Button AddTagButton;

    @FXML private TableColumn nameColumn;
    @FXML private TableColumn dateRangeColumn;
    @FXML private TableColumn dateModColumn;
    @FXML private TableColumn photoCountColumn;

    @FXML private TableColumn tagNameColumn;
    @FXML private TableColumn tagValueColumn;


    @FXML private TextField renameField;
    @FXML private TextField tagNameField;
    @FXML private TextField tagValueField;

    @FXML private DatePicker startDateInput;
    @FXML private DatePicker endDateInput;

    @FXML private TableView<Album> albumTable;


    @FXML
    public void initialize() throws IOException {
        selectionListener();

    }

    public void AddAlbum() throws IOException{
        Dialog<Album> dialog = new Dialog<>();
        dialog.setTitle("Create a New Album");
        dialog.setHeaderText("Add a new album to PhotoBox!");
        dialog.setResizable(false);



    }

    private void selectionListener() {
    }
}
