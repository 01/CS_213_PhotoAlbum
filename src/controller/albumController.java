package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

/**
 * Created by XBBL7MK on 4/8/2017.
 */
public class albumController {


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



}
