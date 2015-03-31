/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theatre.controleur;

import java.beans.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Pierrick_2
 */
public class ChoiceBean implements Serializable {

    private int table;

    /**
     * Get the value of table
     *
     * @return the value of table
     */
    public int getTable() {
        return table;
    }

    /**
     * Set the value of table
     *
     * @param table new value of table
     */
    public void setTable(int table) {
        int old = table;
        this.table = table;
        propertySupport.firePropertyChange("table", old, table);
    }

    private LinkedList<String> actions;

    /**
     * Get the value of actions
     *
     * @return the value of actions
     */
    public LinkedList<String> getActions() {
        return actions;
    }

    /**
     * Set the value of actions
     *
     * @param actions new value of actions
     */
    public void setActions(LinkedList<String> actions) {
        this.actions = actions;
    }

    private int action;

    /**
     * Get the value of action
     *
     * @return the value of action
     */
    public int getAction() {
        return action;
    }

    /**
     * Set the value of action
     *
     * @param action new value of action
     */
    public void setAction(int action) {
        this.action = action;
    }

    private HashMap<Integer, String> result;

    /**
     * Get the value of result
     *
     * @return the value of result
     */
    public HashMap<Integer, String> getResult() {
        return result;
    }

    /**
     * Set the value of result
     *
     * @param result new value of result
     */
    public void setResult(HashMap<Integer, String> result) {
        this.result = result;
    }

    private PropertyChangeSupport propertySupport;

    public ChoiceBean() {
        propertySupport = new PropertyChangeSupport(this);
        actions = new LinkedList();
        actions.add("lol");
        actions.add("caca");
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
