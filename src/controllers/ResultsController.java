package controllers;

import models.Arbol;

public class ResultsController {
    
    private Arbol<String> logicTree;

    public Arbol<String> getLogicTree() {
        return logicTree;
    }

    public void setLogicTree(Arbol<String> logicTree) {
        this.logicTree = logicTree;
    }
}
