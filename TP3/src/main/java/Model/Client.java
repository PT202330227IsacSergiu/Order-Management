package Model;

/**
 * The type Client.
 */
public class Client {

    private Integer id;
    private String name;
    private String address;
    private String phone_number;

    /**
     * Instantiates a new Client.
     */
    public Client() {
    }

    /**
     * Instantiates a new Client.
     *
     * @param id           the id
     * @param name         the name
     * @param address      the address
     * @param phone_number the phone number
     */
    public Client(Integer id, String name, String address, String phone_number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }

    /**
     * Instantiates a new Client.
     *
     * @param name         the name
     * @param address      the address
     * @param phone_number the phone number
     */
    public Client(String name, String address, String phone_number) {
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * Sets phone number.
     *
     * @param phone_number the phone number
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + name + ", " + address + ", " + phone_number + ")";
    }


}
