package projectalgorithmsortingvisualiaser;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Random;

public class pnlAnimation extends JPanel {
   
    
    private static final long serialVersionUID = 1L;
    final private int DEFAULT_WIN_WIDTH = 1030;
    final private int DEFAULT_WIN_HEIGHT = 720;
    private static final double BAR_HEIGHT_PERCENT = 680 / 720.0;
    final private int BAR_WIDTH = 5;

    public int numbars = DEFAULT_WIN_WIDTH / BAR_WIDTH;

    int arr[], barColor[];

    public pnlAnimation() {
        setSize(1080, 720);
        arr = new int[numbars];
        barColor = new int[numbars];

        for (int i = 0; i < numbars; i++) {
           arr[i] = i;
           barColor[i] = 0;
       }
    }

    public int getLength() {
         return (int) arr.length;
    }

    public int getValue(int i) {
         return arr[i];
    }

    public void reset() {
       shuffle();
       resetColors();
    }

    public void shuffle() {
        Random rnd = new Random();
        for (int i = 0; i < numbars; i++) {
           swap(i, rnd.nextInt(numbars - 1));
        }
    }

    public void resetColors() {
         for (int i = 0; i < numbars; i++) {
            barColor[i] = 0;
         }
         repaint();
    }

    public void swap(int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
        barColor[x] = 100;
        barColor[y] = 100;
        repaint(12);
    }

     public void update(int x, int value) {
        arr[x] = value;
        barColor[x] = 100;
        repaint(12);
     }

     @Override
     public void repaint(long milliseconds) {
        try {
           repaint();
           Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
     }

     public void finalise() throws InterruptedException {
         for(int i=0;i<numbars;i++) {
             barColor[i]=100;
             repaint();
             Thread.sleep(5);
         }
         resetColors();
     }

     @Override
     public void paintComponent(Graphics g) {
        int maxValue = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, DEFAULT_WIN_WIDTH, DEFAULT_WIN_HEIGHT);
        for (int i = 0; i < numbars; i++) {
            double currentValue = arr[i];
            double percentOfMax = currentValue / maxValue;
            double heightPercentOfPanel = percentOfMax * BAR_HEIGHT_PERCENT;
            int height = (int) (heightPercentOfPanel * (double) getHeight());
            int xBegin = i + (BAR_WIDTH -1) * i;
            int yBegin = getHeight() - height;

            int val = barColor[i] * 2;

            if (val > 190) {
               g.setColor(new Color(255 - val, 255, 255 - val));
            } else {
               g.setColor(new Color(255, 255 - val, 255 - val));
            }
            g.fillRect(xBegin, yBegin, BAR_WIDTH, height);

           if (barColor[i] > 0)
              barColor[i] -= 5;
        }

     }
}
