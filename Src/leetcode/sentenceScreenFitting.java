/*
 * question link: https://leetcode.com/problems/sentence-screen-fitting/
 */

class sentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int words = 0;
        for(int i=0,k=0;i<rows;i++) {
            int reminder = cols;
            while(reminder > 0) {
                int currentWordLen = sentence[k].length();   
                reminder -= currentWordLen;
                if(reminder >= 0) {
                    reminder--; //adds the -
                    k++;
                    if(k == sentence.length) {
                        k = 0;
                        words++;
                    }
                }
            }
        }
        return words;
    }
}
