package controller;


import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CalculatorController {

    private String calculation = new String();

    @FXML
    private Label solutionLabel;

    public void mouseClick(Event e){
        Button source = (Button) e.getSource();
        System.out.println(source.getText());
        calculation += source.getText();

        solutionLabel.setText(calculation);
    }

    public void eval() throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        solutionLabel.setText(String.valueOf(engine.eval(calculation)));
        calculation = "";
    }

    public void clear(){
        solutionLabel.setText("");
    }
}
