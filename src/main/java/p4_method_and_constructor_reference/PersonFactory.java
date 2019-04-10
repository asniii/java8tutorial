package p4_method_and_constructor_reference;

public interface PersonFactory<P extends Person> {
    P create(String firstname, String lastname);
}
