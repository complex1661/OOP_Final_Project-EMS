/* 因為實現抽象方法不能使用靜態宣告
 * 所以使用方法之前必須new SaveWorker()
 * 
 * void saveFileAs(String dirPath,Worker worker)
 * 參數：欲存放檔案之資料夾名稱、Worker 物件
 * 於指定名稱之資料夾，將Worker存為 Worker職員ID.dat */

package ems;
import java.io.*;

public class SaveWorker extends SaveFile{
  
  public void saveFileAs(String dirPath,Worker worker){
    //檢查、創建目錄
    File dir = new File(dirPath);
    if (!dir.exists() || !dir.isDirectory() ) {
      dir.mkdir();
    }
    //取得職員ID並存為WorkerID.dat
    String fileName = "Worker" + worker.getId() + ".dat";
    File file = new File(dir, fileName);
    //執行後自動關閉
    try (FileOutputStream fileOut = new FileOutputStream(file);
         ObjectOutputStream output = new ObjectOutputStream(fileOut)) {
           output.writeObject(worker);
    } catch (IOException e) {
      System.out.printf("檔案\'%s\'儲存發生錯誤：%s\n", fileName, e);
    }
  }
  
}