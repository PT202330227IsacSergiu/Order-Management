package BusinessLogic;

import BusinessLogic.Validators.ClientValidaor.PhoneNumberValidator;
import BusinessLogic.Validators.Validator;
import DataAccess.ClientDAO;
import Model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type ClientBLL.
 */
public class ClientBLL {

    private ClientDAO clientDAO;
    private List<Validator<Client>> validators;

    /**
     * Instantiates a new ClientBLL.
     */
    public ClientBLL(){
        validators = new ArrayList<>();
        validators.add(new PhoneNumberValidator());

        clientDAO = new ClientDAO();
    }

    /**
     * Insert client.
     *
     * @param c the c
     * @return the client
     */
    public Client insertClient(Client c){
        try {
            for (Validator<Client> validator : validators) {
                validator.validate(c);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
        Client client = clientDAO.insert(c);
        if(client == null){
            throw new NoSuchElementException("Client can't be inserted!");
        }
        return client;
    }

    /**
     * Update client.
     *
     * @param c the c
     * @return the client
     */
    public Client updateClient(Client c) {
        Client client = clientDAO.update(c);
        if(client == null){
            throw new NoSuchElementException("Client can't be updated!");
        }
        return client;
    }

    /**
     * Find client by id client.
     *
     * @param id the id
     * @return the client
     */
    public Client findClientById(int id){
        Client client = clientDAO.findById(id);
        if(client == null){
            throw new NoSuchElementException("Client " + id + "doesn't exist!");
        }
        return client;
    }

    /**
     * Find clients list.
     *
     * @return the list
     */
    public List<Client> findClients(){
        List<Client> clients = clientDAO.findAll();
        if(clients == null || clients.size() == 0){
            throw new NoSuchElementException("No clients!");
        }
        return clients;
    }

    /**
     * Delete client.
     *
     * @param id the id
     */
    public void deleteClient(int id){
        try {
            if (findClientById(id) != null)
                clientDAO.delete(id);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Client with id " + id + " doesn't exist!");
        }
    }

    public DefaultTableModel createClientsTable(List<Client> clients){
        return clientDAO.createTable(clients);
    }
}
