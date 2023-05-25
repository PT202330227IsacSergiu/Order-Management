package Presentation;

import BusinessLogic.ClientBLL;
import Model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The type Client controller.
 */
public class ClientController {

    private ClientView clientView;

    /**
     * Instantiates a new Client controller.
     *
     * @param clientView the client view
     */
    public ClientController(ClientView clientView){
        this.clientView = clientView;
        this.clientView.insertBtnListener(new insertListener());
        this.clientView.selectBtnListener(new selectListener());
        this.clientView.updateBtnListener(new updateListener());
        this.clientView.deleteBtnListener(new deleteListener());
        this.clientView.backBtnListener(new backListener());
    }

    /**
     * The type Insert listener.
     */
    class insertListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String name = clientView.getTF2text();
            String address = clientView.getTF3text();
            String phone_number = clientView.getTF4text();

            ClientBLL clientBLL = new ClientBLL();
            Client client = new Client(name, address, phone_number);
            clientBLL.insertClient(client);

            List<Client> clients = clientBLL.findClients();
            String[][] clientsList = convertDataToStrings(clients);
            clientView.updateData(clientsList);
        }
    }

    /**
     * The type Select listener.
     */
    class selectListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            ClientBLL clientBLL = new ClientBLL();
            try {
                List<Client> clients = clientBLL.findClients();
                String[][] clientsList = convertDataToStrings(clients);
                clientView.updateData(clientsList);
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    /**
     * The type Update listener.
     */
    class updateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            Integer id = Integer.parseInt(clientView.getTF1text());
            String name = clientView.getTF2text();
            String address = clientView.getTF3text();
            String phone_number = clientView.getTF4text();

            ClientBLL clientBLL = new ClientBLL();
            Client client = new Client(id, name, address, phone_number);
            clientBLL.updateClient(client);

            List<Client> clients = clientBLL.findClients();
            String[][] clientsList = convertDataToStrings(clients);
            clientView.updateData(clientsList);
        }
    }

    /**
     * The type Delete listener.
     */
    class deleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            Integer id = Integer.parseInt(clientView.getTF1text());
            clientView.getTF2().setText("");
            clientView.getTF3().setText("");
            clientView.getTF4().setText("");

            ClientBLL clientBLL = new ClientBLL();
            clientBLL.deleteClient(id);

            List<Client> clients = clientBLL.findClients();
            String[][] clientsList = convertDataToStrings(clients);
            clientView.updateData(clientsList);

        }
    }

    /**
     * The type Back listener.
     */
    class backListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.dispose();
            new GeneralController(new GeneralView());
        }
    }

    /**
     * Convert data to strings string [ ] [ ].
     *
     * @param clients the clients
     * @return the string [ ] [ ]
     */
    public String[][] convertDataToStrings(List<Client> clients){
        String[][] clientsList = new String[clients.size()][4];
        int i = 0;
        for (Client c: clients) {
            clientsList[i][0] = Integer.toString(c.getId());
            clientsList[i][1] = c.getName();
            clientsList[i][2] = c.getAddress();
            clientsList[i][3] = c.getPhone_number();
            i++;
        }
        return clientsList;
    }
}
