package com.wen.ThirteenthFifty;

import javafx.util.Pair;

import java.util.*;

public class LQDesignSearchAutocompleteSystem {
    class AutoCompleteSystem{
        class TrieNode {
            public boolean isEnd;
            public Map<String, Integer> freq;
            public Map<Character, TrieNode> children;
            public TrieNode() {
                this.freq = new HashMap<>();
                this.children = new HashMap<>();
            }
        }

        // cur tracks current input is at which TrieNode
        TrieNode root, cur;
        // sb stores current input string
        StringBuilder sb;

        public AutoCompleteSystem(String[] sentences, int[] times) {
            if (sentences == null || times == null || sentences.length != times.length){
                return;
            }
            reset();
            root = new TrieNode();
            for (int i = 0; i < times.length; i++) {
                insert(sentences[i], times[i]);
            }
        }

        private void reset() {
            cur = null;
            sb = new StringBuilder();
        }

        private void insert(String sentence, int count) {
            if (sentence == null || sentence.length() == 0) return;
            TrieNode node = root;
            for (char c : sentence.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
                node.freq.put(sentence, node.freq.getOrDefault(sentence, 0) + count);
            }
            node.isEnd = true;
        }

        public List<String> input(char c) {
            List<String> result = new ArrayList<>();
            if (cur == null) cur = root;
            if (c == '#') { // save sentence and reset state
                insert(sb.toString(), 1);
                reset();
                return result;
            }

            sb.append(c);
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);

            result.addAll(findTopK(cur, 3));

            return result;
        }

        private List<String> findTopK(TrieNode node, int k) {
            List<String> result = new ArrayList<>();
            if (node.freq.isEmpty()){
                return result;
            }
            PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                    (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
            for (Map.Entry<String, Integer> entry : node.freq.entrySet()) {
                if (queue.size() < k || entry.getValue() >= queue.peek().getValue()) {
                    queue.offer(entry);
                }
                if (queue.size() > k) queue.poll();
            }

            while (!queue.isEmpty()) {
                result.add(0, queue.poll().getKey());
            }

            return result;
        }
    }
}
