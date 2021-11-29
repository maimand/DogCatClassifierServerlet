package thread;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.datavec.image.loader.NativeImageLoader;
import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.util.ModelSerializer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.preprocessor.DataNormalization;
import org.nd4j.linalg.dataset.api.preprocessor.VGG16ImagePreProcessor;


public class VGG16 {
	private static VGG16 vgg16 = null;
	private static final String TRAINED_PATH_MODEL = "resources/model.zip";
	private ComputationGraph computationGraph;

	private VGG16() {
		try {
			this.computationGraph = loadModel();
			computationGraph.init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static VGG16 getVGG16() {
		if (vgg16 == null)
			vgg16 = new VGG16();
		return vgg16;
	}

	private ComputationGraph loadModel() throws IOException {
		computationGraph = ModelSerializer.restoreComputationGraph(new File(TRAINED_PATH_MODEL));
		return computationGraph;
	}
	
	public void predict(File imageFile) {
		new Prediction(computationGraph, imageFile);
	}

	
	class Prediction extends Thread {
		private ComputationGraph computationGraph;
		private final double threshold = 0.5;
		private File imageFile;
		
		public Prediction(ComputationGraph computationGraph, File imageFile) {
			this.computationGraph = computationGraph;
			this.imageFile = imageFile;
			this.start();
		}
		
		@Override
		public void run() {
			String result = predict(imageFile);
			// TODO: save status with image file path and user ID
			System.out.println(result);
			System.out.println(imageFile.getAbsolutePath());
			super.run();
		}
		
		public String predict(File imageFile) {
			NativeImageLoader loader = new NativeImageLoader(224, 224, 3);
			INDArray image;
			try {
				image = loader.asMatrix(new FileInputStream(imageFile));
				DataNormalization scaler = new VGG16ImagePreProcessor();
				scaler.transform(image);
				INDArray output = computationGraph.outputSingle(false, image);
				if (output.getDouble(0) > threshold) {
					return "This is a Cat";
				} else if (output.getDouble(1) > threshold) {
					return "This is a Dog";
				} else {
					return "Unknown";
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return "Unknown";
			} catch (IOException e) {
				e.printStackTrace();
				return "Unknown";
			}

		}
	}

}

