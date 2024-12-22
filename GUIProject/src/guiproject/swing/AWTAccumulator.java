
package guiproject.swing;  
import java.awt.*;   //Lý Công Tiến - 20225934
import java.awt.event.*;
public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;
    // Constructor to setup the GUI components and event handlers
    public AWTAccumulator(){
        setLayout(new GridLayout(2,2));
        add(new Label("Ly Cong Tien_5934_Enter an integer: "));
        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());
        add(new Label("Ly Cong Tien_5934_The Accumulated Sum is: "));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);
        setTitle("AWT Accumulator");
        setSize(350,120);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AWTAccumulator();
    }
    private class TFInputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            int NumberIn = Integer.parseInt(tfInput.getText());
            sum += NumberIn;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}
