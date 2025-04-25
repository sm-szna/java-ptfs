package sm.ptfs;


import sm.ptfs.challenge3.Item;
import sm.ptfs.challenge3.ItemGenerator;
import sm.ptfs.challenge3.ItemPartGenerator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> prefixes = Files.readAllLines(Paths.get(Main.class.getClassLoader().getResource("prefix.txt").toURI()));
        List<String> itemBases = Files.readAllLines(Paths.get(Main.class.getClassLoader().getResource("item.txt").toURI()));
        List<String> suffixes = Files.readAllLines(Paths.get(Main.class.getClassLoader().getResource("suffix.txt").toURI()));

        ItemPartGenerator partGenerator = new ItemPartGenerator(prefixes, itemBases, suffixes);

        ItemGenerator prefixOnlyGenerator = () -> new Item(partGenerator.getRandomPrefix(), partGenerator.getRandomItemBase(), null);
        ItemGenerator suffixOnlyGenerator = () -> new Item(null, partGenerator.getRandomItemBase(), partGenerator.getRandomSuffix());
        ItemGenerator fullItemGenerator = () -> new Item(partGenerator.getRandomPrefix(), partGenerator.getRandomItemBase(), partGenerator.getRandomSuffix());
        ItemGenerator invalidItemGenerator = () -> new Item(partGenerator.getRandomPrefix(), null, partGenerator.getRandomSuffix());

        List<String> prefixOnlyItemNames = createItemNames(prefixOnlyGenerator, 10);
        System.out.println("Prefix only items:");
        for (String name : prefixOnlyItemNames) {
            System.out.printf("%s\n", name);
        }

        List<String> suffixOnlyItemNames = createItemNames(suffixOnlyGenerator, 10);
        System.out.println("Prefix only items:");
        for (String name : suffixOnlyItemNames) {
            System.out.printf("%s\n", name);
        }

        List<String> fullItemNames = createItemNames(fullItemGenerator, 10);
        System.out.println("Full name items:");
        for (String name : fullItemNames) {
            System.out.printf("%s\n", name);
        }

        List<Item> fullItems = createItems(fullItemGenerator, 10);
        System.out.println("Full items:");
        for (Item item : fullItems) {
            System.out.printf("%s\n", item);
        }

    }

    public static List<Item> createItems(ItemGenerator generator, int count) {
        return Collections.nCopies(count, generator).stream()
                .map(ItemGenerator::generate)
                .collect(Collectors.toList());
    }

    public static List<String> createItemNames(ItemGenerator generator, int count) {
        return Collections.nCopies(count, generator).stream()
                .map(ItemGenerator::generate)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}