import javax.swing.*;
import java.net.InetAddress;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;



public class Graphick extends JFrame {
    JButton b1, b2;
    JLabel l1, l2;
    JTextField t1;
    String s1, add, s2;
    InetAddress addresses[];
    Lis Lis= new Lis();
    JTextArea area1;

    public Graphick(String s) {
        super(s);
        s1 = "";
        s2=null;
        add="";
        setLayout(new FlowLayout());
        b1 = new JButton("Start");
        b2 = new JButton("Clear");
        l1 = new JLabel("Input address");
        l2 = new JLabel("");
        Dimension size = new Dimension(100,30);
        t1 = new JTextField();
        t1.setPreferredSize(size);
        area1=new JTextArea(100,30);
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);

        add(l1);
        add(t1);
        add(b1);
        add(b2);
        add(area1);
        b1.addActionListener(Lis);
        b2.addActionListener(Lis);

    }

    public class Lis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          try {
              if (e.getSource()==b1)
              {
                  s1=t1.getText();
                  addresses  = InetAddress.getAllByName(s1);
                  URL one = new URL("http://"+s1);
                  for (int i = 0; i < addresses.length; i++)
                  {
                      add = add + addresses[i].toString()+" ";
                  }
                  area1.setText(add + " " + "\nProtocol: "+ one.getProtocol()+ " " + "\nPort: " + one.getPort() + " " + "\nHost: "+ one.getHost()+ " "
                  + "\nFile: " + one.getFile()+ " "+ "\nFull Form: " + one.toExternalForm()  );
              }
              if (e.getSource()==b2)
              {
                  s1="";
                  add="";
               t1.setText("");
               area1.setText("");
              }
          } catch (Exception e1){
              JOptionPane.showMessageDialog(null,"Error");
          }
        }
    }
}