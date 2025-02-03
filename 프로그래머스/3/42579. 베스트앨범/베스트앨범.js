function solution(genres, plays) {
    const sumGenre = {}
    const sumGenreArr = []
    const genreSort = {}
    const answer = []
    
    genres.forEach((genre,index) => {
        if(!sumGenre[genre]){
            sumGenre[genre] = plays[index]
            genreSort[genre] = [[index,plays[index]]]
        }else{
            sumGenre[genre] += plays[index]
            genreSort[genre].push([index,plays[index]])
        }
    })
    for (const [key, value] of Object.entries(sumGenre)) {
        sumGenreArr.push([key, value] )
    }
    sumGenreArr.sort((a,b) => b[1] - a[1])
    for(const genre in genreSort){
        genreSort[genre].sort((a,b) => b[1] - a[1])
    }
    for(let i = 0 ; i < sumGenreArr.length ; i++){
        const genre = sumGenreArr[i][0]
        answer.push(genreSort[genre][0][0])
        if (genreSort[genre].length > 1) { // 두 번째 곡이 존재할 경우
            answer.push(genreSort[genre][1][0]);
        }
    }
    
    return answer
}