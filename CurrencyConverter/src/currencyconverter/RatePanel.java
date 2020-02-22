package currencyconverter;

/**
 *
 * @author IchaCahyaWulan
 */
// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RatePanel extends JPanel
{
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result, costLabel;
    private JComboBox currNameList;
    private JTextField costInput;
    private JButton conv;
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel ()
    {
        JLabel title = new JLabel ("How much is that in dollars?");
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));
        // Set up the arrays for the currency conversions
        currencyName = new String[] {"Select the currency..",
                                    "European Euro", "Canadian Dollar",
                                    "Japanese Yen", "Australian Dollar",
                                    "Indian Rupee", "Mexican Peso"};
        
        rate = new double [] {0.0, 1.2103, 0.7351,
                            0.0091, 0.6969,
                            0.0222, 0.0880};
        
        currNameList = new JComboBox(currencyName);
        currNameList.addActionListener(new ComboListener());
        currNameList.setBackground(new Color(255, 158, 221));
        currNameList.setAlignmentX (Component.CENTER_ALIGNMENT);
        
        
        costLabel = new JLabel ("Enter the cost you want to convert");
        costLabel.setAlignmentX (Component.CENTER_ALIGNMENT);
        costLabel.setFont (new Font ("Helvetica", Font.BOLD, 15));
        
        costInput = new JTextField(20);
        costInput.setBackground(new Color(255, 230, 252));
        
        conv = new JButton("Convert");
        conv.setAlignmentX (Component.CENTER_ALIGNMENT);
        conv.setBackground(new Color(255, 158, 221));
        conv.addActionListener(new ComboListener());
        
        result = new JLabel (" ------------ ");
        result.setAlignmentX (Component.CENTER_ALIGNMENT);
        
        JPanel createDisp = new JPanel();
        createDisp.setPreferredSize(new Dimension(300,200));
        createDisp.setBackground(new Color(255, 224, 244));
        createDisp.setLayout(new BoxLayout(createDisp, BoxLayout.Y_AXIS));
        createDisp.add(Box.createRigidArea(new Dimension(0, 5)));
        createDisp.add(title);
        createDisp.add(Box.createRigidArea(new Dimension(0, 10)));
        createDisp.add(currNameList);
        createDisp.add(Box.createRigidArea(new Dimension(0, 15)));
        createDisp.add(costLabel);
        createDisp.add(Box.createRigidArea(new Dimension(0, 5)));
        createDisp.add(costInput);
        createDisp.add(Box.createRigidArea(new Dimension(0, 20)));
        createDisp.add(conv);
        createDisp.add(Box.createRigidArea(new Dimension(0, 10)));
        createDisp.add(result);
        
        add (createDisp);
    }

    
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener
    {
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        public void actionPerformed (ActionEvent event)
        {
            int index = currNameList.getSelectedIndex();
            if(index == 0){
                result.setText ("Select the currency name");
            }else{
                try{
                    result.setText (costInput.getText() + " " + currencyName[index] + 
                    " = " + rate[index]*Double.parseDouble(costInput.getText())
                    + " U.S. Dollars");
                }
                catch(NumberFormatException e){
                    result.setText("Input number only");
                }
            }
            
        }
    }
}

