package pageObjects;


public enum MyProperties {

    BROWSER("browser", "chrome"),
    STAGE("stage", "Group Stage"),
    GAMES("games", "Played");

    private String propertyName;
    private String defaultValue;


    MyProperties(String propertyName, String defaultValue) {
        this.propertyName = propertyName;
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public static String getProperty(MyProperties property) {
       return System.getProperty(property.getPropertyName(),property.getDefaultValue());
    }

}
