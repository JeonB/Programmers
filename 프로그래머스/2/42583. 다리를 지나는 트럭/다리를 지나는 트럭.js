function solution(bridge_length, weight, truck_weights) {
    let time = 0;
    let bridge = Array(bridge_length).fill(0); 
    let current_weight = 0; 
    const trucks = [...truck_weights]

    while (trucks.length > 0 || current_weight > 0) {
        time++;
        current_weight -= bridge.shift(); 

        if (trucks.length > 0) {
            if (current_weight + trucks[0] <= weight) {
                let truck = trucks.shift(); 
                bridge.push(truck);
                current_weight += truck;
            } else {
                bridge.push(0); 
            }
        }
        
    }

    return time;
}
