public class algorithm {
    static final int WIN5= 10000;
    static final int ALive4 = 10000;
    static final int ALive3 = 1000;
    static final int Alive2 = 100;
    static final int Die3 = 100;
    static final int Die4 = 1000;
    static final int Die2 = 10;
    static final int Alive1 =10;
    static int cur_x;
    static int cur_y;
    static int x_y_aris[] = new int[16];
    static int y_x_aris[] = new int[16];
    static boolean Ifwin;
    algorithm()
    {
        for(int i=0;i<16;i++)
        {
            x_y_aris[i] = -1;
            y_x_aris[i] = -1;
        }
    }


    protected static boolean Ifstop (int chest[][],int i,int j,int tmp,boolean Ifstart)
    {
        if(chest[i][j]!=tmp && chest[i][j]!=0 && Ifstart ==false)return true;
        else return false;
    }
    static int countScore(int counts,int flag)
    {
        if(flag == 2)return 0;
        else if (counts==5) {
            Ifwin = true;
            return WIN5;
        }
        else if(flag == 0) {
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
                    return WIN5;}
                default:return 0;
            }
        }
        else if(flag==1)
        {
            switch(counts){
                case 2:return Die2;
                case 3:return Die3;
                case 4:return Die4;
                default:return 0;
            }
        }
        else return 0;

    }
    protected static int  Checkwin(int chest[][],int tmp) {//判断是否赢了
        Ifwin = false;
        int ans = 0;//返回情况的总分
        boolean DeadorAlice = false;//判断是活棋还是死棋
        int counts = 0;//连字数
        int flag = 0;//被挡数
        boolean Ifstart = true;
        for (int i = 0; i <= 15; i++)//竖着
            for (int j = 0; j < 15; j++) {
                if (chest[i][j] != tmp && Ifstart) continue;
                if (chest[i][j] == tmp) {
                    if (Ifstart) {
                        if (j == 0) flag++;
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
                ans += countScore(counts, flag);
                flag = 0;
                counts = 0;
                Ifstart = true;
            }
        for (int j = 0; j <= 15; j++)
            for (int i = 0; i < 15; i++)//横着
            {
                if (chest[i][j] != tmp && Ifstart) continue;
                if (chest[i][j] == tmp) {
                    if (Ifstart) {

                        if (j == 0) flag++;
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
                ans += countScore(counts, flag);
                flag = 0;
                counts = 0;
                Ifstart = true;

        }

        for(int p =0;p<=15;p++)
        {
            for(int i=0,j;i<=15;i++)
            {
                j = i;
                cur_x = 0+j;
                cur_y = p+i;
                if(cur_y>15)continue;
                if (chest[cur_y][cur_x] != tmp && Ifstart) continue;
                if (chest[cur_y][cur_x] == tmp) {
                    if (Ifstart) {

                        if (cur_y == 0) flag++;
                        else if (chest[cur_y - 1][cur_x-1] != tmp && chest[cur_y - 1][cur_x-1] != 0) flag++;
                        Ifstart = false;
                    }
                    counts++;
                    continue;

                }
                if (Ifstop(chest, i, j, tmp, Ifstart))//被挡了
                {
                    flag++;
                }
                System.out.println(counts);
                ans += countScore(counts, flag);
                flag = 0;
                counts = 0;
                Ifstart = true;


            }
        }
        return ans;
    }

    }



