package com.jolly.slotweb;

import com.jolly.slotweb.model.SlotResult;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SlotService {
    private final String[] symbols = {"🥨", "🍕", "🍿", "🌭", "🍔"};
    private final Random random = new Random();

    public SlotResult spin(int balance, int bet) {
        if (bet < 50) return new SlotResult(null, balance, "Minimum bet is $50");
        if (bet > balance) return new SlotResult(null, balance, "Insufficient balance!");

        balance -= bet;
        String[] picked = new String[3];
        for (int i = 0; i < 3; i++) {
            picked[i] = symbols[random.nextInt(symbols.length)];
        }

        int prize = calculatePrize(picked, bet);
        balance += prize;

        String message = (prize > 0) ? "You won $" + prize : "You lost!";
        return new SlotResult(picked, balance, message);
    }

    private int calculatePrize(String[] result, int bet) {
        if (result[0].equals(result[1]) && result[1].equals(result[2])) {
            return switch (result[0]) {
                case "🥨" -> bet * 4;
                case "🍕" -> bet * 6;
                case "🍿" -> bet * 8;
                case "🌭" -> bet * 10;
                case "🍔" -> bet * 12;
                default -> 0;
            };
        }

        if (result[0].equals(result[1]) || result[0].equals(result[2])) {
            return switch (result[0]) {
                case "🥨" -> bet * 2;
                case "🍕" -> bet * 3;
                case "🍿" -> bet * 4;
                case "🌭" -> bet * 5;
                case "🍔" -> bet * 6;
                default -> 0;
            };
        }

        if (result[1].equals(result[2])) {
            return switch (result[1]) {
                case "🥨" -> bet * 2;
                case "🍕" -> bet * 3;
                case "🍿" -> bet * 4;
                case "🌭" -> bet * 5;
                case "🍔" -> bet * 6;
                default -> 0;
            };
        }

        return 0;
    }
}
