package imagej.core.plugins.assign;

//
//InplaceUnaryTransformation.java
//

/*
ImageJ software for multidimensional image processing and analysis.

Copyright (c) 2010, ImageJDev.org.
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
 * Neither the names of the ImageJDev.org developers nor the
   names of its contributors may be used to endorse or promote products
   derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
POSSIBILITY OF SUCH DAMAGE.
*/

import imagej.data.Dataset;
import imagej.util.IntRect;
import net.imglib2.img.ImgPlus;
import net.imglib2.ops.operation.TransformOperation;
import net.imglib2.ops.operator.UnaryOperator;
import net.imglib2.type.numeric.RealType;

/**
* Helper class for use by many plugins that apply a UnaryOperator to some input
* image. the run() method returns the output image that is the result of such a
* pixel by pixel application.
*/
public class InplaceUnaryTransform {
	
	// -- instance variables --
	
	private Dataset dataset;
	
	private TransformOperation operation;
	
	// -- constructor --
	
	public InplaceUnaryTransform(Dataset input, UnaryOperator operator)
	{
		dataset = input;
		ImgPlus<? extends RealType<?>> imgPlus = dataset.getImgPlus();
		operation = new TransformOperation(imgPlus, operator);
		long[] origin = new long[imgPlus.numDimensions()];
		long[] span = new long[imgPlus.numDimensions()];
		imgPlus.dimensions(span);
		operation.setRegion(origin, span);
	}
	
	// -- public interface --
	
	public void setRegion(long[] origin, long[] span) {
		operation.setRegion(origin, span);
	}
	
	public void run() {
		operation.execute();
		dataset.update();
	}
}