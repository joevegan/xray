/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagej;
import imagej.command.Command;
import imagej.ui.UIService;


import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;

@Plugin(type = Command.class, menuPath = 'Help>SpaceNavigator Support')
public class SpaceNavPlugin {
    
    @Parameter
    private UIService uiService;
    
    @Override
    public void run() {
        uiService.showDialog("SpaceNav3D Mouse Enabled");
    }
}
