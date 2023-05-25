package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type General view.
 */
public class GeneralView extends JFrame {

    private JButton clientViewBtn;
    private JButton productViewBtn;
    private JButton orderViewBtn;

    /**
     * Instantiates a new General view.
     */
    public GeneralView(){

        setSize(300, 200);
        setTitle("Main Menu");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        clientViewBtn = new JButton("Clients");
        clientViewBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        productViewBtn = new JButton("Products");
        productViewBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        orderViewBtn = new JButton("Orders");
        orderViewBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelBtns = new JPanel();
        panelBtns.setLayout(new BoxLayout(panelBtns, BoxLayout.Y_AXIS));

        panelBtns.add(Box.createRigidArea(new Dimension(0,30)));
        panelBtns.add(clientViewBtn);
        panelBtns.add(Box.createRigidArea(new Dimension(0,10)));
        panelBtns.add(productViewBtn);
        panelBtns.add(Box.createRigidArea(new Dimension(0,10)));
        panelBtns.add(orderViewBtn);


        add(panelBtns);

        setVisible(true);
    }

    /**
     * Clients button listener.
     *
     * @param e the e
     */
    public void clientsBtnListener(ActionListener e){
        clientViewBtn.addActionListener(e);
    }

    /**
     * Products button listener.
     *
     * @param e the e
     */
    public void productsBtnListener(ActionListener e){
        productViewBtn.addActionListener(e);
    }

    /**
     * Orders button listener.
     *
     * @param e the e
     */
    public void ordersBtnListener(ActionListener e){
        orderViewBtn.addActionListener(e);
    }
}
