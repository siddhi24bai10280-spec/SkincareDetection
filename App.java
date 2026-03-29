import java.util.Scanner;

class SkinAnalyzer {

    public static String detectSkinType(boolean oily, boolean dry, boolean acne) {
        if (oily && acne) {
            return "Oily Acne-Prone Skin";
        } else if (oily) {
            return "Oily Skin";
        } else if (dry) {
            return "Dry Skin";
        } else {
            return "Normal Skin";
        }
    }

    public static void giveRecommendation(String skinType) {
        System.out.println("\n--- Skincare Recommendation ---");

        switch (skinType) {
            case "Oily Acne-Prone Skin":
                System.out.println("Use oil-free cleanser, avoid heavy creams, and use salicylic acid products.");
                break;

            case "Oily Skin":
                System.out.println("Use gel-based face wash and lightweight moisturizer.");
                break;

            case "Dry Skin":
                System.out.println("Use hydrating cleanser and apply a rich moisturizer.");
                break;

            default:
                System.out.println("Maintain a basic skincare routine.");
        }
    }
}

public class App {

    public static int getInput(Scanner sc, String message) {
        int value = -1;

        System.out.print(message);

        if (sc.hasNextLine()) {
            String input = sc.nextLine().trim();

            try {
                value = Integer.parseInt(input);
            } catch (Exception e) {
                value = -1;
            }
        }

        if (value != 0 && value != 1) {
            System.out.println("No valid input detected. Defaulting to 0 (No).");
            value = 0;
        }

        return value;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== AI Skincare Detector =====");

        int oilyInput = getInput(sc, "Do you have oily skin? (1 = Yes, 0 = No): ");
        int dryInput = getInput(sc, "Do you have dry skin? (1 = Yes, 0 = No): ");
        int acneInput = getInput(sc, "Do you have acne? (1 = Yes, 0 = No): ");

        boolean oily = (oilyInput == 1);
        boolean dry = (dryInput == 1);
        boolean acne = (acneInput == 1);

        String skinType = SkinAnalyzer.detectSkinType(oily, dry, acne);

        System.out.println("\nDetected Skin Type: " + skinType);

        SkinAnalyzer.giveRecommendation(skinType);

        sc.close();
    }
}
