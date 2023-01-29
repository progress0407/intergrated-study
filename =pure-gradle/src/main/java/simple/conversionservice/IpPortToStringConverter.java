package simple.conversionservice;

public class IpPortToStringConverter implements Converter<IpPort, String> {

    @Override
    public String convert(IpPort source) {
        String ip = source.getIp();
        String port = source.getPort().toString();
        return ip + port;
    }
}
