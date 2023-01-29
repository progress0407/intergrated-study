package simple.conversionservice;

public interface Converter<I, O> {

    O convert(I source);
}
