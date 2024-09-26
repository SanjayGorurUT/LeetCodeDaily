
let bookings = [[]];

var MyCalendar = function() {
    bookings = [[]];
};

/** 
 * @param {number} start 
 * @param {number} end
 * @return {boolean}
 */
MyCalendar.prototype.book = function(start, end) {
    for(let i = 0; i < bookings.length; i++) {
        if(bookings[i][0] <= start && bookings[i][1] > start) {
            return false;
        }
        if(bookings[i][0] < end && bookings[i][1] >= end) {
            return false;
        }
        if(bookings[i][0] >= start && bookings[i][0] < end) {
            return false;
        }
        if(bookings[i][1] > start && bookings[i][1] <= end) {
            return false;
        }
    }
    let newBooking = [];
    newBooking.push(start);
    newBooking.push(end);
    bookings.push(newBooking);
    return true;
};

/** 
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = new MyCalendar()
 * var param_1 = obj.book(start,end)
 */