package FinalWork;

import ch04.SeqString;
import tools.TextReader;

/**
 * Created by pie on 2015-6-6.
 */
public class WordCounter {
    //定义字符串存储从文本中读取的数据流
    private SeqString wordStr;
    //用数组存储不同单词的值和频率
    //二维数组建立索引，26对应26个英文字母，便于首字母排序
    private WordWithFrequency[][] wordResult = new WordWithFrequency[26][50];

    private int beginIndex = 0;
    private int endIndex = 0;

    public WordCounter(String text) {
        wordStr = new SeqString(text);
    }

    public WordWithFrequency[][] getWordResult() {
        return wordResult;
    }

    public void count() {
        char currChar, preChar;
        //处理头部空格及特殊符号
        int i = 1;
        while (wordStr.charAt(i)<65 || wordStr.charAt(i)>122 || (wordStr.charAt(i)>90 && wordStr.charAt(i)<97)){
            i++;
        }

        for (;i < wordStr.length(); i++) {
            currChar = wordStr.charAt(i);   //当前字符
            preChar = wordStr.charAt(i - 1);  //前一个字符

            //处理结尾无标点
//            if( i == wordStr.length()-1){
//                //如果是字母
//                if (isLetter(wordStr.charAt(i))) {
//                    endIndex = i;
//                    SeqString temp = wordStr.substring(beginIndex, endIndex);
//                    beginIndex = endIndex;
//                    disposeWord(temp);
//                }
//            }

            if ((int) (currChar) < 65 || (int) (currChar) > 122 //当前字符不是字母
                   ) {

                if (((int) (preChar) >= 65 && (int) (preChar) <= 90) //当前字符的前一个字符是字母
                        || ((int) (preChar) >= 97 && (int) (preChar) <= 122)) {

                    endIndex = i;
                    SeqString temp = wordStr.substring(beginIndex, endIndex);
                    beginIndex = endIndex;
                    disposeWord(temp);
                } else {
                    i++;
                    beginIndex++;
                }
            }


        }
        for (int m=0;m<26;m++){
            for(int n=0;n<50;n++){
                if (wordResult[m][n] != null){
                    wordResult[m][n].display();
                }
            }
        }

    }

    public void disposeWord(SeqString temp) {
        int j = 0;
        //根据ascii码值-97 获取下标，小写时为负值则加32
        int k = (int)temp.charAt(1)-97;
        if(k<0){
            k = k+32;
        }

        while (wordResult[k][j] != null && j < wordResult.length) {
            if (wordResult[k][j].getWordValue().compareTo(temp) == 0) {
                wordResult[k][j].timeIncreate();
                return;
            }
            j++;
        }
        wordResult[k][j] = new WordWithFrequency(temp);
    }
    public boolean isLetter(char a){
        int val = (int)a;
        if((val>=65 && val<=90)|| (val>=97 && val<=122)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String text = TextReader.readTxtFile("test_text.txt");
        new WordCounter(text).count();
    }
}