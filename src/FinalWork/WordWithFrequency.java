package FinalWork;

import ch04.SeqString;

/**
 * Created by pie on 2015-6-6.
 */
public class WordWithFrequency {
    private SeqString wordValue;
    private int wordTime;

    public SeqString getWordValue() {
        return wordValue;
    }

    public void setWordValue(SeqString wordValue) {
        this.wordValue = wordValue;
    }

    public int getWordTime() {
        return wordTime;
    }

    public void setWordTime(int wordTime) {
        this.wordTime = wordTime;
    }

    public WordWithFrequency(SeqString wordValue, int wordTime) {
        this.wordValue = wordValue;
        this.wordTime = wordTime;
    }

    public WordWithFrequency(SeqString wordValue) {
        this.wordValue = wordValue;
        this.wordTime = 1;
    }

    public WordWithFrequency() {
        wordValue = null;
        wordTime = 0;
    }

    public void timeIncreate() {
        wordTime++;
    }

    public String toString() {
        String outStr =  "word:  " + wordValue + "\t" + "times:  " + wordTime;
        return outStr;
    }
    public void display(){
        System.out.println(this.toString());
    }
}
