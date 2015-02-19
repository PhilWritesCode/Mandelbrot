import resources.ComplexNumber;
import utilities.MandelbrotUtilities;
import view.MandelbrotPanel;

import javax.swing.*;
import java.awt.*;

class Mandelbrot {

    private static final String FRAME_TITLE = "Mandelbrot Set!";
    private static final String SCALING_STARTING = "Scaling...";
    private static final String PROCESSING_STARTING = "Processing...";
    private static final String SEGMENT_COMPLETE = "done!";


    /**
     *	Displays the Mandelbrot Set for bounds passed as arguments
     * 	args[0] = upper left real point on the Complex plane
     * 	args[1] = upper left imaginary point on the Complex plane
     * 	args[2] = lower right real point on the Complex plane
     * 	args[3] = lower right imaginary point on the Complex plane
     *
     * 	Complex Plane:
     * 	                  ^
     * 	(args[0],args[1]) |
     * 	                  |
     * 	                  |
     * 	                  |
     * 	                  |
     * 	                  |
     * 	                  |-----------------> (args[2],args[3])
     *
     * Sample input include:
     * -2 1.5 1 -1.5 for the full set
     * -0.736 0.226 -0.726 0.214 for a small sample
     * .2869 .01429 .2870 .01427 for an interesting perspective
     **/
    public static void main(String [] args) {

        if(args == null || args.length < 4) {
            throw new IllegalArgumentException("Invalid Arguments.  Please provide four values, representing boundaries on the Complex Plane");
        }

        // Set boundaries for graph
        float upperLeftReal = Float.parseFloat(args[0]);
        float upperLeftImaginary = Float.parseFloat(args[1]);
        float lowerRightReal = Float.parseFloat(args[2]);
        float lowerRightImaginary = Float.parseFloat(args[3]);

        /**
         * Scale numbers for visibility.
         *
         * If neither axis on the given plane is at least 1000px, we double the size of the graph.  Continue doubling
         * until at least one axis reaches 1000px.  This effectively "zooms in" on the portion of the Mandelbrot Set
         * defined by the arguments.
         */
        System.out.print(SCALING_STARTING);
        int scalingFactor = 0;
        while(lowerRightReal - upperLeftReal < 1000 && upperLeftImaginary - lowerRightImaginary < 1000) {
            scalingFactor++;
            upperLeftReal *= 2;
            upperLeftImaginary *= 2;
            lowerRightReal *= 2;
            lowerRightImaginary *= 2;
        }
        System.out.println(SEGMENT_COMPLETE);

        int[][] pixelMatrix = generatePixelMap(upperLeftReal, upperLeftImaginary, lowerRightReal, lowerRightImaginary, scalingFactor);
        createAndShowGUI(pixelMatrix);
    }

    /**
     * Create a 2-dimensional pixelMatrix containing integers defining how many iterations it takes to exclude a given point
     * on the complex plane from the Mandelbrot Set.  Each point in this pixelMatrix represents a point within the boundaries of the complex
     * plane provided by the parameters to this application.
     */
    private static int[][] generatePixelMap(float upperLeftReal, float upperLeftImaginary, float lowerRightReal, float lowerRightImaginary, int scalingFactor) {
        System.out.print(PROCESSING_STARTING);

        int[][] pixelMatrix = new int[(int)(upperLeftImaginary - lowerRightImaginary)+1][(int)(lowerRightReal - upperLeftReal)+1];
        int pixelRow = 0,pixelCol = 0;

        for(float row = upperLeftImaginary; row > lowerRightImaginary; row--, pixelRow++, pixelCol = 0) {
            for(float col = upperLeftReal; col < lowerRightReal; col++, pixelCol++) {
                pixelMatrix[pixelRow][pixelCol] = MandelbrotUtilities.iterationsToExcludeFromMandelbrotSet(new ComplexNumber(col / Math.pow(2, scalingFactor), row / Math.pow(2, scalingFactor)));
            }
        }

        System.out.println(SEGMENT_COMPLETE);

        return pixelMatrix;
    }

    private static void createAndShowGUI(int[][] pixelMatrix) {
        JFrame frame = new JFrame(FRAME_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MandelbrotPanel panel = new MandelbrotPanel();
        panel.setPixels(pixelMatrix);
        panel.setPreferredSize(new Dimension(pixelMatrix[0].length, pixelMatrix.length));
        JScrollPane scrollablePane = new JScrollPane(panel);
        frame.add(scrollablePane);
        frame.setSize(panel.getPreferredSize());
        frame.setVisible(true);
    }
}