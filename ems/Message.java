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
    return "訊息: " + text + "\n"  + "訊息發送人: " + messageSender + "\n"  + "日期: " + date;
  }

}