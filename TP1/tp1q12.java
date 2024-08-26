public class tp1q12 {
    public static void main(String[] args) {
        String fim = "FIM";
        ciframento(fim);
    }

    public static void ciframento(String fim) {
        String frase;
        StringBuilder ciframento = new StringBuilder();
        frase = MyIO.readLine();
        if(frase.equals("FIM")) {
            return;
        }
        int num = 0;
        ciframento.append(frase);
        for(int i = 0; i < ciframento.length(); i++) {
            num = ciframento.charAt(i);
            num += 3;
            char c = (char) num;
            MyIO.print(c);   
        }
        MyIO.print("\n");         
        ciframento(fim);
    }
}
