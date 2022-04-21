import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4){
            throw new IllegalArgumentException("Wrong format. Correct format:" +
                    " add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        if (storage.isEmpty()){ throw new RuntimeException("List is empty");}
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (storage.containsValue(name)) {
            storage.remove(name);
        }
        else { throw new RuntimeException("No customer with name - " + name);}
    }

    public Customer getCustomer(String name) {
        if (storage.containsValue(name)) {
            return storage.get(name);
        }
        else { throw new RuntimeException("No customer with name - " + name);}
    }

    public int getCount() {
        return storage.size();
    }

}