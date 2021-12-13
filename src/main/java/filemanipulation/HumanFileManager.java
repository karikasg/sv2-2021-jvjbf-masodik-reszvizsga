package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    private List<Human> humans = new ArrayList<>();



    public void readHumansFromFile(Path path) {
        String name;
        String id;
        List<String> input = new ArrayList<>();
        try {
            input = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
        for (String line : input) {
            humans.add(new Human(line.split(";")[0], line.split(";")[1]));
        }
    }

    public void writeMaleHumansToFile(Path path) {
        List<String> males = new ArrayList<>();

        for (Human human : humans) {
            if ((human.getIdentityNumber().charAt(0) == '1') || human.getIdentityNumber().charAt(0) == '3') {
                males.add(human.getName() + ";" + human.getIdentityNumber());
            }
        }

        try {
            Files.write(path, males);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't write file", ioe);
        }
    }

    public List<Human> getHumans() {
        return humans;
    }
}
