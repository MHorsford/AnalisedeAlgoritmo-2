import java.io.IOException;
import java.util.*;

class Pais {
    String nome;
    int ouro, prata, bronze;

    public Pais(String nome, int ouro, int prata, int bronze) {
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        try {
            int N = sc.nextInt();
            sc.nextLine(); 

            if (N <= 0) {
                throw new IllegalArgumentException("O número de países deve ser maior que zero.");
            }

            List<Pais> paises = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                String nome = sc.next();
                int ouro = sc.nextInt();
                int prata = sc.nextInt();
                int bronze = sc.nextInt();

                if (ouro < 0 || prata < 0 || bronze < 0) {
                    throw new IllegalArgumentException("Número de medalhas não pode ser negativo.");
                }

                paises.add(new Pais(nome, ouro, prata, bronze));
            }

            Collections.sort(paises, (a, b) -> {
                if (a.ouro != b.ouro) return Integer.compare(b.ouro, a.ouro);
                if (a.prata != b.prata) return Integer.compare(b.prata, a.prata);
                if (a.bronze != b.bronze) return Integer.compare(b.bronze, a.bronze);
                return a.nome.compareTo(b.nome);
            });

            for (Pais p : paises) {
                System.out.println(p.nome + " " + p.ouro + " " + p.prata + " " + p.bronze);
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Certifique-se de inserir valores corretos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
