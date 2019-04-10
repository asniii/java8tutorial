package p4_method_and_constructor_reference;

@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}
