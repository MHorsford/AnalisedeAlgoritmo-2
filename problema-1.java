import java.io.IOException;
 import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        
        String[] nomes = new String[N];


        for (int i = 0; i < N; i++) {
            nomes[i] = sc.nextLine();
        }

        Arrays.sort(nomes);

        System.out.println(nomes[K - 1]);

        sc.close();
    }
}
