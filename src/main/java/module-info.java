module dev.okempi.todolist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens dev.okempi.todolist to javafx.fxml;
    exports dev.okempi.todolist.Controller;
    opens dev.okempi.todolist.Controller to javafx.fxml;
    exports dev.okempi.todolist.Model;
    opens dev.okempi.todolist.Model to javafx.fxml;
    exports dev.okempi.todolist.View;
    opens dev.okempi.todolist.View to javafx.fxml;
}