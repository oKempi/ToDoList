module dev.okempi.todolist {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens dev.okempi.todolist to javafx.fxml;
    exports dev.okempi.todolist.Controller;
    exports dev.okempi.todolist.Model;
    exports dev.okempi.todolist.View;
}