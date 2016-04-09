/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor.interfaces;

import java.util.ArrayList;

/**
 *
 * @author Eliomar Santana
 */
public interface IPluginController {
    public abstract ArrayList<IPlugin> loadedPlugins();
    public abstract void initialize(ICore core);
}
