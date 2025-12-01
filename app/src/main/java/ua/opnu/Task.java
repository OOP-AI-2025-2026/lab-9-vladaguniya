package ua.opnu;

import java.util.*;

public class Task {
    public static void main(String[] args) {
    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() <= second.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            String s = list.get(i);
            list.add(i, s);
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        if (list.isEmpty()) return;

        Iterator<String> iterator = list.iterator();
        String current = iterator.next();

        while (iterator.hasNext()) {
            String next = iterator.next();
            if (current.equals(next)) {
                iterator.remove();
            } else {
                current = next;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) return true;

        Deque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            stack.push(val);
            queue.add(val);
        }

        boolean isPalindrome = true;

        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            if (val != stack.pop()) {
                isPalindrome = false;
            }
            queue.add(val);
        }

        return isPalindrome;
    }

    public void reorder(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        int positiveCount = 0;

        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            if (val < 0) {
                stack.push(val);
            } else {
                queue.add(val);
                positiveCount++;
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < positiveCount; i++) {
            queue.add(queue.poll());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        Deque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            if (val % 2 == 0) {
                queue.add(val);
            } else {
                stack.push(val);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < size; i++) {
            int val = queue.poll();
            if (val % 2 != 0) {
                stack.push(val);
            } else {
                queue.add(val);
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public int maxLength(Set<String> set) {
        if (set.isEmpty()) return 0;
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().length() % 2 == 0) {
                it.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        if (map.isEmpty()) return true;

        Set<String> values = new HashSet<>();
        for (String value : map.values()) {
            if (!values.add(value)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer val1 = entry.getValue();

            if (map2.containsKey(key)) {
                Integer val2 = map2.get(key);
                if (val1.equals(val2)) {
                    result.put(key, val1);
                }
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map.isEmpty()) throw new IllegalArgumentException("Map is empty");

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer val : map.values()) {
            counts.put(val, counts.getOrDefault(val, 0) + 1);
        }

        int minCount = Integer.MAX_VALUE;
        int resultValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (count < minCount) {
                minCount = count;
                resultValue = value;
            } else if (count == minCount) {
                if (value < resultValue) {
                    resultValue = value;
                }
            }
        }
        return resultValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) return 0;

        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer num : list) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int maxMode = 0;
        for (Integer count : counts.values()) {
            if (count > maxMode) {
                maxMode = count;
            }
        }
        return maxMode;
    }
}
