/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagej;

import imagej.command.Command;
import imagej.ui.UIService;

import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import imagej.display.event.input.InputEvent;
//import SpaceNav; // needed for the 3DConnexion Mouse APIs

@Plugin(type = Command.class, menuPath = "Help>SpaceNav 3D Mouse")
public class SpaceNavPlugin implements Command {


	@Parameter
	private UIService uiService;
        private InputEvent ijInput;
        
        //private SpaceNav spaceNav;
        
        public SpaceNavPlugin(){
            /* 
            spaceNav = new SpaceNav();
            spaceNav.waitForEvent();
             
            */ 
        }
        public void SpaceNavEventOccured(){
            
        }

	@Override
	public void run() {
		uiService.showDialog("3D Mouse Enabled");
	}
}