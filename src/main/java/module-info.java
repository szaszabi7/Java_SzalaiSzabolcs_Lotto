module com.example.szalaiszabolcs_lotto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.szalaiszabolcs_lotto to javafx.fxml;
    exports com.example.szalaiszabolcs_lotto;
}