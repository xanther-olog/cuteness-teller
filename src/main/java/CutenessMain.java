import threads.ThreadExecutionProcess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CutenessMain {
    public static void main(String[] args){

        String line;
        List<String> classNames = new ArrayList<String>();
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/arkadeep/Downloads/classNames.csv"));
            while ((line = bufferedReader.readLine()) != null){
                if(line.equals("")){
                    continue;
                }
                classNames.add(line);
            }
            bufferedReader.close();
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            for(String currentName : classNames){
                Runnable runnable = new ThreadExecutionProcess(currentName);
                executorService.execute(runnable);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
