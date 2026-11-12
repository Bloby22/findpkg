package dev.findpkg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class Detector {

    public static void search(String name) {

        String[] command = PackageRegistry.getCommand(name);

        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.redirectErrorStream(true);

            Process process = builder.start();
            
            boolean finished = process.waitFor(
                5, TimeUnit.SECONDS
            );

            if (!finished) {
                process.destroyForcibly();
                System.out.println("Version check timed out");
                return;
            }

            if (process.exitValue() != 0) {
                printNotInstalled(name);
                return;
            }

            try (BufferedReader reader =
                    new BufferedReader(
                        new InputStreamReader(
                            process.getInputStream()
                        )
                    )) {

                String version = reader.readLine();

                if (version != null && !version.isBlank()) {
                    System.out.println("Package: " + name);
                    System.out.println("Status: Installed");
                    System.out.println("Version: " + version.trim());
                } else {
                    System.out.println("Version unavailable: " + name);
                }
            }

        } catch (Exception e) {
            printNotInstalled(name);
        }
    }

    private static void printNotInstalled(String name) {
        System.out.println("Package: " + name);
        System.out.println("Status: Not installed or unavailable");
    }
}
