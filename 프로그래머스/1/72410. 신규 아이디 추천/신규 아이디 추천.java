class Solution {
    public String solution(String new_id) {
    
        //1단
        new_id = new_id.toLowerCase();
        //2단
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]","");
        //3단
        new_id = new_id.replaceAll("\\.+",".");
        //4단
        new_id = new_id.replaceAll("^\\.+|\\.+$","");
        //5단
        if(new_id.isEmpty()) new_id = "a";
        //6단
        if(new_id.length() > 15){
            new_id = new_id.substring(0,15);
            new_id = new_id.replaceAll("\\.+$","");
        }
        //7단
        while(new_id.length() < 3){
            new_id += new_id.charAt(new_id.length()-1);
        }
       
        return new_id;
    }
}