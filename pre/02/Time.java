class Time {
      public static void main(String[] args){
        int hour = 23;
        int minute = 17;
        int second = 6;
        int hour1 = 23;
        int minute1 = 31;
        int second1 = 27;
        System.out.println("number of seconds since midnight:");
        System.out.println( (hour*60*60) + (minute*60) + (second) + " seconds");
        System.out.println("number of seconds remaining in the day:");
        System.out.println( (23-hour)*60*60 + (59-minute)*60 + (60-second) + " seconds");
        System.out.println("percentage of the day that has passed:");
        System.out.println( ((hour*60*60) + (minute*60) + (second))*100 / (24*60*60) + "%");
        System.out.println("elapsed time since program start:");
        System.out.println( (hour1-hour)*60*60 + (minute1-minute)*60 + (second1-second) + " seconds");
      }
}
