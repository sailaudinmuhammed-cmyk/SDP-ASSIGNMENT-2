import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        String modeInput;
        String platformInput;

        if (args.length >= 2) {
            modeInput = args[0];
            platformInput = args[1];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Delivery mode (ROAD/SEA): ");
            modeInput = scanner.hasNextLine() ? scanner.nextLine() : "";
            System.out.print("UI platform (WINDOWS/MACOS): ");
            platformInput = scanner.hasNextLine() ? scanner.nextLine() : "";
        }

        if (modeInput == null || modeInput.isBlank()) {
            System.out.println("Error: delivery mode was not provided. Stopping.");
            return;
        }
        if (platformInput == null || platformInput.isBlank()) {
            System.out.println("Error: UI platform was not provided. Stopping.");
            return;
        }

        String mode = modeInput.trim().toUpperCase();
        String platform = platformInput.trim().toUpperCase();

        Logistics logistics;
        switch (mode) {
            case "ROAD" -> logistics = new RoadLogistics();
            case "SEA" -> logistics = new SeaLogistics();
            default -> {
                System.out.println("Error: unsupported delivery mode '" + modeInput + "'. Use ROAD or SEA. Stopping.");
                return;
            }
        }

        GUIFactory guiFactory;
        switch (platform) {
            case "WINDOWS" -> guiFactory = new WindowsFactory();
            case "MACOS" -> guiFactory = new MacOSFactory();
            default -> {
                System.out.println("Error: unsupported UI platform '" + platformInput + "'. Use WINDOWS or MACOS. Stopping.");
                return;
            }
        }

        System.out.println("Delivery mode: " + mode);
        System.out.println("UI platform: " + platform);

        DeliveryApplication app = new DeliveryApplication(guiFactory, logistics);
        app.run("laboratory equipment", "Aktau warehouse");
    }
}