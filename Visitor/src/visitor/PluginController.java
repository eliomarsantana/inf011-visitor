package visitor;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import visitor.interfaces.ICore;
import visitor.interfaces.IPlugin;
import visitor.interfaces.IPluginController;

/**
 *
 * @author Eliomar Santana
 */
public class PluginController implements IPluginController{

    public PluginController(){
        allPlugins = new ArrayList<IPlugin>();
    }

    @Override
    public void initialize(ICore core){
        try {
            // Encontra a pasta plugins
            File currentDir = new File("./plugins");
            // Obtem todos os arquivos dentro desta pasta
            String[] plugins = currentDir.list();
            // Criar um array de URL do mesmo tamanho do anterior
            URL[] jars = new URL[plugins.length];
            // Loop para popular o array jars
            for (int i = 0; i < plugins.length; i++)
                jars[i] = (new File("./plugins/" + plugins[i])).toURI().toURL();
            // Adiciona todos os jars (plugins) no CLASSPATH
            URLClassLoader ulc = new URLClassLoader(jars);
            // Loop para inicialicao dos plugins
            IPlugin iplugin = null;
            String pluginName;
            for (String plugin : plugins) {
                if (plugin.endsWith(".jar")) {
                    pluginName = plugin.split("\\.")[0];
                    try {
                        iplugin = (IPlugin) Class.forName("visitor." + pluginName, true, ulc).newInstance();
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                        Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (iplugin != null)
                        iplugin.initialize(core);
                    allPlugins.add(iplugin);
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public ArrayList<IPlugin> loadedPlugins() {
        return allPlugins;
    }
    private ArrayList<IPlugin> allPlugins;
}
