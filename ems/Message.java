package ems;
public class Message {
  private String text;
  private String messageSender;
  private EDate date;
  private Time timestamp;
  public Message(String txt, String msr) {
    text = txt;
    messageSender = msr;
    date = new EDate();
    timestamp = new Time();
  }
  public void modifyText(String txt) {
    text = txt;
    timestamp = new Time();
  }
  public void modifyMessageSender(String msr) {
    messageSender = msr;
    timestamp = new Time();
  }
  public String getDetail() {
    return "訊息: " + text + "\n"  + "訊息發送人: " + 
      messageSender + "\n"  + "日期: " + date + "\n" + timestamp.toString();
  }

}