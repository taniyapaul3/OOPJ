package see;

import cie.Student;

public class External extends Student {
    private int[] seeMarks = new int[5];

    public External(String usn, String name, int sem, int[] seeMarks) {
        super(usn, name, sem);
        for (int i = 0; i < 5; i++) {
            this.seeMarks[i] = seeMarks[i];
        }
    }

    public int[] getSeeMarks() {
        return seeMarks;
    }
}
