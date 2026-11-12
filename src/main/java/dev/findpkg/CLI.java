package dev.findpkg;

public class CLI {

    public static void run(String[] args) {

        if (args.length != 2) {
            printHelp();
            return;
        }

        String command = args[0];
        String packageName = args[1];

        switch (command) {
            case "search":
                Detector.search(packageName);
                break;

            default:
                System.out.println("Unknown command: " + command);
                printHelp();
        }
    }

    private static void printHelp() {
        System.out.println("findpkg - Package detector");
        System.out.println();
        System.out.println("Usage:");
        System.out.println("  findpkg search <package>");
    }
}
