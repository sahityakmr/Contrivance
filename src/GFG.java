import java.util.*;
import java.util.stream.IntStream;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String characters = sc.next();
            int[] frequencies = new int[characters.length()];
            for (int i = 0; i < characters.length(); i++) {
                frequencies[i] = sc.nextInt();
            }
            getHuffmanCodes(characters, frequencies);
            System.out.println();
        }
    }

    private static void getHuffmanCodes(String characters, int[] frequencies) {
        PriorityQueue<CharData> queue = new PriorityQueue<CharData>(Comparator.comparingInt(charData -> charData.freq));
        IntStream.range(0, characters.length())
                .mapToObj(i -> new CharData(characters.charAt(i), frequencies[i]))
                .forEach(queue::add);

        // building huffman tree
        while (queue.size() > 1) {
            CharData left = queue.poll();
            CharData right = queue.poll();
            CharData internalData = new CharData('`', left.freq + right.freq);
            internalData.left = left;
            internalData.right = right;
            queue.add(internalData);
        }

        CharData root = queue.poll();

        fillMap(root, "");
    }

    private static void fillMap(CharData node, String code) {
        if (node.left != null)
            fillMap(node.left, code + "0");
        if (node.right != null)
            fillMap(node.right, code + "1");
        if (node.left == null && node.right == null)
            System.out.print(code + " ");
    }

    static class CharData {
        char aChar;
        int freq;
        CharData left;
        CharData right;

        public CharData(char aChar, int freq) {
            this.aChar = aChar;
            this.freq = freq;
        }
    }
}