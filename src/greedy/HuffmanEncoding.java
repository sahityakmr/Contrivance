package greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class HuffmanEncoding {

    // Update solution to hit GFG also.

    public static void main(String[] args) {
        int n = 6;
        String characters = "abcdef";
        int[] frequencies = {5, 9, 12, 13, 16, 45};
        Map<Character, String> huffmanCodes = getHuffmanCodes(characters, frequencies);
        for(char c : characters.toCharArray())
            System.out.print(huffmanCodes.get(c));
        System.out.println();
    }

    private static Map<Character, String> getHuffmanCodes(String characters, int[] frequencies) {
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

        Map<Character, String> huffmanCodes = new HashMap<>();
        fillMap(root, "", huffmanCodes);
        return huffmanCodes;
    }

    private static void fillMap(CharData node, String code, Map<Character, String> huffmanCodes) {
        if (node.left != null)
            fillMap(node.left, code + "0", huffmanCodes);
        if (node.right != null)
            fillMap(node.right, code + "1", huffmanCodes);
        if (node.left == null && node.right == null)
            huffmanCodes.put(node.aChar, code);
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
