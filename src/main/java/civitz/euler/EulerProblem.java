package civitz.euler;

abstract class EulerProblem {
    abstract int number();

    abstract Number calculate();

    public String toString() {
        return "Euler problem " + number() + " result is: " + calculate();
    }
}