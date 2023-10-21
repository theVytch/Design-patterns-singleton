public class Configuration {

    private static Configuration instance;
    private String appName;
    private int maxConnections;

    private Configuration() {
        appName = "MyApp";
        maxConnections = 10;
    }

    public static Configuration getInstance() {
        if (instance == null) {
            synchronized (Configuration.class) {
                if (instance == null) {
                    instance = new Configuration();
                }
            }
        }
        return instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public static void main(String[] args) {
        Configuration config1 = Configuration.getInstance();
        System.out.println("App Name: " + config1.getAppName());
        System.out.println("Max Connections: " + config1.getMaxConnections());

        Configuration config2 = Configuration.getInstance();
        config2.setAppName("MyUpdatedApp");
        config2.setMaxConnections(20);

        System.out.println("App Name (after update): " + config1.getAppName());
        System.out.println("Max Connections (after update): " + config1.getMaxConnections());

        if (config1 == config2) {
            System.out.println("As duas instâncias de configuração são iguais.");
        }
    }
}