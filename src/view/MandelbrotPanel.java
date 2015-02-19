package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Phil on 2/18/2015.
 */
public class MandelbrotPanel extends JPanel {
    private final Color BASE_COLOR = Color.GREEN;
    private final int COLOR_SCALER = 10;

    private int[][] pixelMatrix;

    public MandelbrotPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    public void setPixels(int[][] pixelMatrix) {
        this.pixelMatrix = pixelMatrix;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int row = 0; row < pixelMatrix.length; row++) {
            for (int col = 0; col < pixelMatrix[row].length; col++) {
                //chose a color based on the number of iterations
                //required to exclude from the Mandelbrot set
                g.setColor(new Color(BASE_COLOR.getRGB() * pixelMatrix[row][col]*COLOR_SCALER));
                g.fillRect(col, row, 1, 1);
            }
        }
    }
}
