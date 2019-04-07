package civitz.euler;

abstract class EulerProblem<T> {
    abstract int number();

    abstract T calculate();

    public String toString() {
        return "Euler problem " + number() + " result is: " + calculate();
    }
}