//Objective is to find the minimum number of meeting rooms needed, given a 2-D
//array of starting and ending times.

let intervals = [[0, 30], [5, 10], [15, 20]]


//O(nlogn) solution that sorts the starting and ending times separately then
//compares them.

let starts = 0
let ends = 0

for (let interval of intervals) {
    starts.push(interval[0])
    ends.push(intervals[1])
}

starts.sort((a,b) => {
    return a - b
})

ends.sort((a,b) => {
    return a - b
})

let startPointer = 0
let endPointer = 0 
let result = 0

while (startPointer <= intervals.length) {
    //If a start time is AFTER an end time, another meeting room is not needed
    if (starts[startPointer] >= ends[endPointer]) {
        result -= 1
        endPointer++
    }
    result += 1
    startPointer++
}

return result