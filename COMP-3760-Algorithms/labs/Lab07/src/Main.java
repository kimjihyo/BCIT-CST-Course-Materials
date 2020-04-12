import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class MyStringHashSet {
    private String[] buffer;
    private int numberOfCollisions;
    private String hashType;

    public MyStringHashSet(int size) {
        buffer = new String[size];
        hashType = "H1";
        numberOfCollisions = 0;
    }

    public void setHashType(String hashType) {
        this.hashType = hashType;
    }

    public void reset() {
        buffer = new String[buffer.length];
        numberOfCollisions = 0;
    }

    public boolean containsAll(Collection<? extends String> keyList) {
        for (String key : keyList) {
            if (!contains(key)) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(String key) {
        int index;
        if (hashType.equals("H1")) {
            index = getIndexH1(key);
        } else if (hashType.equals("H2")) {
            index = getIndexH2(key);
        } else {
            index = getIndexH3(key);
        }

        if (buffer[index] == null) {
            return false;
        }

        boolean didReachTheEnd = false;
        while (index < buffer.length && buffer[index] != null && !buffer[index].equals(key)) {
            index++;
            if (index == buffer.length && !didReachTheEnd) {
                index = 0;
                didReachTheEnd = true;
            }
        }

        return buffer[index].equals(key);
    }

    public boolean put(String key) {
        int index;
        if (hashType.equals("H1")) {
            index = getIndexH1(key);
        } else if (hashType.equals("H2")) {
            index = getIndexH2(key);
        } else {
            index = getIndexH3(key);
        }

        if (buffer[index] != null) {
            numberOfCollisions++;
            boolean didReachTheEnd = false;
            while (index < buffer.length && buffer[index] != null) {
                index++;
                if (index == buffer.length && !didReachTheEnd) {
                    index = 0;
                    didReachTheEnd = true;
                }
            }
            if (buffer[index] != null) {
                return false;
            }
        }
        buffer[index] = key;
        return true;
    }

    private int getIndexH1(String str) {
        int key = 0;

        for (char c : str.toCharArray()) {
            key += c - 64;
        }
        return key % buffer.length;
    }

    private int getIndexH2(String str) {
        int key = 0;
        char[] charSequence = str.toCharArray();
        for (int i = 0; i < charSequence.length; i++) {
            key += (charSequence[i] - 64) * Math.pow(26, i);
        }
        return key % buffer.length;
    }

    private int getIndexH3(String str) {
        int key = 0;
        char[] charSequence = str.toCharArray();
        for (int i = 0; i < charSequence.length; i++) {
            key += (charSequence[i] - 64) * Math.pow(13, i);
        }

        return key % buffer.length;
    }

    public int getNumberOfCollisions() {
        return numberOfCollisions;
    }

    public int getSize() {
        int counter = 0;
        for (String s : buffer) {
            if (s != null) {
                counter++;
            }
        }
        return counter;
    }
}

public class Main {
    public static void main(String[] args) {
        testHashSet();
    }

    public static List<String> getNames(String filepath) {
        File file = new File(filepath);
        List<String> nameList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");
            while(scanner.hasNext()) {
                nameList.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            String errorMessage = e.getMessage();
            if (errorMessage != null) {
                System.out.println(errorMessage);
                return null;
            }
        }
        return nameList;
    }

    private static void testHashSet() {
        Map<String, int[]> testMap = new HashMap<>();
        testMap.put("37_names.txt", new int[]{37, 74, 185, 370});
        testMap.put("333_names.txt", new int[]{333, 666, 1665, 3330});
        testMap.put("5163_names.txt", new int[]{5163, 10326, 25815, 51630});

        for (String filepath : testMap.keySet()) {
            int[] setSizes = testMap.get(filepath);
            List<String> nameList = getNames(filepath);
            if (nameList == null) {
                continue;
            }
            for (int setSize : setSizes) {
                System.out.println(String.format("\n\nTesting %s ... size of %d\n\n", filepath, setSize));
                test(nameList, setSize);
            }
        }
    }

    private static void test(List<String> nameList, int setSize) {
        MyStringHashSet hashSet = new MyStringHashSet(setSize);
        hashSet.setHashType("H1");
        System.out.println(String.format("H1::getSize()::%d", hashSet.getSize()));
        for (String name : nameList) {
            hashSet.put(name);
        }
        System.out.println(String.format("H1::getSize()::%d", hashSet.getSize()));
        System.out.println(String.format("H1::getNumberOfCollisions()::%d", hashSet.getNumberOfCollisions()));
        System.out.println(String.format("H3::containsAll::%s", hashSet.containsAll(nameList)));

        hashSet.reset();
        hashSet.setHashType("H2");

        System.out.println(String.format("H3::getSize()::%d", hashSet.getSize()));
        for (String name : nameList) {
            hashSet.put(name);
        }
        System.out.println(String.format("H3::getSize()::%d", hashSet.getSize()));
        System.out.println(String.format("H3::getNumberOfCollisions()::%d", hashSet.getNumberOfCollisions()));
        System.out.println(String.format("H3::containsAll::%s", hashSet.containsAll(nameList)));

        hashSet.reset();
        hashSet.setHashType("H3");

        System.out.println(String.format("H3::getSize()::%d", hashSet.getSize()));
        for (String name : nameList) {
            hashSet.put(name);
        }
        System.out.println(String.format("H3::getSize()::%d", hashSet.getSize()));
        System.out.println(String.format("H3::getNumberOfCollisions()::%d", hashSet.getNumberOfCollisions()));
        System.out.println(String.format("H3::containsAll::%s", hashSet.containsAll(nameList)));
    }
}
