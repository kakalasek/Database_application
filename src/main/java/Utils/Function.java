package Utils;

/* Provides the ability to elegantly pass a function as a parameter in a method */
@FunctionalInterface
public interface Function {
    void apply();   // Calls the function
}
