import javax.swing.JFrame;

public class Main {
  public static void main(String args[])
  {
     Graphick g = new Graphick("Net.scan");
     g.setVisible(true);
     g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     g.setSize(400,400);
     g.setLocationRelativeTo(null);
     g.setResizable(false);

  }
}
