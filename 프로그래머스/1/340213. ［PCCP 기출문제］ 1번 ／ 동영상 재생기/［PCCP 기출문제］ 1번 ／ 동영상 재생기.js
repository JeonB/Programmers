function solution(video_len, pos, op_start, op_end, commands) {
    let answer = '';
    
    const vidieoLength =  Number(video_len.split(":")[0]) * 60 + Number(video_len.split(":")[1])
    
    const currentMinAndSeconds = pos.split(":")
    let currentMin = Number(currentMinAndSeconds[0])
    let currentSec = Number(currentMinAndSeconds[1])
    let current = currentMin * 60 + currentSec
 
    const opStartMinAndSeconds = op_start.split(":")
    const opStart = Number(opStartMinAndSeconds[0]) * 60 + Number(opStartMinAndSeconds[1])
    const opEndMinAndSeconds = op_end.split(":")
    const opEnd = Number(opEndMinAndSeconds[0]) * 60 + Number(opEndMinAndSeconds[1])
    
   if(opStart <= current && current <= opEnd) current = opEnd
    
    for(const command of commands){
        if(command === "prev"){
            if(current <= 10) current = 0
            else current -= 10
        }else if(command === "next"){
            if(current + 10 > vidieoLength) current = vidieoLength
            else current += 10
        }
        
        if(opStart <= current && current <= opEnd) current = opEnd
    }
    
    let resultMin = String(Math.floor(current/60))
    let resultSec = String(current%60)
    
    if(resultMin.length < 2) resultMin = "0" + resultMin
    if(resultSec.length < 2) resultSec = "0" + resultSec
    
    answer = resultMin+ ":" + resultSec
    
    return answer;
}