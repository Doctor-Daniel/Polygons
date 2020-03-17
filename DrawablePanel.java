package Wielokaty;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawablePanel extends JPanel
{
    private static final double PI = 3.141592;
    public static int ilebokow;
    public static Color fgcolor;
    public static int lineThickness;


    public static void setValue(int value)
    {
        ilebokow = value;
    }

    public static void setLineColor(Color whatcolor)
    {
        fgcolor = whatcolor;
    }

    public static void setLineThickness(int thickness)
    {
        lineThickness = thickness;

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(fgcolor);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(lineThickness);
        g2d.setStroke(bs);
        int x[] = new int[ilebokow];
        int y[] = new int[ilebokow];
        int xmid = 300;
        int ymid = 180;
        int radius = 150;

        if(Polygon.radio1.isSelected())
        {
            for (int i = 0; i < ilebokow; i++)
            {
                x[i] = (int) (xmid + radius*Math.cos((PI/2+2*PI*i)/ilebokow));
                y[i] = (int) (ymid + radius*Math.sin((PI/2+2*PI*i)/ilebokow));
            }
            for (int i = 0; i < ilebokow; i++)
            {
                if (i == 0)
                {
                    g2d.drawLine(x[ilebokow-1], y[ilebokow-1], x[0], y[0]);
                }
                else
                {
                    g2d.drawLine(x[i-1], y[i-1], x[i], y[i]);
                }
            }
        }
        if(Polygon.radio2.isSelected())
        {
            Random r = new Random();
            for (int i = 0; i < ilebokow; i++)
            {
                x[i] = (50 + r.nextInt(300));
                y[i] = (r.nextInt(300));
            }
            for (int i = 0; i < ilebokow; i++)
            {
                if (i == 0)
                {
                    g2d.drawLine(x[ilebokow-1], y[ilebokow-1], x[0], y[0]);
                }
                else
                {
                    g2d.drawLine(x[i-1], y[i-1], x[i], y[i]);
                }
            }
        }

    }

}
