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
        calculation += source.getText();

        solutionLabel.setText(calculation);
    }

    public void eval() {

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        String solution = "";

        try {
            solution = String.valueOf(engine.eval(calculation));
        } catch (ScriptException e) {
            e.printStackTrace();
            calculation = "";
        }

        solutionLabel.setText(solution);
        calculation = solution;
    }

    public void clear(){
        solutionLabel.setText("");
        calculation = "";
    }
}
