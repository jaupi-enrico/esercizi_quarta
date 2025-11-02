public class Main {
    public static void main(String[] args) {
        // Creo alcune domande
        Risposta[] r1 = {
                new Risposta("Zurigo", false),
                new Risposta("Berna", true),
                new Risposta("Basilea", false),
                new Risposta("Ginevra", false)
        };
        Domanda d1 = new Domanda("Qual è la capitale della Svizzera?", r1);
        d1.setValore(2);

        Risposta[] r2 = {
                new Risposta("Roma", true),
                new Risposta("Milano", false),
                new Risposta("Torino", false),
                new Risposta("Napoli", false)
        };
        Domanda d2 = new Domanda("Qual è la capitale d'Italia?", r2);

        Test quiz = new Test("Le capitali europee");
        quiz.add(d1);
        quiz.add(d2);

        // Mostra informazioni
        System.out.println(quiz);
        System.out.println();

        // Somministrazione
        System.out.println(d1);
        d1.rispondi(2); // rispondo correttamente
        System.out.println("Risposta data: " + d1.getRispostaData());
        System.out.println("Punteggio: " + d1.getPunteggio());

        System.out.println();

        System.out.println(d2);
        d2.rispondi(3); // risposta sbagliata
        System.out.println("Risposta data: " + d2.getRispostaData());
        System.out.println("Punteggio: " + d2.getPunteggio());

        System.out.println();

        // Punteggio totale
        System.out.println("Domande risposte: " + quiz.getQuanteRisposte());
        System.out.println("Punteggio complessivo: " + quiz.getPunteggio() + " / " + quiz.getTotale());
    }
}
