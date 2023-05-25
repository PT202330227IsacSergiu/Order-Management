package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * The type Client view.
 */
public class ClientView extends JFrame {

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

    private String[] collumsName = {"ID", "NAME", "ADDRESS", "PHONE NO."};
    private String[][] data = {};

    /**
     * Instantiates a new Client view.
     */
    public ClientView() {

        setSize(1000, 630);
        setTitle("Clients Manager");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        JLabel idL = new JLabel("ID: ");
        JLabel nameL = new JLabel("Name: ");
        JLabel addressL = new JLabel("Address: ");
        JLabel phone_numberL = new JLabel("Phone number: ");
        JPanel panelLabels = new JPanel();
        panelLabels.setLayout(new BoxLayout(panelLabels, BoxLayout.Y_AXIS));
        panelLabels.add(idL);
        panelLabels.add(Box.createVerticalStrut(20));
        panelLabels.add(nameL);
        panelLabels.add(Box.createVerticalStrut(20));
        panelLabels.add(addressL);
        panelLabels.add(Box.createVerticalStrut(20));
        panelLabels.add(phone_numberL);

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

        tableModel = new DefaultTableModel(data, collumsName);
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
     * Gets tf 1 text.
     *
     * @return the tf 1 text
     */
    public String getTF1text() {
        return TF1.getText();
    }

    /**
     * Gets tf 2 text.
     *
     * @return the tf 2 text
     */
    public String getTF2text() {
        return TF2.getText();
    }

    /**
     * Gets tf 3 text.
     *
     * @return the tf 3 text
     */
    public String getTF3text() {
        return TF3.getText();
    }

    /**
     * Gets tf 4 text.
     *
     * @return the tf 4 text
     */
    public String getTF4text() {
        return TF4.getText();
    }

    /**
     * Gets tf 1.
     *
     * @return the tf 1
     */
    public JTextField getTF1() {
        return TF1;
    }

    /**
     * Sets tf 1.
     *
     * @param TF1 the tf 1
     */
    public void setTF1(JTextField TF1) {
        this.TF1 = TF1;
    }

    /**
     * Gets tf 2.
     *
     * @return the tf 2
     */
    public JTextField getTF2() {
        return TF2;
    }

    /**
     * Sets tf 2.
     *
     * @param TF2 the tf 2
     */
    public void setTF2(JTextField TF2) {
        this.TF2 = TF2;
    }

    /**
     * Gets tf 3.
     *
     * @return the tf 3
     */
    public JTextField getTF3() {
        return TF3;
    }

    /**
     * Sets tf 3.
     *
     * @param TF3 the tf 3
     */
    public void setTF3(JTextField TF3) {
        this.TF3 = TF3;
    }

    /**
     * Gets tf 4.
     *
     * @return the tf 4
     */
    public JTextField getTF4() {
        return TF4;
    }

    /**
     * Sets tf 4.
     *
     * @param TF4 the tf 4
     */
    public void setTF4(JTextField TF4) {
        this.TF4 = TF4;
    }

    /**
     * Gets insert btn.
     *
     * @return the insert btn
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
     * @param updateBtn the update btn
     */
    public void setUpdateBtn(JButton updateBtn) {
        this.updateBtn = updateBtn;
    }

    /**
     * Gets delete button.
     *
     * @return the delete btn
     */
    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    /**
     * Sets delete button.
     *
     * @param deleteBtn the delete btn
     */
    public void setDeleteBtn(JButton deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    /**
     * Gets select button.
     *
     * @return the select btn
     */
    public JButton getSelectBtn() {
        return selectBtn;
    }

    /**
     * Sets select button.
     *
     * @param selectBtn the select btn
     */
    public void setSelectBtn(JButton selectBtn) {
        this.selectBtn = selectBtn;
    }

    /**
     * Gets db table.
     *
     * @return the db table
     */
    public JTable getDbTable() {
        return dbTable;
    }

    /**
     * Sets db table.
     *
     * @param dbTable the db table
     */
    public void setDbTable(JTable dbTable) {
        this.dbTable = dbTable;
    }

    /**
     * Get data string [ ] [ ].
     *
     * @return the string [ ] [ ]
     */
    public String[][] getData() {
        return data;
    }

    /**
     * Update data.
     *
     * @param newData the new data
     */
    public void updateData(String[][] newData) {
        tableModel.setDataVector(newData, collumsName);
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
