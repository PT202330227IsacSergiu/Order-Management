package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Order view.
 */
public class OrderView extends JFrame {

    private JTextField TF1;
    private JTextField TF2;
    private JTextField TF3;

    private JButton insertBtn;
    private JButton selectBtn;

    private JButton backBtn;

    private JTable dbTable;
    private DefaultTableModel tableModel;


    /**
     * Instantiates a new Order view.
     */
    public OrderView() {

        setSize(1000, 630);
        setTitle("Orders Manager");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JLabel idClinetL = new JLabel("ID Client: ");
        JLabel idProductL = new JLabel("ID Product: ");
        JLabel quantityL = new JLabel("Quantity: ");
        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new BoxLayout(panelLabels, BoxLayout.Y_AXIS));
        panelLabels.add(idClinetL);
        panelLabels.add(Box.createVerticalStrut(20));
        panelLabels.add(idProductL);
        panelLabels.add(Box.createVerticalStrut(20));
        panelLabels.add(quantityL);

        TF1 = new JTextField(15);
        TF2 = new JTextField(15);
        TF3 = new JTextField(15);
        JPanel panelTFs = new JPanel();
        panelTFs.setLayout(new BoxLayout(panelTFs, BoxLayout.Y_AXIS));
        JPanel panelAllTFs = new JPanel();
        panelTFs.add(TF1);
        panelTFs.add(Box.createVerticalStrut(20));
        panelTFs.add(TF2);
        panelTFs.add(Box.createVerticalStrut(20));
        panelTFs.add(TF3);
        panelAllTFs.add(panelTFs);

        insertBtn = new JButton("Add");
        selectBtn = new JButton("Show");
        JPanel panelBtns = new JPanel();
        panelBtns.setPreferredSize(new Dimension(1000, 40));
        panelBtns.add(insertBtn);
        panelBtns.add(selectBtn);

        dbTable = new JTable(tableModel);
        JPanel panelTableDB = new JPanel();
        panelTableDB.add(new JScrollPane(dbTable));

        backBtn = new JButton("Back");
        JPanel panelBackBtn = new JPanel();
        panelBackBtn.add(backBtn);

        JPanel panelInputs = new JPanel();
        panelInputs.add(panelLabels);
        panelInputs.add(panelAllTFs);

        add(panelInputs);
        add(panelTableDB);
        add(panelBtns);
        add(panelBackBtn);

        setVisible(true);
    }

    /**
     * Gets text field's 1 text.
     *
     * @return the text field's 1 text
     */
    public String getTF1text() {
        return TF1.getText();
    }

    /**
     * Gets text field's 2 text.
     *
     * @return the tf 2 text
     */
    public String getTF2text() {
        return TF2.getText();
    }

    /**
     * Gets text field's 3 text.
     *
     * @return the text field's 3 text
     */
    public String getTF3text() {
        return TF3.getText();
    }

    /**
     * Gets text field's 1.
     *
     * @return the text field's 1
     */
    public JTextField getTF1() {
        return TF1;
    }

    /**
     * Sets text field's 1.
     *
     * @param TF1 the text field's 1
     */
    public void setTF1(JTextField TF1) {
        this.TF1 = TF1;
    }

    /**
     * Gets text field's 2.
     *
     * @return the text field's 2
     */
    public JTextField getTF2() {
        return TF2;
    }

    /**
     * Sets text field's 2.
     *
     * @param TF2 the text field's 2
     */
    public void setTF2(JTextField TF2) {
        this.TF2 = TF2;
    }

    /**
     * Gets text field's 3.
     *
     * @return the tf 3
     */
    public JTextField getTF3() {
        return TF3;
    }

    /**
     * Sets text field's 3.
     *
     * @param TF3 the text field's 3
     */
    public void setTF3(JTextField TF3) {
        this.TF3 = TF3;
    }

    /**
     * Gets back button.
     *
     * @return the back button
     */
    public JButton getBackBtn() {
        return backBtn;
    }

    /**
     * Sets back button.
     *
     * @param backBtn the back button
     */
    public void setBackBtn(JButton backBtn) {

        this.backBtn = backBtn;
    }

    /**
     * Gets insert button.
     *
     * @return the insert button
     */
    public JButton getInsertBtn() {
        return insertBtn;
    }

    /**
     * Sets insert button.
     *
     * @param insertBtn the insert button
     */
    public void setInsertBtn(JButton insertBtn) {
        this.insertBtn = insertBtn;
    }

    /**
     * Gets select button.
     *
     * @return the select button
     */
    public JButton getSelectBtn() {
        return selectBtn;
    }

    /**
     * Sets select button.
     *
     * @param selectBtn the select button
     */
    public void setSelectBtn(JButton selectBtn) {
        this.selectBtn = selectBtn;
    }

    /**
     * Gets database table.
     *
     * @return the database table
     */
    public JTable getDbTable() {
        return dbTable;
    }

    /**
     * Sets database table.
     *
     * @param dbTable the database table
     */
    public void setDbTable(JTable dbTable) {
        this.dbTable = dbTable;
    }

    public void updateData(DefaultTableModel tableModel) {
        this.dbTable.setModel(tableModel);
    }

    /**
     * Insert button listener.
     *
     * @param e the e
     */
    public void insertBtnListener(ActionListener e) {

        insertBtn.addActionListener(e);
    }

    /**
     * Select button listener.
     *
     * @param e the e
     */
    public void selectBtnListener(ActionListener e) {

        selectBtn.addActionListener(e);
    }

    /**
     * Back button listener.
     *
     * @param e the e
     */
    public void backBtnListener(ActionListener e) {

        backBtn.addActionListener(e);
    }
}
