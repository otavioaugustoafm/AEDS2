import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class tp2q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input_string = new String();
        int input_int = 0;
        int numComparacoes = 0;
        int numMovimentacoes = 0;
        long startTime = System.nanoTime(); // Iniciar tempo de execução

        // Ler o CSV, e passar tudo para uma List
        List<Pokemon> pokemons = ReadCsv.readAllFile("/tmp/pokemon.csv");

        // List que iremos adicionar apenas os selecionados da entrada, para trabalhar só com eles
        List<Pokemon> using = new ArrayList<>();

        // Ler até FIM e procurar por ID, e adicionar na List
        while (!(input_string = sc.nextLine()).equals("FIM")) {
            input_int = Integer.parseInt(input_string);
            Pokemon found = PokemonSearch.searchPokemonId(pokemons, input_int);
            if (found != null) {
                using.add(found);
            }
        }

        // Vetor de Pokemon para ordenação
        Pokemon[] pokemonArray = using.toArray(new Pokemon[0]);

        // Realizar a ordenação parcial por seleção com k igual a 10
        int k = 10;
        selectionSortPartial(pokemonArray, k);

        long endTime = System.nanoTime(); // Fim do tempo de execução
        long executionTime = (endTime - startTime) / 1_000_000; // Convertendo para milissegundos

        // Imprimir os registros ordenados na saída padrão (os primeiros 10 estarão ordenados)
        for (Pokemon p : pokemonArray) {
            System.out.println(p);
        }

        // Criar o arquivo de log
        try (PrintWriter writer = new PrintWriter("851568_selecao_parcial.txt")) {
            writer.printf("851568\t%d\t%d\t%dms\n", numComparacoes, numMovimentacoes, executionTime);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }

    // Método para realizar a ordenação parcial por seleção nos primeiros k elementos
    private static void selectionSortPartial(Pokemon[] array, int k) {
        int numComparacoes = 0;
        int numMovimentacoes = 0;
        k = Math.min(k, array.length); // Garantir que k não seja maior que o tamanho do array

        for (int i = 0; i < k; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                numComparacoes++;
                // Comparar os elementos por captureRate e, em caso de empate, pelo nome
                if (comparePokemons(array[j], array[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            // Realizar a troca apenas se necessário
            if (minIndex != i) {
                Pokemon temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                numMovimentacoes++;
            }
        }
    }

    // Método para comparar dois Pokémons por captureRate e, em caso de empate, pelo nome
    private static int comparePokemons(Pokemon p1, Pokemon p2) {
        int typeComparison = p1.getTypes().get(0).compareToIgnoreCase(p2.getTypes().get(0));
        if (typeComparison != 0) {
            return typeComparison;
        }

        // Caso os tipos sejam iguais, comparar pelo nome
        return p1.getName().compareToIgnoreCase(p2.getName());
    }
}

class Pokemon {
    // Atributos privados
    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private Date captureDate;

    // Construtores
    public Pokemon() {
        this.id = 0;
        this.generation = 0;
        this.name = "";
        this.description = "";
        this.types = new ArrayList<>();
        this.abilities = new ArrayList<>();
        this.weight = 0.0;
        this.height = 0.0;
        this.captureRate = 0;
        this.isLegendary = false;
        this.captureDate = new Date();
    }

    public Pokemon(int id, int generation, String name, String description, ArrayList<String> types, 
                   ArrayList<String> abilities, double weight, double height, int captureRate, 
                   boolean isLegendary, Date captureDate) {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.types = types;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.isLegendary = isLegendary;
        this.captureDate = captureDate;
    }

    public Pokemon(String[] aux) throws Exception {
        for (int i = 0; i < aux.length; i++) if (aux[i].isEmpty()) aux[i] = "0";
        this.id = Integer.parseInt(aux[0]);
        this.generation = Integer.parseInt(aux[1]);
        this.name = aux[2];
        this.description = aux[3];

        this.types = new ArrayList<>();
        aux[4] = "'" + aux[4] + "'";
        this.types.add(aux[4]);
        if (!aux[5].equals("0")) {
            aux[5] = "'" + aux[5].trim() + "'";
            this.types.add(aux[5]);
        }

        aux[6] = aux[6].replace("\"", "").replace("[", "").replace("]", "");
        String[] tmp = aux[6].split(",");
        this.abilities = new ArrayList<>();
        for (String s : tmp) abilities.add(s.trim());

        this.weight = Double.parseDouble(aux[7]);
        this.height = Double.parseDouble(aux[8]);
        this.captureRate = Integer.parseInt(aux[9]);
        this.isLegendary = aux[10].equals("1");

        if (aux[11].isEmpty()) {
            this.captureDate = null;
        } else {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            this.captureDate = inputDateFormat.parse(aux[11]);
        }
    }

    // Métodos Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getGeneration() { return generation; }
    public void setGeneration(int generation) { this.generation = generation; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ArrayList<String> getTypes() { return types; }
    public void setTypes(ArrayList<String> types) { this.types = types; }

    public ArrayList<String> getAbilities() { return abilities; }
    public void setAbilities(ArrayList<String> abilities) { this.abilities = abilities; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public int getCaptureRate() { return captureRate; }
    public void setCaptureRate(int captureRate) { this.captureRate = captureRate; }

    public boolean getIsLegendary() { return isLegendary; }
    public void setIsLegendary(boolean isLegendary) { this.isLegendary = isLegendary; }

    public Date getCaptureDate() { return captureDate; }
    public void setCaptureDate(Date captureDate) { this.captureDate = captureDate; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pokemon pokemon = (Pokemon) obj;
        return id == pokemon.id && name.equalsIgnoreCase(pokemon.name);
    }

    // Método clone
    public Pokemon clone() {
        try {
            return (Pokemon) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported.");
            return null;
        }
    }

    // Método para imprimir todos atributos da instancia apenas chamando ela no SOP
    @Override
    public String toString() {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = (captureDate != null) ? outputDateFormat.format(captureDate) : "Data não disponível";
        return "[#" + id + " -> " + name + ": " + description +
            " - " + types + " - " + abilities + 
            " - " + weight + "kg - " + height + "m - " +
            captureRate + "% - " + isLegendary + 
            " - " + generation + " gen] - " + formattedDate;
    }
}

class PokemonSearch {
    public static Pokemon searchPokemonId(List<Pokemon> pokemons, int id) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }

    public static Pokemon searchPokemonName(List<Pokemon> pokemons, String name) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getName().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        return null;
    }
}

class ReadCsv {
    public static List<Pokemon> readAllFile(final String fileToRead) {
        List<Pokemon> pokemon = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileToRead));
            br.readLine();
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = lineFormat(linha);
                Pokemon pessoa = new Pokemon(linha.split(";"));
                pokemon.add(pessoa);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            pokemon = null;
        }

        return pokemon;
    }

    private static String lineFormat(String line) {
        char[] array_aux = line.toCharArray();
        boolean in_list = false;
        for (int i = 0; i < array_aux.length; i++) {
            if (!in_list && array_aux[i] == ',') array_aux[i] = ';';
            else if (array_aux[i] == '"') in_list = !in_list;
        }
        return new String(array_aux);
    }
}
