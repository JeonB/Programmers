function solution(s){
   
    s = s.toUpperCase();

    let ps = s.length - s.replaceAll("P","").length
    let ys = s.length - s.replaceAll("Y","").length
    

    return ps == ys;
}