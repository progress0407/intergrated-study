package simple.conversionservice;

public class IpPort {

    private String ip;
    private Integer port;

    public IpPort(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public Integer getPort() {
        return port;
    }
}
