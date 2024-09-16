/**
 * @param {string[]} timePoints
 * @return {number}
 */
var findMinDifference = function(timePoints) {
    let militaryTimes = [];
    for(let i = 0; i < timePoints.length; i++) {
        let [hour, minutes] = [Number(timePoints[i].substring(0, 2)), 
                              Number(timePoints[i].substring(3))];
        militaryTimes.push((hour * 60) + minutes);
    }
    militaryTimes = militaryTimes.sort((i, j) => i - j); // n log n
    let minDiff = militaryTimes[militaryTimes.length - 1] - militaryTimes[0];
    for(let i = 0; i < militaryTimes.length - 1; i++) {
        minDiff = Math.min(minDiff, militaryTimes[i + 1] - militaryTimes[i]);
    }
    minDiff = Math.min(minDiff, 
    militaryTimes[0] - militaryTimes[militaryTimes.length - 1] + 1440); // Changed this line
    return minDiff;
};