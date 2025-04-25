package sm.ptfs.challenge3;

import java.util.List;
import java.util.Random;

public record ItemPartGenerator(List<String> prefixes, List<String> itemBases, List<String> suffixes) {
    public static Random random = new Random();

    public String getRandomPrefix(){
        return prefixes.get(random.nextInt(prefixes.size()));
    }

    public String getRandomSuffix(){
        return suffixes.get(random.nextInt(prefixes.size()));
    }

    public String getRandomItemBase(){
        return itemBases.get(random.nextInt(prefixes.size()));
    }
}
