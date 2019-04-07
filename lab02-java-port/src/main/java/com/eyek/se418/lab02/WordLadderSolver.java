package com.eyek.se418.lab02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordLadderSolver {

    HashMap<String, Boolean> vis;
    class Node {
        String word;
        Node parent;

        Node(String word, Node parent) {
            this.word = word;
            this.parent = parent;
        }
    }

    public void loadDictionary(int length) throws IOException{
        // read data from English dictionary

        // open file
        FileReader dictFile;
        try {
            dictFile = new FileReader("assets/EnglishWords.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
            return;
        }

        // read file
        BufferedReader dictReader = new BufferedReader(dictFile);
        String word;
        this.vis = new HashMap<>();
        do {
            word = dictReader.readLine();
            if(word == null) break;
            if(word.length() == length) this.vis.put(word, false);
        } while(true);
    }

    private static boolean isNeighbor(String a, String b){
        // assume that a.length() == b.length()
        int len = a.length();
        boolean flag = true;
        for(int i = 0;i<len;i++)
            if(a.charAt(i) != b.charAt(i))
                if(flag) flag = false;
                else return false;
        return true;
    }

    public ArrayList<String> findLadder(String s, String e){
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> mem = new ArrayList<>();

        Node start = new Node(s, null);
        mem.add(start);
        q.offer(start);
        while(!q.isEmpty()){
            Node cur = q.remove();
            if(cur.word.equals(e)){
                // "Victor!"
                // find the link, reverse it and return
                ArrayList<String> ans = new ArrayList<>();
                do {
                    ans.add(cur.word);
                    cur = cur.parent;
                } while(cur != null);
                Collections.reverse(ans);
                return ans;
            }
            // find unvisited neighbor words
            for(SortedMap.Entry<String, Boolean> entry: this.vis.entrySet()) {
                if(!entry.getValue() && isNeighbor(cur.word, entry.getKey())) {
                    Node next = new Node(entry.getKey(), cur);
                    mem.add(next);
                    q.offer(next);
                    this.vis.put(entry.getKey(), true);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String startWord, destinationWord;
        WordLadderSolver solver = new WordLadderSolver();

        // read user input
        System.out.print("Enter start word (RETURN to quit): ");
        startWord= scanner.nextLine();
        if(startWord.isEmpty())
            return;

        System.out.print("Enter destination word: ");
        destinationWord = scanner.nextLine();
        if(destinationWord.isEmpty())
            return;

        if(startWord.length() != destinationWord.length()) {
            System.out.println("Error: Start word and destination word have different length.");
            return;
        }

        // load the dictionary
        solver.loadDictionary(startWord.length());
        // find path
        ArrayList<String> ans = solver.findLadder(startWord, destinationWord);
        if(ans != null) {
            System.out.print("Found path: ");
            for(int i = 0;i<ans.size();i++){
                System.out.print(ans.get(i));
                if(i != ans.size() - 1) System.out.print(" => ");
            }
            System.out.println();
        } else {
            System.out.println("No path found.");
        }
    }
}