package airbnb;

import static airbnb.main_page.selected;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class JComboCheckBox extends JComboBox {

    public JComboCheckBox() {
        init();
    }

    public JComboCheckBox(JCheckBox[] items) {
        super(items);
        init();
    }

    public JComboCheckBox(Vector items) {
        super(items);
        setSelectedIndex(0);
        init();
    }

    public JComboCheckBox(ComboBoxModel aModel) {
        super(aModel);
        init();
    }

    private void init() {
        setRenderer(new ComboBoxRenderer());
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                itemSelected();
            }
        });
    }

    private void itemSelected() {
        if (getSelectedItem() instanceof JCheckBox) {
            JCheckBox jcb = (JCheckBox) getSelectedItem();
            if(!selected.contains(jcb.getText())){
                selected.add(jcb.getText());
            }
            else{
                selected.remove(jcb.getText());
            }
            System.out.println(jcb.getText());
            jcb.setSelected(!jcb.isSelected());
        }
        else{
            JCheckBox jcb = (JCheckBox) getSelectedItem();
            
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showPopup();
            }
        });
    }

    public class ComboBoxRenderer implements ListCellRenderer {

        private JLabel label;

        public ComboBoxRenderer() {
            setOpaque(true);
        }

        public Component getListCellRendererComponent(JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Component) {
                Component c = (Component) value;
                if (isSelected) {
                    c.setBackground(list.getSelectionBackground());
                    c.setForeground(list.getSelectionForeground());
                } else {
                    c.setBackground(list.getBackground());
                    c.setForeground(list.getForeground());
                }

                return c;
            } else {
                if (label == null) {
                    label = new JLabel(value.toString());
                } else {
                    label.setText(value.toString());
                }

                return label;
            }
        }
    }
}
