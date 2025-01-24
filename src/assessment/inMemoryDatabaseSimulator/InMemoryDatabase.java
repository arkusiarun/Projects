package assessment.inMemoryDatabaseSimulator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InMemoryDatabase {
    private Map<String, String> dataStore = new HashMap<>();
    private Stack<Map<String, String>> transactionStack = new Stack<>();

    public void beginTransaction() {
        transactionStack.push(new HashMap<>(dataStore));
        System.out.println("Transaction started.");
    }

    public void commitTransaction() {
        if (transactionStack.isEmpty()) {
            System.out.println("No active transaction to commit.");
        } else {
            transactionStack.pop();
            System.out.println("Transaction committed.");
        }
    }

    public void rollbackTransaction() {
        if (transactionStack.isEmpty()) {
            System.out.println("No active transaction to rollback.");
        } else {
            dataStore = transactionStack.pop();
            System.out.println("Transaction rolled back.");
        }
    }

    public void set(String key, String value) {
        dataStore.put(key, value);
        System.out.println("Set " + key + " = " + value);
    }

    public String get(String key) {
        return dataStore.getOrDefault(key, "NULL");
    }

    public void delete(String key) {
        if (dataStore.containsKey(key)) {
            dataStore.remove(key);
            System.out.println("Deleted key: " + key);
        } else {
            System.out.println("Key not found: " + key);
        }
    }

    public void displayData() {
        System.out.println("Current Data: " + dataStore);
    }

    public static void main(String[] args) {
        InMemoryDatabase db = new InMemoryDatabase();

        db.set("a", "1");
        db.displayData();

        db.beginTransaction();
        db.set("b", "2");
        db.displayData();

        db.rollbackTransaction();
        db.displayData();

        db.beginTransaction();
        db.set("c", "3");
        db.commitTransaction();
        db.displayData();
    }
}