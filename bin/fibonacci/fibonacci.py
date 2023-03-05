# 시간초과, 런타임에러 -> 일부 언어는 재귀 호출을 할 수 있는 횟수가 정해져 있고, 횟수를 넘어 재귀 호출을 하면 런타임 에러를 내도록 설계
def solution(n):
    if(n==0):
        return 0
    elif(n==1):
        return 1
    else:
        return solution(n-1)+solution(n-2)

def solution2(n):
    answer = [0,1]
    
    if n < 2:
        return n 
    else:
        for i in range(2,n+1):
            answer.append((answer[i-2]+answer[i-1])%1234567) #기하급수적으로 늘어나는 수를 제어하기 위함
        
        return answer[n]
# while(True):   
#     n = int(input("n값 입력 : "))
#     app=[0,1]
#     for i in range(2,n+1):
#         app.append(app[i-2]+app[i-1]) 
#     print(app[n],round(app[n]/app[n-1], 1) )