import java.util.Scanner;

public class LapLichTaiNguyen1 {
    public static int ans[],cs,s[],f[],Max;
    public static boolean dd[];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        s=new int[n];
        f=new int[n];
        ans=new int[n];
        dd=new boolean[n];
        cs=0;
        Max=0;
        for(int i=0;i<n;i++){
            s[i]=scanner.nextInt();
        }
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            dd[i]=false;
            f[i]=scanner.nextInt();
        }
        run(n,a,0);
        for(int i=0;i<=Max;i++){
            System.out.println(s[ans[i]]+" "+f[ans[i]]);
        }
        System.out.println("So hoat dong: "+(Max+1));
    }
    public static void run(int n,int a[],int t){
        for(int i=0;i<n;i++){
            if(t==0){
                dd[i]=true;
                a[t]=i;
                run(n,a,t+1);
                dd[i]=false;
            }else {
                if (s[i] >= f[a[t-1]] && dd[i]==false) {
                    a[t] = i;
                    if (t > Max) {
                        Max = t;
                        for (int j = 0; j <= t; j++) {
                            ans[j] = a[j];
                        }
                    }
                    dd[i]=true;
                    run( n, a, t + 1);
                    dd[i]=false;
                }
            }
        }
    }
}
