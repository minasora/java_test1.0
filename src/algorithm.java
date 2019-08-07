public class algorithm {

    protected static boolean Checkwin(int chest[][], int i, int j, int tmp) {
        int count1s = 0;
        int count2s = 0;
        int count3s = 0;
        int count4s = 0;
        int corx;
        int cory;
        int corx1;
        int cory1;
        for (int p = -4; p <= 4; p++) {
            corx = i + p;
            cory = j + p;
            if (corx >= 0) {
                if (chest[corx][j] == tmp) count1s++;
                if (count1s >= 5) return true;
                if (chest[corx][j] != tmp) count1s = 0;
            }
            if (cory >= 0) {
                if (chest[i][cory] == tmp) count2s++;
                if (count2s >= 5) return true;
                if (chest[i][cory] != tmp) count2s = 0;
            }
            if (corx >= 0 && cory >= 0) {
                if (chest[corx][cory] == tmp) count3s++;
                if (count3s >= 5) return true;
                if (chest[corx][cory] != tmp) count3s = 0;
            }
        }
        for(int p = -4;p <= 4;p++) {
            corx1 = i - p;
            cory1 = j + p;
            if (corx1 >= 0 && cory1 >= 0) {
                if (chest[corx1][cory1] == tmp) count4s++;
                if (count4s >= 5) return true;
                if (chest[corx1][cory1] != tmp) count4s = 0;
            }
        }
        return false;
    }
}
