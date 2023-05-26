package DataAccess;

import Connection.ConnectionFactory;

import javax.swing.table.DefaultTableModel;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Formattable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type AbstractDAO.
 *
 * @param <T> the type parameter
 */
public class AbstractDAO<T> {

    /**
     * The constant LOGGER.
     */
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    /**
     * Instantiates a new AbstractDAO.
     */
    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Find all T objects in the list.
     *
     * @return the list
     */
    public List<T> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("", false);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Create select query string.
     *
     * @param field    the field
     * @param whereAll the where all
     * @return the string
     */
    public String createSelectQuery(String field, boolean whereAll) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append("warehousedb.").append(type.getSimpleName().toLowerCase());
        if (whereAll) {
            sb.append(" WHERE ").append(field).append(" =?");
        }
        return sb.toString();
    } // OK

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Find t by id.
     *
     * @param id the id
     * @return the t
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("id", true);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Insert t.
     *
     * @param t the t
     * @return the t
     */
    public T insert(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createInsertQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            int i = 1;
            for (Field field : t.getClass().getDeclaredFields()) {
                if (field.getName().equals(type.getDeclaredFields()[0].getName()))
                    continue;
                Object value;
                field.setAccessible(true);
                try {
                    value = field.get(t);
                    if (value instanceof Integer) {
                        statement.setInt(i, (Integer) value);
                    }
                    if (value instanceof Double) {
                        statement.setDouble(i, (Double) value);
                    }
                    if (value instanceof String) {
                        statement.setString(i, (String) value);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Create insert query string.
     *
     * @return the string
     */
    public String createInsertQuery() {

        int i;
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append("warehousedb.").append(type.getSimpleName().toLowerCase());

        sb.append(" (");
        i = 0;
        for (Field field : type.getDeclaredFields()) {
            i++;
            if (field.getName().equals(type.getDeclaredFields()[0].getName()))
                continue;
            sb.append(field.getName());
            if (i != type.getDeclaredFields().length) {
                sb.append(", ");
            } else {
                sb.append(") ");
            }
        }

        sb.append("VALUES");

        sb.append(" (");
        i = 0;
        for (Field field : type.getDeclaredFields()) {
            i++;
            if (field.getName().equals(type.getDeclaredFields()[0].getName()))
                continue;
            sb.append("?");
            if (i != type.getDeclaredFields().length) {
                sb.append(", ");
            } else {
                sb.append(") ");
            }
        }
        return sb.toString();
    } // OK

    /**
     * Update t.
     *
     * @param t the t
     * @return the t
     */
    public T update(T t) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createUpdateQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            int i = 1;
            for (Field field : t.getClass().getDeclaredFields()) {
                if (field.getName().equals(type.getDeclaredFields()[0].getName()))
                    continue;
                Object value;
                field.setAccessible(true);
                try {
                    value = field.get(t);
                    if (value instanceof Integer) {
                        statement.setInt(i, (Integer) value);
                    }
                    if (value instanceof Double) {
                        statement.setDouble(i, (Double) value);
                    }
                    if (value instanceof String) {
                        statement.setString(i, (String) value);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }

            Object value;
            Field field = type.getDeclaredFields()[0];
            field.setAccessible(true);
            value = field.get(t);
            statement.setInt(i, (Integer) value);
            statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            return t;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    public DefaultTableModel createTable(List<T> list) {

        T obj = list.get(0);
        List<String> listColumns = new ArrayList<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            listColumns.add(field.getName());
        }
        String[] columns = listColumns.toArray(new String[0]);

        String[][] data = new String[list.size()][columns.length];
        int i = 0;
        for (T object : list) {
            List<String> rowData = new ArrayList<>();
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                try {
                    value = field.get(object);
                    rowData.add(value.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
            data[i] = rowData.toArray(new String[0]);
            i++;
        }

        return new DefaultTableModel(data, columns);
    }

    /**
     * Create update query string.
     *
     * @return the string
     */
    public String createUpdateQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append("warehousedb.").append(type.getSimpleName().toLowerCase());
        sb.append(" SET ");
        int i = 1;
        for (Field field : type.getDeclaredFields()) {
            if (field.getName().equals(type.getDeclaredFields()[0].getName()))
                continue;
            sb.append(field.getName()).append(" = ?");
            if (i + 1 != type.getDeclaredFields().length) {
                sb.append(", ");
            }
            i++;
        }
        sb.append(" WHERE id = ? ");
        return sb.toString();
    } // OK

    /**
     * Delete.
     *
     * @param id the id
     */
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        String query = createDeleteQuery(id);

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ConnectionFactory.close(statement);
        ConnectionFactory.close(connection);
    }

    /**
     * Create delete query string.
     *
     * @param id the id
     * @return the string
     */
    public String createDeleteQuery(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append("FROM ");
        sb.append("warehousedb.").append(type.getSimpleName().toLowerCase());
        sb.append(" WHERE id = ? ");
        return sb.toString();
    } // OK

    /**
     * Create last row query string.
     *
     * @return the string
     */
    public String createLastRowQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append("warehousedb.").append(type.getSimpleName().toLowerCase());
        sb.append(" ORDER BY id DESC LIMIT 1");

        return sb.toString();
    }

    /**
     * Last element t.
     *
     * @return the t
     */
    public T lastElement() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createLastRowQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();
            System.out.println(statement.toString());
            return createObjects(resultSet).get(0);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:lastElement " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
