import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem-vindo ao Blackjack!");
        
        // Embaralhar o baralho (não implementado neste exemplo)
        
        // Inicializar as mãos do jogador e do dealer
        int[] playerHand = new int[2];
        int[] dealerHand = new int[2];
        
        // Distribuir as primeiras duas cartas para o jogador e o dealer
        playerHand[0] = dealCard();
        playerHand[1] = dealCard();
        dealerHand[0] = dealCard();
        dealerHand[1] = dealCard();
        
        // Mostrar a mão do jogador e a carta visível do dealer
        System.out.("Sua mão: " + playerHand[0] + ", " + playerHand[1]);
        System.out.println("Carta visível do dealer: " + dealerHand[0]);
        
        // Verificar se o jogador tem um blackjack (21 com duas cartas)
        if (getHandValue(playerHand) == 21) {
            System.out.println("Blackjack! Você ganhou!");
            return;
        }
        
        // Pedir ao jogador para bater (pedir outra carta) ou ficar
        while (true) {
            System.out.println("Deseja bater (s/n)?");
            String choice = scanner.nextLine();
            
            if (choice.equalsIgnoreCase("s")) {
                // O jogador escolheu bater
                int newCard = dealCard();
                playerHand = addCardToHand(playerHand, newCard);
                System.out.println("Sua nova carta: " + newCard);
                
                // Verificar se o jogador estourou (passou de 21)
                if (getHandValue(playerHand) > 21) {
                    System.out.println("Você estourou! Dealer ganhou!");
                    return;
                }
            } else if (choice.equalsIgnoreCase("n")) {
                // O jogador escolheu ficar
                break;
            } else {
                // Entrada inválida, pedir novamente
                System.out.println("Por favor, responda com 's' ou 'n'.");
            }
        }
        
        // O jogador decidiu ficar, agora é a vez do dealer jogar
        while (getHandValue(dealerHand) < 17) {
            // O dealer deve bater se a mão dele for menor que 17
            int newCard = dealCard();
            dealerHand = addCardToHand(dealerHand, newCard);
            System.out.println("Dealer pegou uma carta: " + newCard);
        }
        
        // Mostrar as mãos finais do jogador e do dealer
        System.out.println("Sua mão final: " + arrayToString(playerHand));
        System.out.println("Mão do dealer: " + arrayToString(dealerHand));
        
        // Determinar o vencedor
        int playerValue = getHandValue(playerHand);
        int dealerV
