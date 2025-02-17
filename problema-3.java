import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Map<String, int[]> medalhas = new HashMap<>();
        
        // Leitura da entrada até EOF
        while (sc.hasNextLine()) {
            
            sc.nextLine();
            
            
            String ouro = sc.nextLine();
            String prata = sc.nextLine();
            String bronze = sc.nextLine();
            
            
            medalhas.putIfAbsent(ouro, new int[3]);
            medalhas.putIfAbsent(prata, new int[3]);
            medalhas.putIfAbsent(bronze, new int[3]);
            
           
            medalhas.get(ouro)[0]++;   // Ouro
            medalhas.get(prata)[1]++;  // Prata
            medalhas.get(bronze)[2]++; // Bronze
        }
        
        
        List<Map.Entry<String, int[]>> lista = new ArrayList<>(medalhas.entrySet());
        lista.sort((a, b) -> {
            
            for (int i = 0; i < 3; i++) {
                if (a.getValue()[i] != b.getValue()[i]) {
                    return b.getValue()[i] - a.getValue()[i];
                }
            }
            return a.getKey().compareTo(b.getKey()); 
        });
        

        System.out.println("Quadro de Medalhas");
        for (Map.Entry<String, int[]> entry : lista) {
            String pais = entry.getKey();
            int[] med = entry.getValue();
            System.out.println(pais + " " + med[0] + " " + med[1] + " " + med[2]);
        }
        
        sc.close();
    }
}
