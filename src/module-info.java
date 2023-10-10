/**
 * 
 */
/**
 * 
 */
module EjercicioD {
	requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
	requires javafx.base;
    opens tablaPersona to javafx.graphics, javafx.fxml;
    opens model to javafx.fxml, javafx.base;
}