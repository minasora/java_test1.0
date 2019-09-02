import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class algorithm {
    class Pos
    {
        int x;
        int y;
        int ans;
    }
    static final int MAX_depth = 5;
    static final int WIN5 = 10000;
    static final int ALive4 = 10000;
    static final int ALive3 = 1000;
    static final int Alive2 = 100;
    static final int Die3 = 100;
    static final int Die4 = 1000;
    static final int Die2 = 10;
    static final int Alive1 = 10;
    static int cur_x;
    static int cur_y;
    static int[] x_y_aris = new int[16];
    static int[] y_x_aris = new int[16];
    //返回情况的总分
    static boolean DeadorAlice = false;//判断是活棋还是死棋
    static int counts = 0;//连字数
    static int flag = 0;//被挡数
    static boolean Ifstart = true;
    static boolean Ifwin;
    static int ans = 0;
    static int ans1 = 0;

    algorithm() {
        for (int i = 0; i < 16; i++) {
            x_y_aris[i] = -1;
            y_x_aris[i] = -1;
        }
    }


    protected static boolean Ifstop(int[][] chest, int i, int j, int tmp, boolean Ifstart) {
        return chest[i][j] != tmp && chest[i][j] != 0 && Ifstart == false;
    }

    static int countScore(int counts, int flag) {
        if (flag == 2) return 0;
        else if (counts == 5) {
            Ifwin = true;
            return WIN5;
        } else if (flag == 0) {
            switch (counts) {
                case 1:
                    return Alive1;
                case 2:
                    return Alive2;
                case 3:
                    return ALive3;
                case 4:
                    return ALive4;
                case 5: {
                    return WIN5;
                }
                default:
                    return 0;
            }
        } else if (flag == 1) {
            switch (counts) {
                case 2:
                    return Die2;
                case 3:
                    return Die3;
                case 4:
                    return Die4;
                default:
                    return 0;
            }
        } else return 0;

    }

    private static void restart() {
        ans += countScore(counts, flag);
        flag = 0;
        counts = 0;
        Ifstart = true;
    }

    public static int Checkwin(int[][] chest, int tmp) {//评估函数
        ans = 0;
        Ifwin = false;
        for (int i = 0; i <= 15; i++)//竖着
            for (int j = 0; j <= 15; j++) {
                if (chest[i][j] != tmp && Ifstart) continue;
                if (chest[i][j] == tmp) {
                    if (Ifstart) {
                        if (j == 0 || j == 15 || i == 0 || i == 15) flag++;
                        else if (chest[i][j - 1] != tmp && chest[i][j - 1] != 0) flag++;
                        Ifstart = false;
                    }
                    counts++;
                    continue;
                }
                if (Ifstop(chest, i, j, tmp, Ifstart))//被挡了
                {
                    flag++;
                }
                restart();
            }
        Ifstart = true;
        for (int j = 0; j <= 15; j++) {
            for (int i = 0; i <= 15; i++)//横着
            {
                if (chest[i][j] != tmp && Ifstart) continue;
                if (chest[i][j] == tmp) {
                    if (Ifstart) {
                        if (j == 0 || j == 15 || i == 0 || i == 15) flag++;
                        else if (chest[i - 1][j] != tmp && chest[i - 1][j] != 0) flag++;
                        Ifstart = false;
                    }
                    counts++;
                    continue;
                }
                if (Ifstop(chest, i, j, tmp, Ifstart))//被挡了
                {
                    flag++;
                }
                restart();

            }
        }
        Ifstart = true;
        for (int p = 0; p <= 29; p++) {
            for (int i = 0, j = 0; i <= 15; i++) {
                cur_x = i;
                cur_y = p + i;
                if (p >= 15) {
                    j = p - 15;
                    cur_x = j + i;
                    cur_y = i;
                }
                if (cur_y > 15 || cur_x > 15) continue;
                if (chest[cur_y][cur_x] != tmp && Ifstart) continue;
                if (chest[cur_y][cur_x] == tmp) {
                    if (Ifstart) {

                        if (cur_y == 0 || cur_x == 0 || cur_y == 15 || cur_x == 15) flag++;
                        else if (chest[cur_y - 1][cur_x - 1] != tmp && chest[cur_y - 1][cur_x - 1] != 0) flag++;
                        Ifstart = false;
                    }
                    counts++;
                    continue;

                }
                if (Ifstop(chest, i, j, tmp, Ifstart))//被挡了
                {
                    flag++;
                }
                restart();
            }
        }

        for (int p = 0; p <= 29; p++) {
            for (int i = 0, j = 0; i <= 15; i++) {
                cur_x = p - i;
                cur_y = i;
                if (p >= 15) {
                    j = p - 15;
                    cur_x = i;
                    cur_y = p - i;
                }
                if (cur_y > 15 || cur_x > 15 || cur_y < 0 || cur_x < 0) continue;
                if (chest[cur_y][cur_x] != tmp && Ifstart) continue;
                if (chest[cur_y][cur_x] == tmp) {
                    if (Ifstart) {

                        if (cur_y == 0 || cur_x == 0 || cur_y == 15 || cur_x == 15) flag++;
                        else if (chest[cur_y + 1][cur_x - 1] != tmp && chest[cur_y + 1][cur_x - 1] != 0) flag++;
                        Ifstart = false;
                    }
                    counts++;
                    continue;

                }
                if (Ifstop(chest, i, j, tmp, Ifstart))//被挡了
                {
                    flag++;
                }
                restart();
            }
        }
        return ans;
    }

    protected static boolean If_stable(int[][] chest, int x, int y)//周围有棋子才考虑
    {
        if (x == 0 || y == 0 || x == 16 || y == 16) return false;
        if (chest[x][y] != 0) return false;
        else return (chest[x + 1][y + 1] != 0 || chest[x + 1][y] != 0 || chest[x + 1][y - 1] != 0 || chest[x - 1][y - 1] != 0 || chest[x - 1][y + 1] != 0 || chest[x - 1][y] != 0 || chest[x][y - 1] != 0 || chest[x][y + 1] != 0);
    }

    /*
//极大极小搜索，设置迭代次数，自己下的时候选择
    protected static void MAX_MIN_search(int tmp,int chest[][])
    {
        int MAX_score=0;
        int MIN_score=0;
        int ans =-999;
        int cur_x1 = 0;
        int cur_y1 = 0;
        int cur_x2 =0;
        int cur_y2 = 0;
            for(int i=0;i<=15;i++)
                for(int j=0;j<=15;j++)
                {
                    if(If_stable(chest,i,j))
                    {
                        chest[i][j] =(tmp%2);
                        MAX_score =Checkwin(chest,tmp%2);
                        if(ans < MAX_score)
                        {
                            cur_x1 = i;
                            cur_y1 = j;
                            ans = MAX_score;
                        }

                        chest[i][j] = 0;
                    }

                }
            ans = ans +MAX_score;
        for(int i=0;i<=15;i++)
            for(int j=0;j<=15;j++)
            {
                if(If_stable(chest,i,j))
                {
                    chest[i][j] =(tmp%2+1);
                    if(MIN_score > Checkwin(chest,tmp%2+1))
                    {
                        cur_x2 = i;
                        cur_y2 = j;
                        MIN_score = Checkwin(chest,tmp%2+1);
                    }
                    chest[i][j] = 0;
                }

            }
         for(int i =0;i<=15;i++)
             for(int j=0;j<=15;j++)
             {

             }
        }

     */
    static int cur_x1;
    static int cur_y1;
    static int[][] result = new int[16][16];
    static int ans_1 =-9999;
    static int ans_2 =-9999;
    protected void binary_search(int[][] chest)//基本搜索，给子节点赋值
    {
        for(int i=0;i<=15;i++)
            for(int j=0;j<=15;j++)
            {
                result[i][j] = Checkwin(chest,1);
            }
    }

    protected  void MAX_MIN_search(int[][] chest, int depth)
    {

        if(depth == 1)//最小深度
        {
            binary_search(chest);//给子节点赋值
            return;
        }
        if(depth%2==0)//偶数层，极小搜索
        {
            for(int i =0;i<=15;i++)
                for(int j=0;j<=15;j++)
                    if(If_stable(chest,i,j))//假如可搜索
                    {
                        chest[i][j] = 2;
                        MAX_MIN_search(chest,depth-1);
                        MIN_search(chest);
                        result[i][j] = MIN_search(chest).ans;
                        chest[i][j] = 0;
                    }
        }
        if(depth%2==1)//奇数层，极大搜索
        {
            for(int i =0;i<=15;i++)
                for(int j=0;j<=15;j++)
                    if(If_stable(chest,i,j))//假如可搜索
                    {
                        chest[i][j] = 1;
                        MAX_MIN_search(chest,depth-1);

                        MAX_search(chest);
                        chest[i][j] = 0;
                    }

        }
        for(int i=0;i<=15;i++) {
            for (int j = 0; j <= 15; j++)
                System.out.print(result[i][j]);
            System.out.println();
        }
        Pos pos = MAX_search(chest);
        chest[pos.x][pos.y] = 1;


    }
    protected  Pos MIN_search(int[][] chest)//极小搜索
    {
        int ans = 99999999;
        Pos pos = new Pos();
        for(int i = 0;i<=15;i++)
            for(int j=0;j<=15;j++)
                if(If_stable(chest,i,j)) {
                    if (result[i][j] < ans) {
                        ans = result[i][j];
                        pos.x = i;
                        pos.y = j;
                        pos.ans = ans;
                    }
                }
        return pos;
    }
    protected  Pos MAX_search(int[][] chest)//极大搜索
    {
        int ans = -1;
        Pos pos = new Pos();
        for(int i=0;i<=15;i++)
            for(int j=0;j<=15;j++)
                if(If_stable(chest,i,j)) {
                    if (result[i][j] > ans) {
                        ans = result[i][j];
                        pos.x = i;
                        pos.y = j;
                    }
                }
        return pos;
    }




       /* int ans =-9999;
        if(depth==3)
        {
           for(int i=0;i<=15;i++)
               for(int j=0;j<=15;j++)
                   result[i][j] = Checkwin(chest,1)-Checkwin(chest,2);
               return;
        }
        for(int i=0;i<=15;i++)
            for(int j=0;j<=15;j++)
            {
                if(If_stable(chest,i,j)) {
                    chest[i][j] = (depth + 1) % 2 + 1;
                    MAX_search(chest, depth + 1);
                    for(int p=0;p<=15;p++)
                        for(int q=0;q<=15;q++) {
                            if(ans<result[p][q])
                                ans =result[p][q];
                                cur_x1 = p;
                                cur_y1 = q;
                        }
                    chest[i][j] = 0;
                }
            }

        */

        protected static void print()
        {
        for(int i=0;i<=15;i++)
            {
            for(int j=0;j<=15;j++)
            {
                if(If_stable(singlegame.chest,j,i)) {

                    System.out.printf("%3s",result[i][j]);
                    System.out.print(" ");
                }
                else if(singlegame.chest[j][i]!=0)
                {
                    System.out.printf("%3s",singlegame.chest[j][i]);
                    System.out.print(" ");
                }
            }
                System.out.println();
    }

}
}




