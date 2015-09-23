//Linhan Li independent work.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Painter extends JFrame{
  private Canvas cav;
   private Graphics g1;
   private JColorChooser cch;
   private JSlider sld;
    private static int fnl = 10;
   private JPanel pnl;
   private JTextField textp;
   
  public Painter(){
    cav = new Canvas();
    cav.setBackground(Color.white);
    Container c = this.getContentPane();
    c.add(cav,"Center");
    cav.addMouseMotionListener(new cl1());
    cav.addMouseListener(new cl1());
    cch = new JColorChooser(Color.BLACK);
    cch.setPreviewPanel(new JPanel());
    c.add(cch,"North");
    textp = new JTextField(Integer.toString(fnl),4);
    textp.setEditable(false);
    pnl = new JPanel();
    pnl.setLayout(new BoxLayout(pnl,BoxLayout.Y_AXIS));
    sld = new JSlider(SwingConstants.VERTICAL,1,101,fnl);
    sld.setMajorTickSpacing(10);
    sld.setMinorTickSpacing(1);
    sld.setPaintTicks(true);
    sld.setPaintLabels(true);
    sld.addChangeListener(new ChangeListener(){
      public void stateChanged(ChangeEvent e){
        textp.setText(Integer.toString(sld.getValue()));
      }
    });
    pnl.add(textp);
    pnl.add(sld);
    c.add(pnl,"East");
    this.setSize(600,500);
    this.setVisible(true);
  }
  
  public class cl1 extends MouseInputAdapter{
    public void mouseDragged(MouseEvent e){
      if(g1 == null){
        g1 = cav.getGraphics();
      }
      g1.setColor(cch.getColor());
      g1.fillOval(e.getX() - sld.getValue() / 2,e.getY()- sld.getValue() / 2,sld.getValue(),sld.getValue());
    }
    
    public void mousePressed(MouseEvent e){
   this.mouseDragged(e);
  }
  } 
  public static void main(String[] args){
    Painter p1 = new Painter();
  }
  
  

}
    
                       
                       
                       