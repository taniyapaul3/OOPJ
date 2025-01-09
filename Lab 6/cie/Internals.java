package cie;

public class Internals {
    protected int[] internalMarks = new int[5];

    public Internals(int[] marks) {
        for (int i = 0; i < 5; i++) {
            internalMarks[i] = marks[i];
        }
    }

    public int[] getInternalMarks() {
        return internalMarks;
    }
}
