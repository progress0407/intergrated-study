package simple.conversionservice;

import java.util.ArrayList;
import java.util.List;

class ConversionService {

    private List<Converter> converters = new ArrayList<>();

    public void addConverter(final Converter converter) {
        converters.add(converter);
    }

/*    assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
    assertThat(conversionService.convert(10, String.class)).isEqualTo("10");*/

    public <T, S extends Class<?>> S convert(T source, Class<S> clazz) {
//        converters.stream()
//                .filter(converter -> converter instanceof T)
        return null;
    }
}
