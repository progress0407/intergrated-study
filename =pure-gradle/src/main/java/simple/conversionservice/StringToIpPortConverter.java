package simple.conversionservice;

public class StringToIpPortConverter implements Converter<String, IpPort>{

    @Override
    public IpPort convert(String source) {
        String[] splits = source.split(":");
        String ip = splits[0];
        Integer port = Integer.parseInt(splits[1]);
        return new IpPort(ip, port);
    }
}
