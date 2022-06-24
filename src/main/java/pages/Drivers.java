package pages;

public enum Drivers {

    CHROME_DRIVER("Chrome", "101"),
    FIREFOX_DRIVER("Firefox", "95"),
    SAFARI_DRIVER("Safari", "45");

    Drivers(String driverName, String driverVersion) {
        this.driverName = driverName;
        this.driverVersion = driverVersion;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverVersion() {
        return driverVersion;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setDriverVersion(String driverVersion) {
        this.driverVersion = driverVersion;
    }

    private String driverName;
    private String driverVersion;

}
