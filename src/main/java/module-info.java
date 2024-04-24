module sbu.cs.htmlparser {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires org.jsoup;

    opens sbu.cs.htmlparser to javafx.fxml;
    exports sbu.cs.htmlparser;
}