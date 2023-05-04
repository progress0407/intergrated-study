package simple.conversionservice;

class StringToIntegerConverter implements Converter<String, Integer> {

    public Integer convert(String source) {
        return Integer.parseInt(source);
    }
}
