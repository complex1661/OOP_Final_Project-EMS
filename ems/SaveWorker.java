/* �]����{��H��k����ϥ��R�A�ŧi
 * �ҥH�ϥΤ�k���e����new SaveWorker()
 * 
 * void saveFileAs(String dirPath,Worker worker)
 * �ѼơG���s���ɮפ���Ƨ��W�١BWorker ����
 * ����w�W�٤���Ƨ��A�NWorker�s�� Worker¾��ID.dat */

package ems;
import java.io.*;

public class SaveWorker extends SaveFile{
  
  public void saveFileAs(String dirPath,Worker worker){
    //�ˬd�B�Ыإؿ�
    File dir = new File(dirPath);
    if (!dir.exists() || !dir.isDirectory() ) {
      dir.mkdir();
    }
    //���o¾��ID�æs��WorkerID.dat
    String fileName = "Worker" + worker.getId() + ".dat";
    File file = new File(dir, fileName);
    //�����۰�����
    try (FileOutputStream fileOut = new FileOutputStream(file);
         ObjectOutputStream output = new ObjectOutputStream(fileOut)) {
           output.writeObject(worker);
    } catch (IOException e) {
      System.out.printf("�ɮ�\'%s\'�x�s�o�Ϳ��~�G%s\n", fileName, e);
    }
  }
  
}