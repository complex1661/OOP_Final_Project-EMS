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
    return "�T��: " + text + "\n"  + "�T���o�e�H: " + 
      messageSender + "\n"  + "���: " + date + "\n" + timestamp.toString();
  }

}