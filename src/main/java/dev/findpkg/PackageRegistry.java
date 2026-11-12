package dev.findpkg;

public class PackageRegistry {

    public static String[] getCommand(String name) {

        return switch (name.toLowerCase()) {
            case "node", "nodejs" ->
                new String[]{"node", "--version"};

            case "python", "python3" ->
                new String[]{"python3", "--version"};

            case "java" ->
                new String[]{"java", "-version"};

            case "git" ->
                new String[]{"git", "--version"};

            case "rust", "rustc" ->
                new String[]{"rustc", "--version"};

            case "cargo" ->
                new String[]{"cargo", "--version"};

            case "npm" ->
                new String[]{"npm", "--version"};

            default ->
                new String[]{name, "--version"};
        };
    }
}
