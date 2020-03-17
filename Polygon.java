package Wielokaty;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Polygon extends JFrame implements ActionListener
{
    int SLIDER_MAX = 33;
    int SLIDER_MIN = 3;
    int SLIDER_INIT = 3;
    int value = 3;
    JMenu menu;
    JMenuItem line1, line3, line5, line8;
    DrawablePanel panelCenter;
    JButton bgcolor_btn;
    JButton fgcolor_btn;
    JButton draw;
    static JRadioButton radio1;
    static JRadioButton radio2;
    JSlider slider;
    JTextArea display;
    JLabel label1;
    Color bgcolor, fgcolor;

    public Polygon() throws HeadlessException
    {
        this.setSize(640, 480);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Panele
        JPanel panelTop = new JPanel();
        JPanel panelBottom = new JPanel();
        JPanel panelLeft = new JPanel();
        JPanel panelRight = new JPanel();
        panelCenter = new DrawablePanel();
        panelCenter.setBackground(Color.white);
        panelLeft.setLayout(new GridLayout(3,1));
        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelBottom, BorderLayout.SOUTH);
        this.add(panelLeft, BorderLayout.WEST);
        this.add(panelRight, BorderLayout.EAST);
        this.add(panelCenter, BorderLayout.CENTER);

        // Komponenty interfejsu GUI
        label1 = new JLabel("Ilosc bokow: ");
        slider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPreferredSize(new Dimension(300, 50));
        slider.addChangeListener(new SliderChangeListener());
        draw = new JButton("Draw");
        bgcolor_btn = new JButton("BG Color");
        fgcolor_btn = new JButton("Line Color");
        radio1 = new JRadioButton("foremny");
        radio2 = new JRadioButton("losowy");
        Border blackline = BorderFactory.createTitledBorder("Wielokat");
        radio1.setSelected(true);
        Box box = Box.createVerticalBox();
        ButtonGroup grupa = new ButtonGroup();
        display = new JTextArea(String.format("%d", slider.getValue()));
        display.setPreferredSize(new Dimension(20,20));
        draw.addActionListener(this);
        bgcolor_btn.addActionListener(this);
        fgcolor_btn.addActionListener(this);
        // Menubar
        JMenuBar menubar = new JMenuBar();
        menu = new JMenu("Line width");
        line1 = new JMenuItem("line 1");
        line3 = new JMenuItem("line 3");
        line5 = new JMenuItem("line 5");
        line8 = new JMenuItem("line 8");
        line1.addActionListener(this);
        line3.addActionListener(this);
        line5.addActionListener(this);
        line8.addActionListener(this);

        menu.add(line1);
        menu.add(line3);
        menu.add(line5);
        menu.add(line8);

        menubar.add(menu);
        this.setJMenuBar(menubar);

        box.add(radio1);
        box.add(radio2);
        grupa.add(radio1);
        grupa.add(radio2);
        panelTop.add(label1);
        panelTop.add(slider);
        panelTop.add(draw);
        panelBottom.add(bgcolor_btn);
        panelBottom.add(fgcolor_btn);
        panelLeft.add(box);
        panelLeft.setBorder(blackline);
        panelRight.add(display);
    }
    public static void main(String[] args)
    {
        Polygon frame = new Polygon();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == bgcolor_btn)
        {
            System.out.println("bg color button pressed");
            bgcolor = JColorChooser.showDialog(this, "Wybierz kolor tla", panelCenter.getBackground());
            panelCenter.setBackground(bgcolor);
        }
        if(actionEvent.getSource() == fgcolor_btn)
        {
            System.out.println("fg color button pressed");
            fgcolor = JColorChooser.showDialog(this, "Wybierz kolor linii", panelCenter.fgcolor);
            panelCenter.fgcolor = fgcolor;
        }
        if(actionEvent.getSource() == line1)
        {
            panelCenter.lineThickness = 1;
        }
        if(actionEvent.getSource() == line3)
        {
            panelCenter.lineThickness = 3;
        }
        if(actionEvent.getSource() == line5)
        {
            panelCenter.lineThickness = 5;
        }
        if(actionEvent.getSource() == line8)
        {
            panelCenter.lineThickness = 8;
        }
        if(actionEvent.getSource() == draw)
        {
            if(radio1.isSelected())
            {
                System.out.println("Rysujemy foremny");
                panelCenter.ilebokow = slider.getValue();
                panelCenter.repaint();
            }
            if(radio2.isSelected())
            {
                System.out.println("Rysujemy losowy");
                panelCenter.ilebokow = slider.getValue();
                panelCenter.repaint();
            }

        }
    }

    public class SliderChangeListener implements ChangeListener
    {
        @Override
        public void stateChanged(ChangeEvent changeEvent)
        {
            value = slider.getValue();
            display.setText(Integer.toString(value));
        }
    }
}
