/* Project updated August 2013 by ISU Students Justin Hanley, Daniel Greg Tyler,
 * and Josh Newell for the purpose of the NE 4499 course.  The alternate interface
 * titled Volume Viewer will allow the user to rotate 3-D images on the x, y, and
 * z axises.
 * #%L
 * ImageJ software for multidimensional image processing and analysis.
 * %%
 * Copyright (C) 2009 - 2013 Board of Regents of the University of
 * Wisconsin-Madison, Broad Institute of MIT and Harvard, and Max Planck
 * Institute of Molecular Cell Biology and Genetics.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are
 * those of the authors and should not be interpreted as representing official
 * policies, either expressed or implied, of any organization.
 * #L%
 */


package imagej;
 
/**
 * Launches ImageJ.
 * 
 * @author Curtis Rueden
 */
public final class Main {

	private Main() {
		// prevent instantiation of utility class
	}

	/**
	 * Launches a new instance of ImageJ.
	 * 
	 * @param args The arguments to pass to the new ImageJ instance.
	 * @return The context of the newly launched ImageJ instance.
	 */
	public static ImageJ launch(final String... args) {
		final ImageJ ij = new ImageJ();

		// parse command line arguments
		ij.console().processArgs(args);

		// display the user interface
		ij.ui().showUI();
                //ij.command().run(Volume_Viewer.class);
                //ij.command().run(SpaceNavPlugin.class);

		return ij;
	}

	public static void main(final String... args) {
		launch(args);
	}

}
