package tools;

import java.io.*;

/**
 * Created by pie on 2015-6-6.
 */
public class TextReader {
    public static String readTxtFile(String filePath) {
        InputStreamReader inputReader = null;
        BufferedReader bufferReader = null;
        OutputStream outputStream = null;
        StringBuffer strBuffer = new StringBuffer();
        try
        {
            InputStream inputStream = new FileInputStream(filePath);
            inputReader = new InputStreamReader(inputStream);
            bufferReader = new BufferedReader(inputReader);

            // ∂¡»°“ª––
            String line = null;
            while ((line = bufferReader.readLine()) != null)
            {
                strBuffer.append(line);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return strBuffer.toString();
    }
    public static void main(String[] args){
        String str = TextReader.readTxtFile("test_text.txt");
        System.out.print(str);
    }

}
