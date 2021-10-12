package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WebGen {
    private final String name;
    private final String author;
    private final boolean hasJS;
    private final boolean hasCSS;
    private final String path = System.getProperty("user.dir") + "/website/";

    public WebGen(String name, String author, boolean hasJS, boolean hasCSS) {
        // Set attributes
        this.name = name;
        this.author = author;
        this.hasJS = hasJS;
        this.hasCSS = hasCSS;

        // Generate Files
        generateFiles();
    }

    // Precondition: name is the name of the folder to be created (format: "/FolderName").
    // Post-condition: Creates a new folder within the website directory.
    private void newFolder(String name) {
        new File(this.path + name).mkdirs();
        System.out.printf("Created ./website/%s\n", name);
    }

    // Post-condition: Generates an index.html file using the website's name and author.
    private void generateHTML() {
        // Create the contents of index.html using the site's name and author.
        String contents = String.format(
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
            "    <meta name=\"author\" content=\"%s\">\n" +
            "    <title>%s</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "    \n" +
            "</body>\n" +
            "</html>\n",
            this.author, this.name);

        // Create the index.html file
        File html = new File(this.path + this.name + "/index.html");
        try {
            FileWriter writer = new FileWriter(html);

            // Write the contents to the file
            writer.write(contents);
            writer.close();

            System.out.printf("Created ./website/%s/index.html\n", this.name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Post-condition: Generates all necessary files and folders using the user's input.
    private void generateFiles() {
        // Create the main site folder under the /website/ directory
        newFolder(this.name);

        // Generate the index.html file
        this.generateHTML();

        // Create JS an CSS folders if needed.
        if (this.hasJS)
            newFolder(this.name + "/js/");
        if (this.hasCSS)
            newFolder(this.name + "/css/");
    }

}
