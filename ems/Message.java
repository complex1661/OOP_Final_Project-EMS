package ems;
public class Message {
  private String text;
  private String messageSender;
  private EDate date;
  public Message(String txt, String msr) {
    text = txt;
    messageSender = msr;
    date = new EDate();
  }
  public void modifyText(String txt) {
    text = txt;
  }
  public void modifyMessageSender(String msr) {
    messageSender = msr;
  }
  public String getDetail() {
    return "�T��: " + text + "\n"  + "�T���o�e�H: " + messageSender + "\n"  + "���: " + date;
  }

}