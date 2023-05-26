package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Product view.
 */
public class ProductView extends JFrame {

    private JTextField TF1;
    private JTextField TF2;
    private JTextField TF3;
    private JTextField TF4;

    private JButton insertBtn;
    private JButton updateBtn;
    private JButton deleteBtn;
    private JButton selectBtn;

    private JButton backBtn;

    private JTable dbTable;
    private DefaultTableModel tableModel;

    /**
     * Instantiates a new Product view.
     */
    public ProductView() {

        setSize(1000, 630);
        setTitle("Products Manager");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JLabel idL = new JLabel("ID: ");
        JLabel nameL = new JLabel("Name: ");
        JLabel priceL = new JLabel("Price: ");
        JLabel quantityL = new JLabel("Quantity: ");
        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new BoxLayout(panelLabels, BoxLayout.Y_AXIS));
        panelLabels.add(idL);
        panelLabels.add(Box.createVerticalStrut(20));
        panelLabels.add(nameL);
        panelLabels.add(Box.createVerticalStrut(20));
        panelLabels.add(priceL);
        panelLabels.add(Box.createVerticalStrut(20));
        panelLabels.add(quantityL);

        TF1 = new JTextField(15);
        TF2 = new JTextField(15);
        TF3 = new JTextField(15);
        TF4 = new JTextField(15);
        JPanel panelTFs = new JPanel();
        panelTFs.setLayout(new BoxLayout(panelTFs, BoxLayout.Y_AXIS));
        JPanel panelAllTFs = new JPanel();
        panelTFs.add(TF1);
        panelTFs.add(Box.createVerticalStrut(20));
        panelTFs.add(TF2);
        panelTFs.add(Box.createVerticalStrut(20));
        panelTFs.add(TF3);
        panelTFs.add(Box.createVerticalStrut(20));
        panelTFs.add(TF4);
        panelAllTFs.add(panelTFs);

        insertBtn = new JButton("Add");
        updateBtn = new JButton("Edit");
        deleteBtn = new JButton("Delete");
        selectBtn = new JButton("Show");
        JPanel panelBtns = new JPanel();
        panelBtns.setPreferredSize(new Dimension(1000, 40));
        panelBtns.add(insertBtn);
        panelBtns.add(updateBtn);
        panelBtns.add(deleteBtn);
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
     * Gets textfield 1 text.
     *
     * @return the textfield 1 text
     */
    public String getTF1text() {
        return TF1.getText();
    }

    /**
     * Gets textfield 2 text.
     *
     * @return the textextfieldield2 text
     */
    public String getTF2text() {
        return TF2.getText();
    }

    /**
     * Gets textfield 3 text.
     *
     * @return the textextfieldield 3 text
     */
    public String getTF3text() {
        return TF3.getText();
    }

    /**
     * Gets textfield 4 text.
     *
     * @return the textfield 4 text
     */
    public String getTF4text() {
        return TF4.getText();
    }

    /**
     * Gets textfield 1.
     *
     * @return the textfield 1
     */
    public JTextField getTF1() {
        return TF1;
    }

    /**
     * Sets textfield 1.
     *
     * @param TF1 the textfield 1
     */
    public void setTF1(JTextField TF1) {
        this.TF1 = TF1;
    }

    /**
     * Gets textfield 2.
     *
     * @return the textfield 2
     */
    public JTextField getTF2() {
        return TF2;
    }

    /**
     * Sets textfield 2.
     *
     * @param TF2 the textfield 2
     */
    public void setTF2(JTextField TF2) {
        this.TF2 = TF2;
    }

    /**
     * Gets textfield 3.
     *
     * @return the textfield 3
     */
    public JTextField getTF3() {
        return TF3;
    }

    /**
     * Sets textfield 3.
     *
     * @param TF3 the textfield 3
     */
    public void setTF3(JTextField TF3) {
        this.TF3 = TF3;
    }

    /**
     * Gets textfield 4.
     *
     * @return the textfield 4
     */
    public JTextField getTF4() {
        return TF4;
    }

    /**
     * Sets textfield 4.
     *
     * @param TF4 the textfield 4
     */
    public void setTF4(JTextField TF4) {
        this.TF4 = TF4;
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
     * Gets update button.
     *
     * @return the update button
     */
    public JButton getUpdateBtn() {
        return updateBtn;
    }

    /**
     * Sets update button.
     *
     * @param updateBtn the update button
     */
    public void setUpdateBtn(JButton updateBtn) {
        this.updateBtn = updateBtn;
    }

    /**
     * Gets delete button.
     *
     * @return the delete button
     */
    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    /**
     * Sets delete button.
     *
     * @param deleteBtn the delete button
     */
    public void setDeleteBtn(JButton deleteBtn) {
        this.deleteBtn = deleteBtn;
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
     * Delete button listener.
     *
     * @param e the e
     */
    public void deleteBtnListener(ActionListener e) {
        deleteBtn.addActionListener(e);
    }

    /**
     * Update button listener.
     *
     * @param e the e
     */
    public void updateBtnListener(ActionListener e) {
        updateBtn.addActionListener(e);
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
